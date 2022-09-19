package ru.job4j.tracker;

import java.util.Comparator;

public class ItemAscByName implements Comparator<Item> {
    @Override
    public int compare(Item item, Item item1) {
        return item.getName().compareTo(item1.getName());
    }
}