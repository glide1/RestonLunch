package com.rivetlogic.restonlunch.restaurant;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: minhan
 * Date: 6/6/13
 * Time: 3:48 PM
 * To change this template use File | Settings | File Templates.
 */
public interface RestaurantRepository {
    List<Restaurant> getAll();

    Restaurant getByName(String restaurantName);
}
