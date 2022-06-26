package ru.job4j.poly;

public class Bus implements Transport {
    private int number = 0;
    private double fuel = 0;

    @Override
    public void drive() {
        System.out.println("Автобус поехал ");

    }

    @Override
    public void passengers(int number) {
        this.number = number;
        if (number == 20)  {
            drive();
        } else {
            System.out.println("необходимо ждать, пока автобус не заполнится ");
        }
    }

    @Override
    public double fuel(double fuel) {
        return fuel * 60;
    }
}
