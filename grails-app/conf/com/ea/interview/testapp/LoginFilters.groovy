package com.ea.interview.testapp

class LoginFilters {

    def filters = {
        all(controller:'login', action:'index', invert: true) {
            before = {
				if (session["user"] == null) {
					redirect(controller: 'login')
					return false
				 }
            }
        }
    }

}
