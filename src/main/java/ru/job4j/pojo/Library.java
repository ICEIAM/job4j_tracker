package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 19);
        Book crimeAndPunishment = new Book("Преступление и наказание", 400);
        Book whiteNights = new Book("Белые ночи", 250);
        Book warAndPeace = new Book("Война и Мир", 4000);
        Book[] shelf = new Book[4];
        shelf[0] = cleanCode;
        shelf[1] = crimeAndPunishment;
        shelf[2] = whiteNights;
        shelf[3] = warAndPeace;
        for (int index = 0; index < shelf.length; index++) {
            Book wholeShelf = shelf[index];
            System.out.println(wholeShelf.getName() + " - " + wholeShelf.getPages());
        }
        for (int index = 0; index < shelf.length; index++) {
            Book temp = shelf[0];
            shelf[0] = shelf[3];
            Book wholeShelf = shelf[index];
            shelf[3] = temp;
            System.out.println(wholeShelf.getName() + " - " + wholeShelf.getPages());
        }

        for (int index = 0; index < shelf.length; index++) {
            Book wholeShelf = shelf[index];
            if ("Clean code".equals(wholeShelf)) {
                System.out.println(wholeShelf.getName() + " - " + wholeShelf.getPages());
            }
        }
    }
    }