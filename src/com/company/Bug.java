package com.company;

import java.util.Scanner;

public class Bug {
    private String ProjectName, Tester, Summary,Steps_to_reproduce, Isolation;
    private Date Date_opened;

    public Bug() {
        //Default
    }
    public Bug(String projectName, String tester, String summary, String steps_to_reproduce, String isolation, Date date_opened) {
        ProjectName = projectName;
        Tester = tester;
        Summary = summary;
        Steps_to_reproduce = steps_to_reproduce;
        Isolation = isolation;
        Date_opened = date_opened;
    }

    public String getProjectName() {
        return ProjectName;
    }

    public String getTester() {
        return Tester;
    }

    public String getSummary() {
        return Summary;
    }

    public String getSteps_to_reproduce() {
        return Steps_to_reproduce;
    }

    public String getIsolation() {
        return Isolation;
    }
    public Date getDate_opened() {
        return Date_opened;
    }

    public Bug addBug() {
        Scanner input = new Scanner(System.in);
        System.out.print("\n==================================\n");
        System.out.print("Project name: ");
        String p_name = input.nextLine();
        System.out.print("Tester: ");
        String tester = input.nextLine();
        System.out.print("Summary: ");
        String summary = input.nextLine();
        System.out.print("Steps to reproduce: ");
        String steps = input.nextLine();
        System.out.print("Isolation: ");
        String isolation = input.nextLine();
        System.out.println("======Date created========");
        System.out.print("");
        System.out.print("Day: ");
        String day = input.next();
        System.out.print("Month: ");
        String month = input.next();
        System.out.print("Year: ");
        String year = input.next();
        return new Bug(p_name,tester,summary,steps,isolation,new Date(year,month,day));
    }

    @Override
    public String toString() {
        return "Bug:\n" +
                "Project Name: " + ProjectName +
                "\nTester: " + Tester +
                "\nSummary: " + Summary +
                "\nSteps to reproduce: " + Steps_to_reproduce +
                "\nIsolation: " + Isolation +
                "\nDate opened: " + Date_opened;
    }
}
