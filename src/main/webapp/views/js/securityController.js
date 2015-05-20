'use strict';
var securityController = angular.module('securityControllers',['securityServices','ngCookies']);
securityController.controller('loginController',['$scope','$rootScope','$location','$cookieStore','UserService',
    function($scope, $rootScope, $location, $cookieStore, UserService){
        $scope.rememberMe = false;
        $scope.login = function(){
            UserService.authenticate($.param({username:$scope.username,password:$scope.password}),
                //success connection
            function(authenticationResult){
                var authToken = authenticationResult.token;
                $rootScope.authToken = authToken;
                if ($scope.rememberMe){
                    $cookieStore.put('authToken',authToken);
                }
                UserService.get(function(user){
                    $rootScope.user = user;
                    $location.path("/")
                })
            }, // unsuccess connection
                function(error){
                    if (error.status == "401"){
                        $rootScope.error =" user name or passoword is not correct";
                    }
                })
        }
    }]);


var securityService  = angular.module('securityServices',['ngResource']);
securityService.factory('UserService',function($resource){
    return $resource('user/:action',{},
        {
            authenticate:{
                method: 'POST',
                params: {'action' : 'authenticate'},
                header: {'Content-Type':'application/x-www-form-urlencoded'}
            }
        })
});