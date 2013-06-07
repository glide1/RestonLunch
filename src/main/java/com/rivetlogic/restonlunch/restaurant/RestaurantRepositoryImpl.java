package com.rivetlogic.restonlunch.restaurant;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: minhan
 * Date: 6/6/13
 * Time: 4:04 PM
 * To change this template use File | Settings | File Templates.
 */
@Service
public class RestaurantRepositoryImpl implements RestaurantRepository {

    private static final List<Restaurant> RESTAURANTS;

    static {
        RESTAURANTS = new ArrayList<Restaurant>();
        RESTAURANTS.add(Restaurant.createRestaurant("Pho 75"));
        RESTAURANTS.add(Restaurant.createRestaurant("Charcoal Kabob"));
        RESTAURANTS.add(Restaurant.createRestaurant("Virginia Kitchen"));
        RESTAURANTS.add(Restaurant.createRestaurant("Euro Bistro"));
    }


    @Override
    public List<Restaurant> getAll() {
        return Collections.unmodifiableList(RESTAURANTS);
    }

    @Override
    public Restaurant getByName(String restaurantName) {
        for (Restaurant restaurant : RESTAURANTS) {
            if (restaurant.getName().equalsIgnoreCase(restaurantName)) {
                return restaurant;
            }
        }
        return null;  //To change body of implemented methods use File | Settings | File Templates.
    }
}
