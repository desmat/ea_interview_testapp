package com.ea.interview.testapp

import static groovyx.net.http.ContentType.*
import groovyx.net.http.*

class TickerService {

    def TickerNews yahooRssHeadlines(Ticker ticker) {
		def news = new TickerNews(ticker: ticker)
		news.tickerNewsItems = new HashSet<TickerNewsItem>()
		
		def xml = new XmlParser().parse('http://feeds.finance.yahoo.com/rss/2.0/headline?s=' + ticker.symbol + '&region=US&lang=en-US');
		//println xml.channel.title.text()
		xml.channel.item.each {  // iterate over each XML 'status' element in the response:
			//println it.title.text()
			news.tickerNewsItems.add(new TickerNewsItem(title: it.title.text(), description: it.description.text(), url: it.link.text()))
		}
		
		news
    }
		
    def TickerNews yahooRssHeadlines(Collection tickers) {
		def news = new TickerNews(ticker: null)
		news.tickerNewsItems = new HashSet<TickerNewsItem>()
		
		def tickerCsv = ""
		for(Ticker t : tickers) {
			tickerCsv += t.symbol + ","
		}
		
		def xml = new XmlParser().parse('http://feeds.finance.yahoo.com/rss/2.0/headline?s=' + tickerCsv + '&region=US&lang=en-US');
		//println xml.channel.title.text()
		xml.channel.item.each {  // iterate over each XML 'status' element in the response:
			//println it.title.text()
			news.tickerNewsItems.add(new TickerNewsItem(title: it.title.text(), description: it.description.text(), url: it.link.text()))
		}

		news
    }
}
