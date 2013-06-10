"use strict";

function RestaurantVoteCtrl($scope, $http) {
  //$scope.votes = 0;

  var baseContext = '';

  $scope.init = function(name, context) {
    baseContext = context;
    $http.post(baseContext + '/restaurants/getVote.html', name)
      .success(function(data) {
        $scope.votes = data;
      });

  };

  $scope.vote = function(restaurantName) {
    $http.post(baseContext + '/restaurants/vote.html', restaurantName)
      .success(function(data) {
        $scope.votes = data;
      });
  };
}