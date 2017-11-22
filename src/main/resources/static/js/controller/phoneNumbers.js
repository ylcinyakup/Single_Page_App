app.controller('phoneNumbersCtrl', [
		'$scope',
		'$http',
		'$state',
		'phoneService',
		function($scope, $http, $state, phoneService) {
			$scope.phoneNumber = {};

			// asdCtrl ye gelen bir link var bu link
			// /users/{userId}/phoneNumbers
			$scope.userId = $state.params.userId;
			console.log('state params:', $state.params.userId);
			// gelmişmi kontrol ediyoruz gelmiş ise devam

			phoneService.getUserPhoneNumbers($state.params.userId).then(
					function(response) {
						$scope.phoneNumbers = response.data;
					})

			$scope.getUserPhoneNumbers = function() {
				phoneService.getUserPhoneNumbers($state.params.userId).then(
						function(response) {
							$scope.phoneNumbers = response.data;
						})
			};

			$scope.createPhoneNumber = function(userId, phoneNumber) {
				phoneService.createPhoneNumber(userId, phoneNumber).then(
						function(response) {
							$scope.phoneNumbers = response.data;
						})
			};

			$scope.updatePhoneNumber = function(userId, phoneId, phoneNumber) {
				phoneService.updatePhoneNumber(userId, phoneId, phoneNumber)
						.then(function(response) {
							$scope.phoneNumbers = response.data;
						})

			};

			$scope.deletePhoneNumber = function(userId, phoneId) {
				phoneService.deletePhoneNumber(userId, phoneId).then(
						function(response) {
							$scope.phoneNumbers = response.data;
						})
			};

		} ]);