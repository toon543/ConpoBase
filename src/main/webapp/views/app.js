'use strict';

// Declare app level module which depends on views, and components
var prejectApp = angular.module('prejectApp', [
    'ngRoute',
    'ngAnimate',
    'homeControllers',
    'securityControllers',
    'registerControllers',
    'historyControllers',
    'activityMainControllers',
    'questionMainControllers',
    'languageControllers',
    'languageServices',
    'pascalprecht.translate',
    'flow',
    'securityControllers'
])
prejectApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.
            when('/home',{
                templateUrl: 'template/home.html',
                controller: 'homeController'
            }).
            when('/register',{
                templateUrl: 'template/register.html',
                controller: 'addUserController'
            }).
            when('/map',{
                templateUrl: 'template/map.html',
                controller: ''
            }).
            when('/history',{
                templateUrl: 'template/history.html',
                controller: 'showHistoryController'
            }).
            when('/history/:id',{
                templateUrl: 'template/editHistory.html',
                controller: 'editHistoryController'
            }).
            when('/contact',{
                templateUrl: 'template/contact.html',
                controller: ''
            }).
            when('/activity',{
                templateUrl: 'template/activitylist.html',
                controller: 'listActivityController'
            }).
            when('/addActivity',{
                templateUrl: 'template/addActivity.html',
                controller: 'addActivityController'
            }).
            when('/activity/:id',{
                templateUrl: 'template/activity.html',
                controller: 'editActivityController'
            }).
            when('/edit/:id',{
                templateUrl: 'template/addActivity.html',
                controller: 'editActivityController'
            }).
            when('/question',{
                templateUrl: 'template/questionList.html',
                controller: 'listQuestionController'
            }).
            when('/question/:id',{
                templateUrl: 'template/answerQuestion.html',
                controller: 'editQuestionController'
            }).when('/gallery',{
                templateUrl: 'template/gallery.html',
                controller: 'listActivityController'
            }).when('/gallery/:id',{
                templateUrl: 'template/album.html',
                controller: 'editActivityController'
            }).
            otherwise({redirectTo: '/home'});
    }]);


prejectApp.config(['$locationProvider', '$httpProvider', function($locationProvider, $httpProvider){
    /* Register error provider that shows message on failed requests or redirects to login page on
     * unauthenticated requests */
    $httpProvider.interceptors.push(function($q,$rootScope,$location){
        return {
            'responseError': function(rejection){
                var status = rejection.status;
                var config = rejection.config;
                var method = config.method;
                var url = config.url;

                if (status == 401){
                    $location.path("/home");
                }else{
                    $rootScope.error = method + " on " + url + " failed with status " + status;
                }
                return $q.reject(rejection);
            }
        }
    });

    /* Registers auth token interceptor, auth token is either passed by header or by query parameter
     * as soon as there is an authenticated user */
    var exampleAppConfig = {
        /* When set to false a query parameter is used to pass on the auth token.
         * This might be desirable if headers don't work correctly in some
         * environments and is still secure when using https. */
        useAuthTokenHeader: true
    };

    $httpProvider.interceptors.push(function ($q,$rootScope,$location){
        return {
            'request' : function(config){
                if (angular.isDefined($rootScope.authToken)){
                    var authToken = $rootScope.authToken;
                    if (exampleAppConfig.useAuthTokenHeader){
                        config.headers['X-Auth-Token'] = authToken;
                    }else{
                        config.url = config.url + "?token=" + authToken;
                    }
                }
                return config || $q.when(config);
            }

        }
    })

}]).run(function($rootScope,$location,$cookieStore,UserService){
    $rootScope.$on('$viewContentLoaded',function(){
        delete $rootScope.error;
    });

    $rootScope.hasRole = function(role) {
        if ($rootScope.user == undefined){
            return false;
        }

        if ($rootScope.user.roles[role] == undefined){
            return false;
        }

        return $rootScope.user.roles[role];
    }

    $rootScope.logout = function() {
        delete $rootScope.user;
        delete $rootScope.authToken;
        $cookieStore.remove('authToken');
        $location.path("/home")
    }

    /* Try getting valid user from cookie or go to login page */
    var originalPath = $location.path();
    $location.path("/home");
    var authToken = $cookieStore.get('authToken');
    if (authToken != undefined){
        $rootScope.authToken = authToken;
        UserService.get(function(user){
            $rootScope.user = user;
            $location.path(originalPath);
        })
    }
    $rootScope.initialized = true;
});

prejectApp.config(function($translateProvider){
    $translateProvider.useUrlLoader('/messageBundle');
    $translateProvider.useStorage('UrlLanguageStorage');
    $translateProvider.preferredLanguage('en');
    $translateProvider.fallbackLanguage('en');
})

prejectApp.config(['$compileProvider', function($compileProvider) {
    $compileProvider.aHrefSanitizationWhitelist(/^\s*(https?|file|data):/);
}]);