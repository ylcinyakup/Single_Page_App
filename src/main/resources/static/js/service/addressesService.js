app.service('addressService', function($http) {

	this.getUserAddresses = function(userId) {
		return $http.get('/users/'+userId+'/addresses')
	}
	
	this.createAddress = function(userId, address) {
		return $http.post('/users/'+userId+'/addresses', address)
	}
	
	this.deleteAddress = function(userId, addressId){
		return $http.delete('/users/'+userId+'/addresses/'+addressId)
	}
	
	this.updateAddress = function(userId,addressId,address){
		return $http.put('/users/'+userId+'/addresses/'+addressId,address)
	}
	
	
});
