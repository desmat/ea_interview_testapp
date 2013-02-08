<%@ page import="com.ea.interview.testapp.Ticker" %>
<%@ page import="com.ea.interview.testapp.TickerNews" %>
<%@ page import="com.ea.interview.testapp.TickerNewsItem" %>



<div class="fieldcontain ${hasErrors(bean: tickerInstance, field: 'symbol', 'error')} ">
	<label for="symbol">
		<g:message code="ticker.symbol.label" default="Symbol" />
		
	</label>
	<g:textField name="symbol" value="${tickerInstance?.symbol}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: tickerInstance, field: 'name', 'error')} ">
	<label for="name">
		<g:message code="ticker.name.label" default="Name" />
		
	</label>
	<g:textField name="name" value="${tickerInstance?.name}"/>
</div>

