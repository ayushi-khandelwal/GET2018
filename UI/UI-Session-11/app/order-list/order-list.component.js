angular.module('orderList')
	.component('orderList', {
        templateUrl: "order-list/order-list.template.html",
        controller: function OrdersController($http, $scope) {
            $scope.cartCount = 0;

            $http.get('http://localhost:3000/products').then(function(response){
                $scope.items = response.data;
                var item;
                for(item in $scope.items){
                    $scope.cartCount += $scope.items[item].quantity;
                }
            });

            $http.get('http://localhost:3000/orders').then(function(response){
                $scope.orders = response.data;
            });

            $scope.getOrder = function(orderId){
            
                $http.get('http://localhost:3000/orders/'+ orderId).then(function(response){
                    $scope.items = response.data.items;
                    var item;
                    $scope.totalPrice=0;
                    for(item in $scope.items){
                        $scope.totalPrice += parseFloat($scope.items[item].price);  
                    }
                });
            }
        }
    });