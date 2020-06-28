package com.kael.java.build;

public class KFCWaiter {
   private final AbstractMealBuilder abstractMealBuilder;

    public KFCWaiter(AbstractMealBuilder abstractMealBuilder) {
        this.abstractMealBuilder = abstractMealBuilder;
    }

    public Meal construct() {
        abstractMealBuilder.buildFood();
        abstractMealBuilder.buildDrink();
        return abstractMealBuilder.getMeal();
    }
}
