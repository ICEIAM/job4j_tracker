package ru.job4j.collection;

import java.util.HashMap;
import java.util.HashSet;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> name = new HashMap<>();
        name.put("dmitriy.lukkin@gmail", "Lukin Dmitriy Dmitrievich");
        for (String key : name.keySet()) {
            String value = name.get(key);
            System.out.println(key + " = " + value);
        }
    }
}
