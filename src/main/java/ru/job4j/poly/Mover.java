package ru.job4j.poly;

public class Mover {
    public static void main(String[] args) {
        Vehicle bus = new Bus1();
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle[] vehicles = new Vehicle[]{bus, plane, train};
        for (Vehicle a : vehicles) {
            a.move();
        }
    }
}
