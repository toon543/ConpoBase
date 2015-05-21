'use strict';
var activityMainController = angular.module('activityMainControllers', ['activityServices']);
activityMainController.controller('addActivityController', ['$scope', '$http', '$location', '$rootScope','activityService',
    function ($scope, $http, $location, $rootScope,activityService) {
        $scope.activity = {};
        $scope.addAc = true;
        $scope.editAc = false;
        $scope.addActivity = function (flowFiles) {
            activityService.save($scope.activity,function(data){
                // after adding the object, add a new picture
                // get the product id which the image will be addded
                var activityid = data.id;
                // set location
                flowFiles.opts.target = '/activityImage/add';
                flowFiles.opts.testChunks = false;
                flowFiles.opts.query ={activityid:activityid};
                flowFiles.upload();

                $rootScope.addSuccess = true;
                $location.path("activity");

                $scope.$apply();


            });
        };


    }]);

activityMainController.controller('listActivityController', ['$scope', '$http', '$rootScope','activityService','$route',
    function ($scope, $http, $rootScope,activityService,$route) {

        activityService.query(function(data){
            $scope.activities = data;
        });


        $scope.$on('$locationChangeStart', function (event) {
            $rootScope.addSuccess = false;
            $rootScope.editSuccess = false;
            $rootScope.deleteSuccess = false;
        });

        $scope.deleteActivity = function (id) {
            var answer = confirm("Do you want to delete the Activity?");
            if (answer) {
                activityService.delete({id:id},function(){
                    $rootScope.deleteSuccess = true;
                    $route.reload();
                })

            }
        }



    }]);
activityMainController.controller('editActivityController', ['$scope','deleteImgService', '$http', '$routeParams', '$location', '$rootScope','activityService','$route',
    function ($scope,deleteImgService, $http, $routeParams, $location, $rootScope,activityService,$route) {
        $scope.addAc = false;
        $scope.editAc = true;
        var id = $routeParams.id;
        $http.get("/activity/" + id).success(function (data) {
            $scope.activity = data;
        });
        $scope.deleteImg = function (id,imgid) {
            var answer = confirm("Do you want to delete the Image?");
            if (answer) {
                deleteImgService.delete({id:id,imgid:imgid},function(){
                    $rootScope.deleteSuccess = true;
                    $route.reload();
                })
            }
        };

        $scope.editActivity = function (flowFiles) {
            console.log( $scope.activity.images);
               $scope.activity.images = null;
            //$http.put("/product", $scope.product).then(function () {
            activityService.update({id:$scope.activity.id},$scope.activity,function(data){
                flowFiles.opts.target = '/activityImage/add';
                flowFiles.opts.testChunks = false;
                flowFiles.opts.query ={activityid:$scope.activity.id};
                flowFiles.upload();
                $rootScope.editSuccess = true;
                $location.path("activity");
                $scope.$apply();
            });
        }
    }]);