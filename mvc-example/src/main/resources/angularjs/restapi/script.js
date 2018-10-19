// Instantiate the app, the 'myApp' parameter must match what is in ng-app
var myApp = angular.module('myApp', ['ngRoute']);

/**
 * Create the controller that lists
 * Using route it is hooked into DOM using ng-view directive
 */
myApp.controller('EmployeeCtrl', function ($scope, EmployeeFactory) {
    EmployeeFactory.listem()
        .then(function (response) {
            $scope.employees = response.data;
        });
});

/**
 * Create the controller for the detail view
 * Using route it is hooked into DOM using ng-view directive
 */
myApp.controller('EmployeeDetailCtrl', function ($scope, $routeParams, EmployeeFactory) {
    $scope.id = $routeParams.id;

    EmployeeFactory.read($routeParams.id)
        .then(function (response) {
            $scope.employee = response.data;
        });
});

myApp.controller('EmployeeAddCtrl', function ($scope, $location, EmployeeFactory) {
    $scope.action = "Add";

    $scope.post = function () {
         EmployeeFactory.create($scope.employee);
         $location.path("#/employees/");

    }
});

myApp.controller('EmployeeUpdateCtrl', function ($scope, $location, $routeParams, EmployeeFactory) {
    $scope.id = $routeParams.id;
    $scope.action = "Modify";
    $scope.showId = true;

    EmployeeFactory.read($routeParams.id)
        .then(function (response) {
            $scope.employee = response.data;
        });

    $scope.post = function () {
        EmployeeFactory.update($scope.employee);
        $location.path("#/employees/");
    }
});

myApp.controller('EmployeeDeleteCtrl', function ($scope, $location, $routeParams, EmployeeFactory) {
    EmployeeFactory.delete($routeParams.id);
    EmployeeFactory.listem()
        .then(function (response) {
            $scope.employees = response.data;
        });

});

