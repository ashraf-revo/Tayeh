'use strict';

angular.module('revolovexApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('imageInfo', {
                parent: 'account',
                url: '/imageinfo/:id',
                data: {
                    roles: [],
                    pageTitle: 'image'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/account/imageinfo/imageInfo.html',
                        controller: 'ImageInfoController'
                    }
                }
            });
    });
