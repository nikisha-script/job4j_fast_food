const app = angular.module('market-front', []);

app.controller('indexController', function ($scope, $http, $rootScope) {
    $scope.foo = function () {
        alert("Hello");
    }
});

