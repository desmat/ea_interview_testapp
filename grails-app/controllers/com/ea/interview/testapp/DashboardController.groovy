package com.ea.interview.testapp

import org.springframework.dao.DataIntegrityViolationException

class DashboardController {

	def tickerService

	static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
		def userInstance = User.get(session["user"].id)
		def tickerNews = tickerService.yahooRssHeadlines(userInstance.tickers)
		render(view: "show", model: [userInstance: userInstance, tickerNews: tickerNews])
    }
}
