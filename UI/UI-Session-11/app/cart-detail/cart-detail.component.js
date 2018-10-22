angular.module('cartDetail').
component('cartDetail',{
    templateUrl: "cart-detail/cart-detail.template.html",
    controller: function CartDetailController($http,$scope,$rootScope){
        $scope.cartCount = $rootScope.totalItemsInCart;
        $scope.totalOrderPrice=0;
        $http.get('http://localhost:3000/cartItems').then(function(response){
            $scope.cartItems = response.data;
            for(var i = 0; i < $scope.cartItems.length; i++) {
                $scope.totalOrderPrice += $scope.cartItems[i].price * $scope.cartItems[i].quantity;
            }
        });

        $scope.deleteAll=function(){
            $scope.cartCount = 0;
            $scope.totalOrderPrice = 0;
            $rootScope.totalItemsInCart = 0;

            for(var i = 0; i < $scope.cartItems.length; i++) {
                $http.delete('http://localhost:3000/cartItems/' + $scope.cartItems[i].id, $scope.cartItems[i]).then(function(response){
                    console.log("deleted product with id " + $scope.cartItems[i].id + " from cart.");
                })
            }
            $scope.cartItems = [];
        }

    }
});