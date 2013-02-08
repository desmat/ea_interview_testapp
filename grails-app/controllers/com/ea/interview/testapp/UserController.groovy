package com.ea.interview.testapp

import org.springframework.dao.DataIntegrityViolationException

class UserController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "show", params: params)
    }

    def save() {
		def userInstance = User.get(session["user"].id)
        if (!userInstance.save(flush: true)) {
            render(view: "create", model: [userInstance: userInstance])
            return
        }

        flash.message = message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
        redirect(controller: "dashboard")
    }

    def edit(Long id) {
		def userInstance = User.get(session["user"].id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(controller: "dashboard")
            return
        }

        [userInstance: userInstance]
    }

    def update(Long id, Long version) {
		def userInstance = User.get(session["user"].id)
        if (!userInstance) {
            flash.message = message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), id])
            redirect(controller: "dashboard")
            return
        }

        if (version != null) {
            if (userInstance.version > version) {
                userInstance.errors.rejectValue("version", "default.optimistic.locking.failure",
                          [message(code: 'user.label', default: 'User')] as Object[],
                          "Another user has updated this User while you were editing")
                render(view: "edit", model: [userInstance: userInstance])
                return
            }
        }

        userInstance.properties = params
		if (params.password != null && params.password.length() > 0) {
			if (params.password != params.confirmPassword) {
	            flash.message = message(code: 'default.password.doesnt.match.message', default: "Passwords don't match")
	            render(view: "edit", model: [userInstance: userInstance])
	            return
			}
			
			userInstance.password = params.password
		}

        if (!userInstance.save(flush: true)) {
			redirect(controller: "dashboard")
            return
        }

        flash.message = message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])
        redirect(controller: "dashboard")
    }
}
