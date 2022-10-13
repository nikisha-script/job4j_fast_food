let findAllDish = 'http://localhost:8183/api/v1/dishes'
let deleteDish = 'http://localhost:8183/api/v1/dishes/'
let addDish = 'http://localhost:8183/api/v1/dishes/orders'
let dishList = [];

class DishDto {
    constructor(name, categoryName, cost) {
        this.name = name;
        this.categoryName = categoryName;
        this.cost = cost;
    }
}

angular.module('market-front', []).controller('indexController', function ($scope, $http, $rootScope) {

    $scope.fillTable = function () {
        $http.get(findAllDish)
            .then(function (response) {
                $scope.dishes = response.data;
            });
    };

    $scope.deleteDish = function (id) {
        $http.delete(deleteDish + id)
            .then(function (response) {
                $scope.fillTable();
            })
    };

    $scope.addDishToOrder = function (id) {
        for (let i = 0; i < $scope.dishes.length; i++) {
            if ($scope.dishes[i].id === id) {
                let dishdto = new DishDto($scope.dishes[i].name,
                    $scope.dishes[i].category.name,
                    $scope.dishes[i].cost);
                dishList.push(dishdto);
                $scope.dishListLength = dishList.length;
            }
        }
    };

   $scope.doOrder = function () {
      $http.post(addDish, dishList)
          .then(function (response) {
              dishList = [];
              console.log(response.data)
          })
    };

    $rootScope.isHasCard = function () {
        return dishList.length !== 0;
    };

    $scope.fillTable();
});

