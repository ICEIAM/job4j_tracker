package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {

    @Override
    public String name() {
        String name2 = "and extra tomato.";
        return super.name() + name2;
    }
}