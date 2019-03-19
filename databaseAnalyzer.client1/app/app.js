'use strict';

// Declare app level module which depends on views, and core components
const databaseAnalyzer = angular.module('databaseAnalyzer', []);

databaseAnalyzer.controller('databaseDetails', function ($scope, $http) {
    //set this to true when connection is successful after selecting provider and connection string
    $scope.connectionSuccessful = false;
    //set this to true when database is selected and tables found
    $scope.databaseFound = false;
    //set this to true when table is selected
    $scope.tableSelected = false;

    $scope.connect = function () {
        //make rest call to get database details and on success set below variable to true
        $http.get("https://localhost:8080/databaseConnection/getDatabases").then(function (response) {
            $scope.databases = response
        })
        $scope.connectionSuccessful = true;
    }
});