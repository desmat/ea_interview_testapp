EA Interview Test App
=====================

This GRAILS test app is my submission for the interview process with EA.


Objective
---------
A simple GRAILS web app that demonstrates my basic knowledge of the GRAILS development platform, and web app development in general.

The main goals are:
1. A GRAILS web application
2. Application is secure in that credentials are required to access
3. The application should be able to pull data from a feed and display to the user


Implementation
--------------
I order to satisfy the stated goals I have developped a web application with the following features:
1. Login is required to access any page except for the login page. 
1.1. Initially the credentials are admin/password, and they are filled in automatically for this demo
1.2. Multi users are supported but a Create User page has not been made available at this time.

With credentials are validated the user has access to the following:

2. Dashboard: a single page that shown all stock tickers associated with the user (initally AAPL and GOOG), along with news story headlines pulled from the yahoo Finance RSS feed concerning all of the user's tickers
2.1. From this page ticker can be deleted
3. Stock ticker specific page which shows only stories associated with the selected stock ticker
3.1. From this page as well a ticker can be deleted
4. A page to create a new stock ticker
4.1. Ticker symbols are not validated at this time. Invalid ticker symbols will be accepted by the system, and the Yahoo feed with return an error in its response.
5. A page to configure account settings such as names and password
5.1. Password needs to match Confirm Password, or leave both fields blank
5.2. username cannot be updated
6. A link to logout from the system

Note that at this time a in-memory database has been configured.


Assumptions
-----------
The following assumptions were made:
1. At this time a single user is required (the admin user)
2. As noted above stock tickers are not validated
3. All strings support internationalization, however only the English string table has been provided
4. Look and feel follows the standard GRAILS scaffolding


Build Instructions
------------------
Simply check out the project within eclipse, build it and run it, or run the grails app-run command




Mathieu Desjarlais
resume@desmat.ca
604-367-8587