
<%@ page import="com.ea.interview.testapp.Ticker" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'ticker.label', default: 'Ticker')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-ticker" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="show-ticker" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list ticker">
			
				<g:if test="${tickerInstance?.symbol}">
				<li class="fieldcontain">
					<span id="symbol-label" class="property-label"><g:message code="ticker.symbol.label" default="Symbol" /></span>
					
						<span class="property-value" aria-labelledby="symbol-label"><g:fieldValue bean="${tickerInstance}" field="symbol"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tickerInstance?.name}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="ticker.name.label" default="Name" /></span>
					
						<span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${tickerInstance}" field="name"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${tickerNews?.tickerNewsItems}">
				<li class="fieldcontain">
					<span id="name-label" class="property-label"><g:message code="ticker.headlines.label" default="Headlines" /></span>
									
					<g:each in="${tickerNews?.tickerNewsItems?}" var="t">
					    <span class="property-value" aria-labelledby="tickers-label"><a target="_blank" href="${t.url}" <g:if test="${t.description != null && t.description.length() > 0}">title="${t.description}"</g:if>>${t.title}</a></span>
					</g:each>
					
				</li>
				</g:if>
			
			</ol>
			<g:form>
				<fieldset class="buttons">
					<g:hiddenField name="id" value="${tickerInstance?.id}" />
					<g:link class="edit" action="edit" id="${tickerInstance?.id}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
