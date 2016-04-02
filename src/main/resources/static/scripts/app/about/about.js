'use strict';

angular.module('tayeh')
    .config(function ($stateProvider) {
        $stateProvider
            .state('about', {
                parent: 'site',
                url: '/about',
                data: {
                    roles: [],
                    pageTitle: 'About'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/about/about.html',
                        controller: 'AboutController'
                    }
                }
            });
    });
