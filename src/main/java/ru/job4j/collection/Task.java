package ru.job4j.collection;

import java.util.HashSet;

public class Task extends HashSet<String> {
    private String number;
    private String description;

    public Task(String number, String description) {
        this.number = number;
        this.description = description;
    }

    public String getNumber() {
        return number;
    }
}