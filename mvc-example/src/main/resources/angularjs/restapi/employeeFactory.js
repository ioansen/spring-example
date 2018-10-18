/**
 * EmployeeFactory is a factory that calls a REST API
 */
myApp.factory('EmployeeFactory', ['$http', function($http) {

    var urlBase = "http://localhost:8080/rest/employees";
    var dataFactory = {};

    dataFactory.listem = function () {
        return $http.get(urlBase);
    };

    dataFactory.create = function (e) {
        return $http.post(urlBase, e);
    };

    dataFactory.read= function (id) {
        return $http.get(urlBase + '/' + id);
    };

    dataFactory.update = function (e) {
        return $http.put(urlBase + '/' + e.id, e)
    };

    dataFactory.delete = function (id) {
        return $http.delete(urlBase + '/' + id);
    };

    return dataFactory;
}]);