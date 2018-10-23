angular.module('shipping')
.component('shipping',{
    templateUrl: "shipping/shipping.template.html",
    controller: function ShippingController($http,$scope,$rootScope) {

        $scope.cartCount = $rootScope.totalItemsInCart;
        $scope.totalOrderPrice=0;
        $scope.totalItemPrice = 0;

        $http.get('http://localhost:3000/cartItems').then(function(response){
            $scope.cartItems = response.data;

            $http.get('http://localhost:3000/products').then(function (response) {
                $scope.products = response.data;

                for(var i = 0; i < $scope.cartItems.length; i++){
                    $scope.totalItemPrice = $scope.cartItems[i].price * $scope.cartItems[i].quantity;
                    $scope.totalOrderPrice = $scope.totalOrderPrice + $scope.totalItemPrice;
                }
            });
        });

        $scope.placeOrder = function() {

            var currentDate = new Date();
            var dd = currentDate.getDate();
                var mm = currentDate.getMonth()+1; //January is 0!
                var yyyy = currentDate.getFullYear();

                currentDate = mm + '/' + dd + '/' + yyyy;

                var cartItems = [];
                for(var i = 0; i < $scope.cartItems.length; i++){
                    if($scope.cartItems[i].quantity > 0) {
                        cartItems.push({
                          'id': $scope.cartItems[i].id,
                          'name': $scope.products[i].name,
                          'price': $scope.products[i].price,
                          'imageUrl': $scope.products[i].image,
                          'quantity': $scope.cartItems[i].quantity
                      });
                    }
                }

                var orderData={
                    "items":cartItems,
                    "customerName":"John Doe",
                    "date":currentDate
                }

                $http({
                    method:'POST',
                    url:'http://localhost:3000/orders',
                    data:orderData,
                    dataType:'json'
                });

                var item=1;

                for(var i = 0; i < $scope.cartItems.length; i++) {
                    $http.delete('http://localhost:3000/cartItems/' + $scope.cartItems[i].id, $scope.cartItems[i]).then(function(response){
                        console.log("deleted product with id " + $scope.cartItems[i].id + " from cart.");
                    })
                }
                $rootScope.totalItemsInCart = 0;

                window.location="#!/products/order-success/";        
            }
            
        }
    });
