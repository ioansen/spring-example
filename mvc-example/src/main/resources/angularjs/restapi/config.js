/**
 * This is the configuration for the routes
 * Maps a URL fragment to a template and controller
 */
myApp.config(function($routeProvider) {
    $routeProvider.
    when('/employees', {
        templateUrl: 'employee-list.html',
        controller: 'EmployeeCtrl'
    }).
    when('/employees/view/:id', {
        templateUrl: 'employee-detail.html',
        controller: 'EmployeeDetailCtrl'
    }).
    when('/employees/delete/:id', {
        templateUrl: 'employee-list.html',
        controller: 'EmployeeDeleteCtrl'
    }).
    when('/employees/add/', {
        templateUrl: 'employee-add.html',
        controller: 'EmployeeAddCtrl'
    }).
    when('/employees/update/:id', {
        templateUrl: 'employee-add.html',
        controller: 'EmployeeUpdateCtrl'
    }).
    otherwise({redirectTo: '/employees'});
});