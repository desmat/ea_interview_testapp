<%@ page import="com.ea.interview.testapp.Login" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'login.label', default: 'Login')}" />
		<title><g:message code="default.edit.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#edit-login" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div id="edit-login" class="content scaffold-edit" role="main">
			<h1><g:message code="default.login.label" default="Login" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<g:hasErrors bean="${loginInstance}">
			<ul class="errors" role="alert">
				<g:eachError bean="${loginInstance}" var="error">
				<li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
				</g:eachError>
			</ul>
			</g:hasErrors>
			<g:form method="post" >
				<fieldset class="form">
					<g:render template="form"/>
				</fieldset>
				<fieldset class="buttons">
					<g:submitButton class="save" name="login" value="${message(code: 'default.button.login.label', default: 'Login')}" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
