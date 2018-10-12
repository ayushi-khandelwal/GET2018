var myApp = angular.module('userManagementApp', []);
myApp.controller('userListController', userListController);

function userListController($scope, $http) {
    $http.get('user-data.json').then(function (response) {
        $scope.users = response.data;
    });

    $scope.addUser = function () {
        if ($scope.name != "") {
            $scope.totalUsers = 4;
            $scope.users.push({
                'id': $scope.totalUsers + 1,
                'name': $scope.name,
                'contact': $scope.contact,
                'location': $scope.address
            });
        } else {
            alert("plz fill fields");
        }
    };

$scope.setUserId = function (key) {
        $scope.users.forEach(element => {
            if (key === element.id) {
                $scope.id = element.id;
                $scope.name = element.name;
                $scope.contact = element.contact;
                $scope.address = element.location;
            }
        });
    }

    $scope.editUser = function () {
        $scope.users.forEach(element => {
            if (element.id == $scope.id) {
                element.name = $scope.name;
                element.contact = $scope.contact;
                element.location = $scope.address;
            }
        });
    }
}
