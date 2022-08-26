package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tracker {
    private final List<Item> items = new ArrayList<Item>();
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        this.items.add(item);
        return item;
    }

    public ArrayList<Item> findAll() {
        return new ArrayList<>(items);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[size];
        int count = 0;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getName().equals(key)) {
                rsl[count] = items.get(index);
                count++;
            }
        }
        return Arrays.copyOf(rsl, count);
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? this.items.get(index) : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        for (Item it : items) {
            if (rsl) {
                item.setId(id);
                items.set(index, item);
                rsl = true;
                break;
            }
        } return rsl;
    }

        public boolean delete(int id) {
            boolean result = false;
            for (int index = 0; index != items.size(); index++) {
                if (this.items.get(index).getId() == id) {
                    this.items.remove(index);
                    result = true;
                    break;
                }
            }
            return result;
        }
    }
