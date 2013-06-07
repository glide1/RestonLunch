"use strict";

function RestaurantVoteCtrl($scope, $http) {
  //$scope.votes = 0;
  $scope.init = function(name) {
    $http.post('/restaurants/getVote.html', name)
      .success(function(data) {
        $scope.votes = data;
      });

  };

  $scope.vote = function(restaurantName) {
    $http.post('/restaurants/vote.html', restaurantName)
      .success(function(data) {
        $scope.votes = data;
      });
  };
}