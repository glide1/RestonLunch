package com.rivetlogic.restonlunch.restaurant;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import com.rivetlogic.restonlunch.CommonModelAttributes;
import com.rivetlogic.restonlunch.TopLevelArea;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.ui.ExtendedModelMap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: minhan
 * Date: 6/6/13
 * Time: 3:38 PM
 * To change this template use File | Settings | File Templates.
 */
@RunWith(MockitoJUnitRunner.class)
public class RestaurantControllerTest {

    @InjectMocks
    RestaurantController classUnderTest;

    @Mock
    RestaurantRepository mockRestaurantRepository;

    ExtendedModelMap modelMap;

    @Before
    public void setup() {
        modelMap = new ExtendedModelMap();
    }

    @Test
    public void restaurantsTest() {
        List<Restaurant> restaurants = new ArrayList<Restaurant>();
        restaurants.add(Restaurant.createRestaurant("Good Eats"));
        restaurants.add(Restaurant.createRestaurant("Chinese Buffet"));
        restaurants.add(Restaurant.createRestaurant("American Burger"));

        when(mockRestaurantRepository.getAll()).thenReturn(restaurants);

        String result = classUnderTest.restaurants(modelMap);

        assertEquals("should have returned the right template", "restaurants", result);
        assertEquals("should have set the restaurants collection", restaurants, modelMap.get("restaurants"));

    }

    @Test
    public void detailsTest() {
        List<Restaurant> restaurants = new ArrayList<Restaurant>();
        restaurants.add(Restaurant.createRestaurant("Good Eats"));
        restaurants.add(Restaurant.createRestaurant("Chinese Buffet"));
        restaurants.add(Restaurant.createRestaurant("American Burger"));

        when(mockRestaurantRepository.getAll()).thenReturn(restaurants);

        Restaurant testRestaurant = Restaurant.createRestaurant("Good Eats");
        when(mockRestaurantRepository.getByName("Good Eats")).thenReturn(testRestaurant);

        String result = classUnderTest.details("Good Eats", modelMap);

        assertNotNull(result);
        assertEquals("details", result);

        assertEquals(TopLevelArea.Restaurants.getName(), modelMap.get(CommonModelAttributes.AREA.getName()));
        assertEquals(testRestaurant, modelMap.get("restaurant"));
        assertEquals(restaurants, modelMap.get("restaurants"));

    }

    @Test
    public void voteTest() {

        Restaurant restaurant = Restaurant.createRestaurant("Good Eats");
        when(mockRestaurantRepository.getByName("Good Eats")).thenReturn(restaurant);

        int result = classUnderTest.vote("Good Eats");

        assertEquals(1, result);
    }

}
