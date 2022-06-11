package ru.job4j.inheritance;

public class PizzaExtraCheeseExtraTomato extends PizzaExtraCheese {
    public String name2 = "and extra tomato.";

    @Override
    public String name() {
        return super.name() + name2;
    }
}
