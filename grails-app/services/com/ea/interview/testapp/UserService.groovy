package com.ea.interview.testapp

class UserService {

	public UserService() {
		//init()
	}
	
	def init() {
		def adminUser = new User(firstName: "Administrator", lastName: "User", username: "admin", password: "password")
		adminUser = adminUser.save()
		
		def ticker = new Ticker(symbol: "AAPL", name: "Apple", user: adminUser);
		ticker.save()
		
		ticker = new Ticker(symbol: "GOOG", name: "Google", user: adminUser);
		ticker.save()
		
		adminUser.save(flush: true)
	}
	
    def User login(Login login) {
		if (User.count() == 0) init();
		
		def user = User.findByUsername(login.username)
		
		if (user == null) throw new Exception('default.login.user.not.found');
		
		if (user.password != login.password) throw new Exception('default.login.invalid.password');
		
		return user; 
    }
}
