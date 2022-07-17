package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            key = value[i];
            if (key != null) {
                rsl = key.length();
            }
            return rsl;
        }
        return rsl;
    }

    public static void main(String[] args) throws ElementNotFoundException {
        String[] test = new String[5];
        try {
            indexOf(test, "key");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}