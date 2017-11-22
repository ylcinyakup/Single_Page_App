app.config(function($stateProvider, $urlRouterProvider) {

	$stateProvider.state("/", {
		url : '/',
		templateUrl : "partials/users.html",
		controller : 'mainCtrl'
	}).state("/author", {
		url : '/author',
		templateUrl : "partials/author.html",
		controller : 'mainCtrl'
	}).state("/phoneNumbers", {
		url : '/users/{userId}/phoneNumbers',
		templateUrl : "partials/phoneNumbers.html",
		controller : 'phoneNumbersCtrl'
	}).state("/addresses", {
		url : '/users/{userId}/addresses',
		templateUrl : "partials/addresses.html",
		controller : 'addressesCtrl'
	})

	$urlRouterProvider.otherwise("/");
});