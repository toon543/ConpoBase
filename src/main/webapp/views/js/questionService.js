'use strict'
var QuestionService = angular.module('QuestionServices',['ngResource']);

QuestionService.factory('questionService',function($resource){
    return $resource('/question/:id', { id: '@_id' }, {
        update: {
            method: 'PUT' // this method issues a PUT request
        }});

})



