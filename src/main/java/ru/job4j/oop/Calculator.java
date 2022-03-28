package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int minus(int b) {
        return x - b;
    }

    public int divide(int c) {
        return x / c;
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
        Calculator calculator2 = new Calculator();
        int rsl2 = calculator2.divide(5);
        System.out.println(rsl2);
        Calculator calculator3 = new Calculator();
        int rsl3 = calculator3.sumAllOperations(4, 5, 10, 5);
        System.out.println(rsl3);
    }
}