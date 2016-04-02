'use strict';

angular.module('tayeh')
    .controller('LogoutController', function (Auth) {
        Auth.logout();
    });
