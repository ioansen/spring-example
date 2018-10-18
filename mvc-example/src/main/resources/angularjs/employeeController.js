mainApp.controller('employeeController', function ($scope,$http,$location,$window) {

    var geturl = "http://localhost:8080/rest/employees";

    $http.get(geturl).then( function(response) {
        $scope.employees = response.data;
    });

    $scope.delete = function (employee) {
        var deleteurl = "http://localhost:8080/rest/employees/" + employee.id;

        $http.delete(deleteurl).then( function(response) {
            console.log(response);
            var index = $scope.employees.indexOf(employee);
            $scope.employees.splice(index,1);
        });
    };

    $scope.action = $location.search().action;

    if($scope.action === 'Modify'){
        $scope.show = true;
        var id = $location.search().id;
        var url = "http://localhost:8080/rest/employees/" + id;

        $http.get(url).then( function(response) {
            $scope.employee = response.data;
        });
        $scope.post = function () {
            var puturl = "http://localhost:8080/rest/employees/" + $scope.employee.id;

            $http.put(puturl,$scope.employee).then( function(response) {
                console.log(response);
                $window.location.href = '/ang/employees.html';

            });
        };

    }
    else{
        $scope.show = false;
        $scope.post = function () {
            var posturl = "http://localhost:8080/rest/employees/";

            $http.post(posturl,$scope.employee).then( function(response) {
                console.log(response);
                $window.location.href = '/ang/employees.html';

            });
        };
    }
});