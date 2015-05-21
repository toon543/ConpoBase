'use strict';

var langController =angular.module('languageControllers',['languageServices']);



    langController.controller('languageController',['$scope','$translate','$location',
        function($scope,$translate,$location){
            $scope.changeLanguage = function(locale){
                $translate.use(locale);
                $location.search('lang',locale);


                //$scope.swapLang;
                //
                //if(locale=='en'){
                //    $scope.swapLang = true;
                //}else{
                //    $scope.swapLang=false;
                //}

            }


        }])