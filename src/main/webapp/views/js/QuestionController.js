/**
 * Created by Punjasin on 5/15/2015.
 */
'use strict';
var questionMainController = angular.module('questionMainControllers', ['QuestionServices']);


questionMainController.controller('addQuestionController', ['$scope', '$http', '$location', '$rootScope','questionService',
    function ($scope, $http, $location, $rootScope,questionService) {
        $scope.question = {};
        $scope.add = true;
        $scope.edit = false;
        $scope.addQuestion = function () {
            questionService.save($scope.question,function(data){
                // after adding the object, add a new picture
                // get the product id which the image will be addded
                // set location

                $rootScope.addSuccess = true;
                $location.path("question");




            });
        };


    }]);

questionMainController.controller('listQuestionController', ['$scope', '$http', '$rootScope','questionService','$route',
    function ($scope, $http, $rootScope,questionService,$route) {

        questionService.query(function(data){

            $scope.questions = data;
        });

        $scope.$on('$locationChangeStart', function (event) {
            $rootScope.add = false;
            $rootScope.edit = false;
            $rootScope.delete = false;
        });

        $scope.deleteQuestion = function (id) {
            var answer = confirm("Do you want to delete the question?");
            if (answer) {
                questionService.delete({id:id},function(){
                    $rootScope.deleteSuccess = true;
                    $route.reload();
                })
            }
        }

        $scope.question = {};
        $scope.addQuestion = function () {
            questionService.save($scope.question, function (data) {
                // after adding the object, add a new picture
                // get the product id which the image will be addded
                var Activityid = data.id;
                // set location

                $rootScope.add = true;


                $route.reload();


            })
        };


    }]);

questionMainController.controller('editQuestionController', ['$scope', '$http', '$routeParams', '$location', '$rootScope','questionService',
    function ($scope, $http, $routeParams, $location, $rootScope,questionService) {
        $scope.add = false;
        $scope.edit = true;
        var id = $routeParams.id;
        $http.get("/question/" + id).success(function (data) {
            $scope.question = data;
        });

        $scope.answer = function () {
            //$http.put("/product", $scope.product).then(function () {
            questionService.update({id:$scope.question.id},$scope.question,function(data){

                $location.path("question");
                $scope.$apply();
            });
        }
    }]);