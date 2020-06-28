package com.kael.java.build;

public class MealA extends AbstractMealBuilder{
    @Override
    void buildFood() {
        meal.setFood("薯条");
    }

    @Override
    void buildDrink() {
        meal.setDrink("可乐");
    }
}
