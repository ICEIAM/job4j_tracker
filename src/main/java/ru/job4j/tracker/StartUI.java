package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.lang.System.*;

public class StartUI {
    public void main(String[] args) {
        Item item = new Item();
        item.getCreated();
        System.out.println(item.getCreated());
    }
}
