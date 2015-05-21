
'use strict';
var historyController = angular.module('historyControllers', ['historyServices']);

historyController.controller('showHistoryController', ['$scope', '$http', '$rootScope','historyService','$route',
    function ($scope, $http, $rootScope,historyService,$route) {

        historyService.query(function(data){
            $scope.historys = data;
        });


    }]);

historyController.controller('editHistoryController', ['$scope','deleteImgHistoryService', '$http', '$routeParams', '$location', '$rootScope','historyService','$route',
    function ($scope,deleteImgHistoryService, $http, $routeParams, $location, $rootScope,historyService,$route) {
        $scope.edit = true;
        var id = $routeParams.id;
        $http.get("/history/" + id).success(function (data) {
            $scope.history = data;
        });
        $scope.deleteImg = function (imgid) {
            var answer = confirm("Do you want to delete the Image?");
            if (answer) {
                deleteImgHistoryService.delete({imgid:imgid},function(){
                    $rootScope.deleteSuccess = true;
                    $route.reload();
                })
            }
        };
        $scope.editHistory = function (flowFiles) {
            //$http.put("/product", $scope.product).then(function () {
            historyService.update({id:$scope.history.id},$scope.history,function(data){
                $rootScope.editSuccess = true;
                flowFiles.opts.target = '/historyImage/add';
                flowFiles.opts.testChunks = false;
                flowFiles.opts.query ={historyid:$scope.history.id};
                flowFiles.upload();
                $rootScope.editSuccess = true;
                $location.path("history");
                $scope.$apply();

            });
        }
    }]);