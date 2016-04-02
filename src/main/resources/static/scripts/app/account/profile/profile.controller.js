'use strict';
angular.module('tayeh')
    .controller('ProfileController', function ($http, $rootScope, $scope) {
        $http.get("/api/images").success(function (child) {
            $scope.child = child;
        });
    });