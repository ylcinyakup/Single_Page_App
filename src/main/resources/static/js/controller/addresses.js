app.controller('addressesCtrl', [
		'$scope',
		'$http',
		'$state',
		'addressService',
		function($scope, $http, $state, addressService) {
			$scope.address = {};

			// asdCtrl ye gelen bir link var bu link
			// /users/{userId}/phoneNumbers
			$scope.userId = $state.params.userId;
			console.log('state params:', $state.params.userId);
			// gelmişmi kontrol ediyoruz gelmiş ise devam

			addressService.getUserAddresses($state.params.userId).then(
					function(response) {
						$scope.addresses = response.data;
					})

			$scope.getUserAddresses = function() {
				addressService.getUserAddresses($state.params.userId).then(
						function(response) {
							$scope.addresses = response.data;
						})
			};

			$scope.createAddress = function(userId, address) {
				addressService.createAddress(userId, address).then(
						function(response) {
							$scope.addresses = response.data;
						})
			};

			$scope.updateAddress = function(userId, addressId, address) {
				addressService.updateAddress(userId, addressId, address).then(
						function(response) {
							$scope.addresses = response.data;
						})

			};

			$scope.deleteAddress = function(userId, addressId) {
				addressService.deleteAddress(userId, addressId).then(
						function(response) {
							$scope.addresses = response.data;
						})
			};

		} ]);