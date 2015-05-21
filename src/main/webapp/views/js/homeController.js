'use strict';

/* Controller */
var homeController = angular.module('homeControllers',['ngAnimate']);

homeController.controller('homeController', function($scope){
    $scope.slides = [
        {image: 'pic/1.JPG', description: 'Image 00'},
        {image: 'pic/2.JPG', description: 'Image 01'},
        {image: 'pic/3.JPG', description: 'Image 02'}
    ];
    $scope.currentIndex = 0;

    $scope.setCurrentSlideIndex = function (index) {
        $scope.currentIndex = index;
    };

    $scope.isCurrentSlideIndex = function (index) {
        return $scope.currentIndex === index;
    };

    $scope.prevSlide = function () {
        $scope.currentIndex = ($scope.currentIndex < $scope.slides.length - 1) ? ++$scope.currentIndex : 0;
    };

    $scope.nextSlide = function () {
        $scope.currentIndex = ($scope.currentIndex > 0) ? --$scope.currentIndex : $scope.slides.length - 1;
    };
});
