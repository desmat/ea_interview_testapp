package com.ea.interview.testapp

class TickerNewsItem {

	String title
	String description
	String url
	
	static belongsTo = [tickerNews: TickerNews]
	
    static constraints = {
		title(empty: false)
    }
}
