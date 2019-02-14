'use strict';

angular.module('book')
    .service('book', function ($http) {
        return {
            list: function (success) {
            	//return $http.get("/_ah/remote_api/book").then(success);
            	return $http.get("/remote_api/book").then(success);
            },
            save: function (book, success) {
            	//return $http.post("/rest/book", book).then(success);
                return $http.post("/remote_api/book", book).then(success);
            },
            delete: function (id, success) {
                return $http.delete("/remote_api/book/"+id).then(success);
            },
            get: function (id, success) {
                return $http.get("/remote_api/book/"+id).then(success);
            },
            search: function (text, success) {
                return $http.get("/remote_api/book/searchBook/"+text).then(success);
            }
        };
    });
