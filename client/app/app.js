'use strict';

// Declare app level module which depends on views, and core components
/*angular.module('myApp', [
  'ngRoute',
  'myApp.view1',
  'myApp.view2',
  'myApp.version'
]).
config(['$locationProvider', '$routeProvider', function($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');

  $routeProvider.otherwise({redirectTo: '/view1'});
}]);*/

// Declare app level module which depends on views, and core components
const databaseAnalyzer = angular.module('databaseAnalyzer', []);

databaseAnalyzer.controller('databaseDetails', function ($scope, $http) {
    //set this to true when connection is successful after selecting provider and connection string
    $scope.connectionSuccessful = false;
    //set this to true when database is selected and tables found
    $scope.databaseFound = false;
    //set this to true when table is selected
    $scope.tableSelected = false;
    //set this to true when table is selected
    $scope.validValues = false;
    $scope.connectionLink = "";

    const defaultServerLink = "https://localhost:8080/"

    $scope.dbProvider = "";
    $scope.connect = function () {
        const databaseListLink = "databaseConnection/getDatabases?key={\"databaseProvider\":\"" + $scope.dbProvider + "\", \"host\":\"" + $scope.connectionLink;
        //make rest call to get database details and on success set below variable to true
        $http.get(databaseListLink).then(function (response) {
            $scope.databases = response;
            $scope.connectionSuccessful = true;
        })
    }

    $scope.enableConnect = function () {
        const pattern = "https?://.+:.+";
        if($scope.connectionLink.length > 0) {
            if ($scope.connectionLink.match(pattern))
                $scope.validValues = true;
            else {
                var element = document.getElementById('urlField');
                element.oninvalid = element.setCustomValidity('Please enter url in form hostname:port');
            }
        }
    }
});