package com.rivetlogic.restonlunch;

public enum CommonModelAttributes {
    AREA("area");

    final String name;

    CommonModelAttributes(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

}
