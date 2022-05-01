package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public static Item[] findAll() {
        Item[] item = null;
        Item[] rsl = new Item[item.length];
        int size = 0;
        for (int index = 0; index < item.length; index++) {
            Item iteml = item[index];
            if (iteml != null) {
                rsl[size] = iteml;
                size++;
            }
        } return Arrays.copyOf(rsl, size);
    }

    public Item[] findByName(String key) {
        Item[]  name = {};
        Item[] rsl = new Item[name.length];
        for (int index = 0; index < name.length; index++) {
            Item namel = name[index];
            if (name != null) {
                rsl[key.length()] = namel;
            }
        }
        rsl = Arrays.copyOf(rsl, key.length());
        return rsl;
    }

    public Item findById(int id) {
        Item rsl = null;
        for (int index = 0; index < size; index++) {
            Item item = items[index];
            if (item.getId() == id) {
                rsl = item;
                break;
            }
        }
        return rsl;
    }
}
