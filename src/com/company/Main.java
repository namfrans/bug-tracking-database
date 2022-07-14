package com.company;

import java.sql.Connection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Database database = new Database();
        Menu menu = new Menu();
        Bug bug = new Bug();
        Scanner kbd = new Scanner(System.in);
        int option;

        Connection connection = database.connectToDatabase("BugTrackingDB", "postgres", "Ndaamapeni083774663");
        //database.createTableBug(con);

        do {
            menu.showMenu();
            option = kbd.nextInt();

            switch (option){
                case 1 -> {
                    Bug newBug = bug.addBug();
                    database.insertBugInfo( connection, newBug.getProjectName(), newBug.getTester(), newBug.getSummary(),
                            newBug.getSteps_to_reproduce(), newBug.getIsolation(), newBug.getDate_opened().toString() );
                }
                case 2 -> {
                    System.out.println("Enter a bug to delete ID: ");
                    int bugId = kbd.nextInt();
                    database.deleteBugByID( connection, bugId );
                }
                case 3 -> database.getBugsTracked( connection );
                case 4 -> {
                    System.out.println("Enter a bug to delete ID: ");
                    int bugId = kbd.nextInt();
                    database.searchBugByID( connection, bugId );
                }
                case 5 -> database.deleteAllBugs( connection );
                case 6 -> System.exit(1);
            }
        }while (true);
    }
}
