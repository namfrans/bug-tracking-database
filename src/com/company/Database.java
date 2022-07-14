package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Database {
    public static final String TEXT_CYAN = "\u001B[36m";
    public static final String TEXT_RESET = "\u001B[0m";

    public Connection connectToDatabase(String db_name, String user, String password) {
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/" + db_name, user, password);
            if (con != null) {
                System.out.println("Connection success!!");
            } else {
                System.out.println("Connection failed!!");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

    /*public void createTableBug(Connection con){
        Statement statement;
        try {
            String query = "CREATE TABLE Bug" + "(bugId INT GENERATED ALWAYS AS IDENTITY, projectName VARCHAR(200), tester VARCHAR(200), " +
                    "summary VARCHAR(200), steps_to_reproduce VARCHAR(200), isolation VARCHAR(200), date_opened DATE, primary key(bugId));";
            statement = con.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table 'Bug' Created successfully!");
        }catch (Exception e){
            System.out.println(e);
        }
    }*/

    public void insertBugInfo(Connection con,String projectName,
                                  String tester, String summary,String  steps_to_reproduce, String isolation, String date_opened){
        Statement statement;
        try {
            String query = String.format("INSERT INTO Bug(projectName,tester,summary," +
                            "steps_to_reproduce,isolation,date_opened) values ('%s','%s','%s','%s','%s','%s')", projectName, tester,
                    summary, steps_to_reproduce, isolation, date_opened);
            statement = con.createStatement();
            statement.executeUpdate(query);
            System.out.println("Information inserted!");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void getBugsTracked(Connection con){
        Statement statement;
        ResultSet rs;
        try {
            String query = "SELECT * FROM Bug";
            statement = con.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()){
                System.out.print("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.print(TEXT_CYAN+"\nBug ID: "+TEXT_RESET+rs.getString("bugId"));
                System.out.print(TEXT_CYAN+"\nProject Name: "+TEXT_RESET+rs.getString("projectName"));
                System.out.print(TEXT_CYAN+"\nTester: "+TEXT_RESET+rs.getString("tester"));
                System.out.print(TEXT_CYAN+"\nSummary: "+TEXT_RESET+rs.getString("summary"));
                System.out.print(TEXT_CYAN+"\nSteps to reproduce: "+TEXT_RESET+rs.getString("steps_to_reproduce"));
                System.out.print(TEXT_CYAN+"\nIsolation: "+TEXT_RESET+rs.getString("isolation"));
                System.out.print(TEXT_CYAN+"\nDate opened: "+TEXT_RESET+rs.getString("date_opened")+"\n");
                System.out.print("**********************************************************************\n");
            }

        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteBugByID(Connection con, int id) {
        Statement statement;
        try {
            String query = String.format("DELETE FROM Bug WHERE bugId = '%s'",id);
            statement = con.createStatement();
            statement.executeUpdate(query);
            System.out.println("Bug deleted successfully.");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void deleteAllBugs(Connection con){
        Statement statement;
        try {
            String query = "DELETE FROM Bug; ALTER SEQUENCE bug_bugid_seq RESTART WITH 1;";
            statement = con.createStatement();
            statement.executeUpdate(query);
            System.out.println("All bugs reports where successfully deleted.");
        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void searchBugByID(Connection con, int id){
        Statement statement;
        ResultSet rs;
        try {
            String query = String.format("SELECT * FROM Bug WHERE bugId = '%s'", id);
            statement = con.createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()){
                System.out.println("^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
                System.out.print(TEXT_CYAN+"\nBug ID: "+TEXT_RESET+rs.getString("bugId"));
                System.out.print(TEXT_CYAN+"\nProject Name: "+TEXT_RESET+rs.getString("projectName"));
                System.out.print(TEXT_CYAN+"\nTester: "+TEXT_RESET+rs.getString("tester"));
                System.out.print(TEXT_CYAN+"\nSummary: "+TEXT_RESET+rs.getString("summary"));
                System.out.print(TEXT_CYAN+"\nSteps to reproduce: "+TEXT_RESET+rs.getString("steps_to_reproduce"));
                System.out.print(TEXT_CYAN+"\nIsolation: "+TEXT_RESET+rs.getString("isolation"));
                System.out.print(TEXT_CYAN+"\nDate opened: "+TEXT_RESET+rs.getString("date_opened"));
                System.out.println("**********************************************************************");
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

}
