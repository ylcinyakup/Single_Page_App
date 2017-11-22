app.service('phoneService', function($http) {

	this.getUserPhoneNumbers = function(userId) {
		return $http.get('/users/'+userId+'/phoneNumbers')
	}
	
	this.createPhoneNumber = function(userId, phoneNumber) {
		return $http.post('/users/'+userId+'/phoneNumbers', phoneNumber)
	}
	this.deletePhoneNumber = function(userId, phoneId){
		return $http.delete('/users/'+userId+'/phoneNumbers/'+phoneId)
	}
	this.updatePhoneNumber = function(userId,phoneId,phoneNumber){
		return $http.put('/users/'+userId+'/phoneNumbers/'+phoneId,phoneNumber)
	}
	
	
});
