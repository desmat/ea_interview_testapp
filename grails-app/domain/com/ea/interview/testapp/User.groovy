package com.ea.interview.testapp

class User {
	
	String username
	String password
	//String confirmPassword
	String firstName
	String lastName
	
	static hasMany = [tickers: Ticker]

    static constraints = {
		username(empty: false)
		firstName(empty: false)
		lastName(empty: false)
    }
	
	def String toString() {
		username
	}
}
