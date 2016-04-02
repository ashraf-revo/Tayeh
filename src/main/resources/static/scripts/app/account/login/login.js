'use strict';

angular.module('tayeh')
    .config(function ($stateProvider) {
        $stateProvider
            .state('login', {
                parent: 'account',
                url: '/login',
                data: {
                    roles: [], 
                    pageTitle: 'login'
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/app/account/login/login.html',
                        controller: 'LoginController'
                    }
                }
            });
    });
