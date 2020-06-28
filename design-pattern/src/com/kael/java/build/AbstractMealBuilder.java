package com.kael.java.build;

public abstract class AbstractMealBuilder {
    Meal meal = new Meal();

    abstract void buildFood();
    abstract void buildDrink();

    public Meal getMeal() {
        return meal;
    }
}
