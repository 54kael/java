package com.kael.java.build;

public class Test {
    public static void main(String[] args) {
        MealA mealA = new MealA();
        KFCWaiter waiter = new KFCWaiter(mealA);
        Meal meal = waiter.construct();
        System.out.println(meal.getFood()+":"+meal.getDrink());
    }
}
