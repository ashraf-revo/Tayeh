'use strict';

angular.module('tayeh')
    .config(function ($stateProvider) {
        $stateProvider
            .state('profile', {
                parent: 'account',
                url: '/profile',
                data: {
                    roles: ['ROLE_USER'],
                    pageTitle: 'profile'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/account/profile/profile.html',
                        controller: 'ProfileController'
                    }
                }
            });
    });
