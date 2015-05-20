'use strict';

var shoppingCartControllers = angular.module('shoppingCartControllers', ['shoppingCartServices']);

shoppingCartControllers.controller('showShoppingCartController',
        ['$scope', 'cartManagement', '$location', '$rootScope','$routeParams',
    function ($scope, cartManagement, $location, $rootScope,$rootParams) {

        if($rootScope.shoppingCart != null){
            $scope.cart = $rootScope.shoppingCart;
        }else{
            var id = $rootParams.id;
            shoppingCartService.get({id:id},function(data){
                $scope.cart = data;
            });
        }

        $scope.$on('$locationChangeStart', function (event) {
            $rootScope.cartUpdateSuccess = false;

        });

        $scope.updateCart = function (cart) {
            cartManagement.updateCart(cart,function(){
                $rootScope.cartUpdateSuccess = true;
            });
        }

        $scope.removeProduct = function (product) {
            cartManagement.removeProduct(product, function(newCart){
                $scope.cart = newCart;
            });
        }

        $scope.saveCart = function (cart) {
            cartManagement.saveCart(cart, function(){
                //success add cart
                console.log("save cart success");
            });
        }

        $scope.emptyCart = function(){
            cartManagement.emptyCart();
        }

        $scope.totalEach = function(index){
            return $scope.cart.selectedProducts[index].product.totalPrice * $scope.cart.selectedProducts[index].amount;
        }

        $scope.total = function(){
            var total = 0;
            angular.forEach($scope.cart.selectedProducts, function(item) {
                total += item.amount * item.product.totalPrice;
            })

            return total;
        }
    }]);
