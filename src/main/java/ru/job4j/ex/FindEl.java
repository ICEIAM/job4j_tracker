package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
            if (rsl == -1) {
                throw new ElementNotFoundException();
            }
        }
        return rsl;
    }

    public static void main(String[] args) throws ElementNotFoundException {
        String[] value2 = new String[] {"Test", "Test2"};
        String key2 = "Test";
        try {
            System.out.println(indexOf(value2, key2));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}