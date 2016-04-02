'use strict';

angular.module('tayeh')
    .config(function ($stateProvider) {
        $stateProvider
            .state('imageInfo', {
                parent: 'account',
                url: '/imageinfo/:id',
                data: {
                    roles: [],
                    pageTitle: 'ImageInfo'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/account/imageinfo/imageInfo.html',
                        controller: 'ImageInfoController'
                    }
                }
            });
    });
