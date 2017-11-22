app.controller('mainCtrl',[
	'$scope', '$http', '$state', 'getUsersService',
	function($scope, $http, $state, getUsersService) {
	$scope.user = {};
	$scope.phoneNumbers = {};
	$scope.onlyNumber = /^[0-9]*$/;

	getUsersService.getUsers().then(function(response) {
		$scope.users = response.data;
	})

	$scope.createUser = function(user) {
		getUsersService.saveUser(user).then(function(response) {
			$scope.users = response.data;
		})
	};
	$scope.deleteUser = function(userId) {
		getUsersService.deleteUser(userId).then(function(response) {
			$scope.users = response.data;
		})
	};
	$scope.updateUser = function(userId,user) {
		getUsersService.updateUser(userId,user).then(function(response) {
			$scope.users = response.data;
		})
	};
}]);