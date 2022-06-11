package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {
    public String name1 = " with extra cheese ";

    @Override
    public String name() {
        return super.name() + name1;
    }
}
