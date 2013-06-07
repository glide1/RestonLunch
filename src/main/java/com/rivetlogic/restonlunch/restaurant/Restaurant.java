package com.rivetlogic.restonlunch.restaurant;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * Created with IntelliJ IDEA.
 * User: minhan
 * Date: 6/6/13
 * Time: 3:52 PM
 * To change this template use File | Settings | File Templates.
 */
public class Restaurant {

    private final String name;
    private AtomicInteger votes;

    private Restaurant(String name) {
        this.votes = new AtomicInteger(0);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getVotes() {
        return this.votes.intValue();
    }

    public int incrementVote() {
        return votes.incrementAndGet();
    }

    public static Restaurant createRestaurant(String name) {
        return new Restaurant(name);
    }

}
