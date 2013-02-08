
<%@ page import="com.ea.interview.testapp.Dashboard" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'dashboard.label', default: 'Dashboard')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<div id="show-dashboard" class="content scaffold-show" role="main">
			<h1><g:message code="default.dashboard.label" default="Dashboard" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list dashboard">
				<g:if test="${userInstance?.tickers}">
				<li class="fieldcontain">
					<span id="tickers-label" class="property-label"><g:message code="user.tickers.label" default="Tickers" /></span>
					
					<g:each in="${userInstance.tickers}" var="t">
						<span class="property-value" aria-labelledby="tickers-label"><g:link title="Drill-down for ${t.name} specific headlines" controller="ticker" action="show" id="${t.id}">${t?.encodeAsHTML()}</g:link> <g:link class="edit" controller="ticker" action="delete" id="${t?.id}" onclick="return confirm('${message(code: 'default.link.delete.confirm.message', default: 'Are you sure?')}');">(<g:message code="default.link.delete.label" default="delete" />)</g:link></span>
					</g:each>
				</li>
				</g:if>
			
				<g:if test="${tickerNews?.tickerNewsItems}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="ticker.headlines.label" default="Headlines" /></span>
									
									
									
					<g:each in="${tickerNews?.tickerNewsItems?}" var="t">
					    <span class="property-value" aria-labelledby="headline-label"><a target="_blank" href="${t.url}" <g:if test="${t.description != null && t.description.length() > 0}">title="${t.description}"</g:if>>${t.title}</a></span>
					</g:each>
				</li>
				</g:if>
			</ol>
		</div>
	</body>
</html>
