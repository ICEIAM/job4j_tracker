package ru.job4j.collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> name = new HashMap<>();
        name.put("dmitriy.lukkin@gmail", "Lukin Dmitriy Dmitrievich");
        for (Map.Entry<String, String> entry : name.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + " = " + value);
        }
    }
}
