package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int minus(int b) {
        return b - x;
    }

    public int divide(int c) {
        return c / x;
    }

    public int sumAllOperations(int b, int c, int y, int a) {
        return minus(b) +  divide(c) + sum(y) + multiply(a);
    }

    public static int sum(int y) {
        return x + y;
    }

        public int multiply(int a) {
            return x * a;
        }

    public static void main(String[] args) {
        int result = Calculator.sum(10);
        System.out.println(result);
        int result1 = Calculator.minus(4);
        System.out.println(result1);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(5);
        System.out.println(rsl);
        int rsl2 = calculator.divide(5);
        System.out.println(rsl2);
        int rsl3 = calculator.sumAllOperations(4, 5, 10, 5);
        System.out.println(rsl3);
    }
}