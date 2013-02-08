package com.ea.interview.testapp

import org.springframework.dao.DataIntegrityViolationException

class TickerController {

	def tickerService
	
    static allowedMethods = [save: "POST", update: "POST", delete: ["POST", "GET"]]

    def index() {
        redirect(controller: "dashboard")
    }

    def create() {
        [tickerInstance: new Ticker(params)]
    }

    def save() {
        def tickerInstance = new Ticker(params)
		def userInstance = User.get(session["user"].id)
		tickerInstance.user = userInstance
		
        if (!tickerInstance.save(flush: true)) {
            render(view: "create", model: [tickerInstance: tickerInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'ticker.label', default: 'Ticker'), tickerInstance.id])
        redirect(action: "show", id: tickerInstance.id)
    }

    def show(Long id) {
        def tickerInstance = Ticker.get(id)
        if (!tickerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ticker.label', default: 'Ticker'), id])
            redirect(controller: "dashboard")
            return
        }

		def tickerNews = tickerService.yahooRssHeadlines(tickerInstance) 
		
        [tickerInstance: tickerInstance, tickerNews: tickerNews]
    }

    def edit(Long id) {
        def tickerInstance = Ticker.get(id)
        if (!tickerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ticker.label', default: 'Ticker'), id])
            redirect(controller: "dashboard")
            return
        }

		def tickerNews = tickerService.yahooRssHeadlines(tickerInstance) 

		[tickerInstance: tickerInstance, tickerNews: tickerNews]
    }

    def update(Long id, Long version) {
        def tickerInstance = Ticker.get(id)
        if (!tickerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ticker.label', default: 'Ticker'), id])
            redirect(action: "list")
            return
        }

        if (version != null) {
            if (tickerInstance.version > version) {
                tickerInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'ticker.label', default: 'Ticker')] as Object[],
                          "Another user has updated this Ticker while you were editing")
                render(view: "edit", model: [tickerInstance: tickerInstance])
                return
            }
        }

        tickerInstance.properties = params

        if (!tickerInstance.save(flush: true)) {
            render(view: "edit", model: [tickerInstance: tickerInstance])
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'ticker.label', default: 'Ticker'), tickerInstance.id])
        redirect(action: "show", id: tickerInstance.id)
    }

    def delete(Long id) {
        def tickerInstance = Ticker.get(id)
        if (!tickerInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'ticker.label', default: 'Ticker'), id])
            redirect(controller: "dashboard")
            return
        }

        try {
            tickerInstance.delete(flush: true)
            flash.message = message(code: 'default.deleted.message', args: [message(code: 'ticker.label', default: 'Ticker'), id])
            redirect(controller: "dashboard")
        }
        catch (DataIntegrityViolationException e) {
            flash.message = message(code: 'default.not.deleted.message', args: [message(code: 'ticker.label', default: 'Ticker'), id])
            redirect(action: "show", id: id)
        }
    }
}
