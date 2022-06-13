package ru.job4j.inheritance;

public class PizzaExtraCheese extends Pizza {

    @Override
    public String name() {
        String name1 = " with extra cheese ";
        return super.name() + name1;
    }
}