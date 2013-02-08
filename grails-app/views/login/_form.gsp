<%@ page import="com.ea.interview.testapp.Login" %>


<div class="fieldcontain ${hasErrors(bean: loginInstance, field: 'username', 'error')} ">
	<label for="username">
		<g:message code="login.username.label" default="Username" />
		
	</label>
	<g:textField name="username" value="${loginInstance?.username}"/>
</div>

<div class="fieldcontain ${hasErrors(bean: loginInstance, field: 'password', 'error')} ">
	<label for="password">
		<g:message code="login.password.label" default="Password" />
		
	</label>
	<g:passwordField name="password" value="${loginInstance?.password}"/>
</div>

