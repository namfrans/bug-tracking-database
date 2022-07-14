package com.company;

public class Menu {
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_RED = "\u001B[31m";

    public void showMenu() {
        System.out.print("============MENU============\n");
        System.out.println("1. Add a bug report.");
        System.out.println("2. Remove a bug reported.");
        System.out.println("3. Show bugs reported.");
        System.out.println("4. Search a bug.");
        System.out.println(TEXT_RED+"5. Reset table."+TEXT_RESET);
        System.out.println("6. Exit.");
    }
}
