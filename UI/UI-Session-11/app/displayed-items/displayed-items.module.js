function displayItemsController($rootScope, $scope, $http) {

	$rootScope.totalItemsInCart = 0;
	$scope.cartQuantities = [];
	$http.get('http://localhost:3000/cartItems').then(function (response) {
		$scope.cartItems = response.data;
		$rootScope.totalItemsInCart = $scope.cartItems.length;
		for (var i =  0; i < $scope.cartItems.length; i++) {
			$scope.cartQuantities[$scope.cartItems[i].id] = $scope.cartItems[i].quantity;
			console.log($scope.cartQuantities);
		}
	});

	$http.get('http://localhost:3000/products').then(function (response) {
		$scope.products = response.data;
	});

	$scope.addToCart = function(product) {
		var newCartItem = {
			id: product.id,
			name: product.name,
			image: product.image,
			price: product.price,
			quantity: 1
		}

		$http({
				method: 'POST',
				url: 'http://localhost:3000/cartItems',
				data: newCartItem,
				dataType: 'json'
			});

		$scope.cartQuantities[product.id] = 1;
		$rootScope.totalItemsInCart++;
	}


	$scope.changeQuantity = function(productId, operation) {
		$http.get('http://localhost:3000/cartItems/' + productId).then(function (response) {
			if (operation == '+') {
				response.data.quantity++;
				$scope.cartQuantities[productId]++;
			} else {
				response.data.quantity--;
				if (response.data.quantity == 0) {
					$http.delete('http://localhost:3000/cartItems/' + productId, response.data).then(function(response){
						console.log("deleted product with id " + productId + " from cart.");
					})
					$rootScope.totalItemsInCart--;
				}
				$scope.cartQuantities[productId]--;	
			}

			$http({
				method: 'PUT',
				url: 'http://localhost:3000/cartItems/' + productId,
				data: response.data,
				dataType: 'json'
			});
		});
	}
}

angular.module('displayedItems',[
    'ngRoute'
]).component('displayedItems', {
	templateUrl: 'displayed-items/displayed-items.template.html',
	controller: displayItemsController
});