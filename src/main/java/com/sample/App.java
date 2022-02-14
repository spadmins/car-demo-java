package com.sample;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.util.Scanner;

import com.sample.model.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    // Scanner sc = new Scanner(System.in);
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main( String[] args )
    {
        App obj = new App();
        obj.mainMenu();
    }

    private void mainMenu() {
        System.out.println("Welcome to Student Management System");
        System.out.println("-------------------------------------");
        System.out.println("1. Add a Student");
        System.out.println("2. Edit Student Details");
        System.out.println("3. Remove a Student");
        System.out.println("4. Search Student Information");
        System.out.println("5. List All Students");
        System.out.println("6. Exit");
        System.out.println("Enter your choice: ");
        int ch = 0;
		try {
			ch = Integer.parseInt(br.readLine());
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
        subMenu(ch);
    }

    private void subMenu(int ch) {
        
        switch(ch) {
            case 1:
                try {
                    System.out.println("Enter Name: ");
                    String argName = br.readLine();
                    System.out.println("Enter Age: ");
                    int argAge = Integer.parseInt(br.readLine());
                    System.out.println("Enter Email: ");
                    String argEmail = br.readLine();
                    String str = new Student().addStudent(argName, argAge, argEmail);
                    System.out.println(str);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                
                mainMenu();
                break;
            case 2: 
                 try {
                    System.out.println("Enter Student Id: ");
                    int id = Integer.parseInt(br.readLine());
                    System.out.println("Enter Age: ");
                    int argAge = Integer.parseInt(br.readLine());
                    System.out.println("Enter Email: ");
                    String argEmail = br.readLine();
                    new Student().updateStudentDetails(id, argAge, argEmail);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                mainMenu();
                break;
            case 3: 
                boolean ans = false;
                try {
                    System.out.println("Enter the Student Id: ");
                    int id = Integer.parseInt(br.readLine());

                    System.out.println("Are you sure you want to remove this student? (Y/N)");
                    char c = br.readLine().charAt(0);

                    if ( c == 'Y' || c == 'y') {
                        ans = new Student().removeStudent(id);

                        if (ans == true) {
                            System.out.println("Student removed from database");
                        } else {
                            System.out.println("Student removal unsuccessful");
                        }
                    }

                } catch(IOException e) {
                    e.printStackTrace();
                }
                mainMenu();
                break;
            case 4:
                try {
                    System.out.println("Enter Student Id: ");
                    int id = Integer.parseInt(br.readLine());
                    new Student().listStudentDetails(id);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mainMenu();
                break;
            case 5: new Student().listAllStudents();
                mainMenu();
                break;
            default: 
                System.out.println("Exiting!!!");
                Runtime.getRuntime().exit(0);
        }
    }
}
