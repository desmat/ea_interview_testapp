package com.ea.interview.testapp

import org.springframework.dao.DataIntegrityViolationException

class LoginController {

    static allowedMethods = [index: ["GET", "POST"]]
	
	def userService

    def index() {
		if (request.method == "POST") {
			def username = params.username
			def password = params.password

			if (username == null || username.length() == 0) {
				flash.message = message(code: 'default.not.empty.message', args: [message(code: 'default.username.label', default: 'Username')])
				render(view: "login", model: [loginInstance: new Login(params)])
				return
			}
			
			if (password == null || password.length() == 0) {
				flash.message = message(code: 'default.not.empty.message', args: [message(code: 'default.password.label', default: 'Password')])
				render(view: "login", model: [loginInstance: new Login(params)])
				return
			}
			
			def login = new Login(params)
			
			try
			{
				def user = userService.login(login)
				session["user"] = user
			}
			catch (Exception e)
			{
				flash.message = message(code: 'default.login.failed', args: [message(code: e.getMessage())])
				render(view: "login", model: [loginInstance: login])
				return
			}
			
			redirect(controller: "dashboard")
			return
		}
		else {
			def login = new Login(params)
			if (login.username == null || login.username.length() == 0) {
				login.username = "admin"
				login.password = "password"
			}
			
			render(view: "login", model: [loginInstance: login])
		}
    }
	
	def logout() {
		session.invalidate()
		render(view: "login", model: [loginInstance: new Login()])
	}
}
