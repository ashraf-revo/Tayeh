'use strict';

angular.module('revolovexApp')
    .controller('ImageInfoController', function ($rootScope, $scope, $state, $http) {
        $http.get('/api/imageInfo/' + $state.params.id)
            .success(function (c) {
                $scope.c = c;
            });
        $http.get('/api/suggested/' + $state.params.id)
            .success(function (child) {
                $scope.child = child;
            });
        $scope.reload = function () {
            $http.post('/api/search', {"id": $state.params.id})
                .success(function (child) {
                    $scope.child = child;
                });
        }
    });
