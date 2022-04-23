package ru.job4j.pojo;

    public class Shop {
        public static int indexOfNull(Product[] products) {
            int i;
            for (i = 0; i < products.length; i++) {
                Product product = products[i];
                if (product == null) {
                    return i;
                }
            } return -1;
        }
    }