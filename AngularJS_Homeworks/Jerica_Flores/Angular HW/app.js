angular.module('myApp', ["ngRoute"])
.config (function($routeProvider){
	$routeProvider
	.when("/",{
		templateUrl: "index.html"
	})
	.when("/form",{
		templateUrl: "form.html"
	})
})
.controller('searchController', function($scope, $http, $location){
$scope.searchUser = '';
$scope.criteria = '';

$scope.search = function (searchUser){
	$scope.criteria = searchUser;
};
$scope.users= [
{name: 'Jerica Flores', email: 'jericaflores427@gmail.com', phone:'09236109223'},
{name: 'Meynard Denoyo', email: 'denoyme@oocl.com', phone:'09158839145'},
{name: 'Jaybee Vergara', email: 'jaybee@oocl.com', phone:'09998902351'},
{name: 'Pauline Joyce Racelis', email: 'pauline@oocl.com', phone: '09557902355'},
{name: 'Mark Anthony Andes', email: 'andes@oocl.com', phone: '09336908766'}
];

$scope.displayUser = function(user){
	$location.path("/form");
	$scope.selectedUser = user;
	console.log($scope.selectedUser);
};

});