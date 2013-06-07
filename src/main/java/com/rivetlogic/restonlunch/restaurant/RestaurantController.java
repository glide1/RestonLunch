package com.rivetlogic.restonlunch.restaurant;

import com.rivetlogic.restonlunch.CommonModelAttributes;
import com.rivetlogic.restonlunch.TopLevelArea;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class RestaurantController {

    private final RestaurantRepository restaurantRepository;

    @Autowired
    public RestaurantController(RestaurantRepository restaurantRepository) {
        this.restaurantRepository = restaurantRepository;
    }

    @RequestMapping(value="/restaurants.html", method = RequestMethod.GET)
    public String restaurants(ModelMap model) {
        model.addAttribute(CommonModelAttributes.AREA.getName(), TopLevelArea.Restaurants.getName());
        model.addAttribute("restaurants", this.restaurantRepository.getAll());
        return "restaurants";
    }

    @RequestMapping(value="/restaurants/details/{restaurantName}.html", method = RequestMethod.GET)
    public String details(@PathVariable("restaurantName") String restaurantName, ModelMap modelMap) {
        modelMap.addAttribute(CommonModelAttributes.AREA.getName(), TopLevelArea.Restaurants.getName());
        modelMap.addAttribute("restaurant", restaurantRepository.getByName(restaurantName));
        modelMap.addAttribute("restaurants", restaurantRepository.getAll());
        return "details";
    }

    @RequestMapping(value="/restaurants/vote.html", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public int vote(@RequestBody String restaurantName) {
        Restaurant restaurant = restaurantRepository.getByName(restaurantName);
        return restaurant.incrementVote();
    }

    @RequestMapping(value="/restaurants/getVote.html", method = RequestMethod.POST)
    @ResponseBody
    public int getVote(@RequestBody String restaurantName) {
        Restaurant restaurant = restaurantRepository.getByName(restaurantName);
        return restaurant.getVotes();
    }

}
