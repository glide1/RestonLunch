package com.rivetlogic.restonlunch;

public enum TopLevelArea {
    Home("home"),
    Restaurants("restaurants");

    private final String name;

    TopLevelArea(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
