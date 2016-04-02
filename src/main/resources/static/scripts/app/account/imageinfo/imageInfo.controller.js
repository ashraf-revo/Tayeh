'use strict';

angular.module('revolovexApp')
    .controller('ImageInfoController', function ($rootScope, $scope, $state, $http) {
        $http.get('/api/imageinfo/'+$state.params.id)
            .success(function (c) {
                $scope.c = c;
            });
    });
