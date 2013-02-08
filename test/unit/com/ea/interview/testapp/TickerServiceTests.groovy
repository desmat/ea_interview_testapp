package com.ea.interview.testapp



import grails.test.mixin.*

import org.junit.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(TickerService)
class TickerServiceTests {

    void testGoogle() {
        def tickerService = new TickerService()
		def tickerNews = tickerService.yahooRssHeadlines(new Ticker(symbol: "GOOG"))
		assertNotNull(tickerNews)
		assertNotNull(tickerNews.tickerNewsItems)
		assertTrue(tickerNews.tickerNewsItems.size() > 0)
    }
}
