<@layout.basic>

<div class="container-fluid">
    <div class="row-fluid">
        <div class="span3">
            <div class="well sidebar-nav">
                <ul class="nav nav-list">
                    <li class="nav-header">Restaurants</li>
                  <#list restaurants as rest>
                      <li <#if rest.name == restaurant.name>class="active"</#if>><a href="/restaurants/details/${rest.name}.html ">${rest.name}</a></li>
                  </#list>
                </ul>
            </div>
        </div>
        <div class="span9" ng-app>
            <div class="hero-unit" ng-controller="RestaurantVoteCtrl" ng-init="init('${restaurant.name}')">
                <h2>${restaurant.name} Votes:<a href="#" ng-click="vote('${restaurant.name}')" ng-bind="votes">${restaurant.votes}</a></h2>
                <#include "restaurants/" + restaurant.name + ".ftl">
            </div>
        </div>
    </div>
</div>

</@layout.basic>