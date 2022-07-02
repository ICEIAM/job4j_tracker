package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman freshman = new Freshman();
        Student1 student = freshman;
        Object obj = freshman;
        System.out.println(new Student1());
        System.out.println(new Freshman());
        System.out.println(new Object());
    }
}
