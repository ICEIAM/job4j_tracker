package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setDate("01.01.2001");
        student.setGroup("Очная");
        student.setName("Dmitriy");
        System.out.println("Студент " + student.getName() + ", группы " + student.getGroup() + ", поступивший " + student.getDate());
    }
}
