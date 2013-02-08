package com.ea.interview.testapp

class Ticker {

	String symbol
	String name

	static belongsTo = [user: User]
		
    static constraints = {
		symbol(empty: false)
		name(empty: false)
    }
	
	def String toString() {
		symbol
	}
}
