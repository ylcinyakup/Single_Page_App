app.service('getUsersService', function($http) {
	this.getUsers = function() {
		return $http.get('/users');
	}
	this.saveUser = function(user) {
		return $http.post('/users/', user)
	}
	this.deleteUser = function(userId){
		return $http.delete('/users/'+userId)
	}
	this.updateUser = function(userId,user){
		return $http.put('/users/'+userId,user)
	}
	
	
});
