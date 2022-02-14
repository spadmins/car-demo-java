package com.sample.util;

import java.util.Scanner;

import com.sample.factory.CarsFactory;
import com.sample.model.Cars;

public class CliMain {

    private Scanner sc = new Scanner(System.in);
    private void mainMenu() {
        System.out.println("1. Add a Car");
        System.out.println("2. List All Cars");
        System.out.println("3. Find A Car");
        System.out.println("4. Update Price");
        System.out.println("5. Exit");
        int ch = sc.nextInt();

        subMenu(ch);
    }

    private void subMenu(int ch) {
        Cars c = new Cars();
        switch(ch) {
            case 1:
                System.out.println("Enter the Car Name: ");
                String name = sc.next();
                System.out.println("Enter Price: ");
                double amt = sc.nextDouble();
                String msg = c.addNewCar(name, amt);
                System.out.println(msg);
                break;
            case 2:
                Cars[] list = CarsFactory.listAllCars();
                for(Cars car: list) {
                    System.out.println(car.toString());
                }
                break;
            case 3:
                System.out.println("Enter the Car Id: ");
                int id = sc.nextInt();
                c = CarsFactory.findCar(id);
                System.out.println(c.toString());
                break;
            case 4:
                System.out.println("Enter the Car Id: ");
                int carId = sc.nextInt();
                System.out.println("Enter New Price: ");
                double amt1 = sc.nextDouble();
                String msg1 = c.updatePrice(carId, amt1);
                System.out.println(msg1);
                break;
            case 5:
                Runtime.getRuntime().exit(0);
            default:
                System.out.println("Wrong Choice");
        }
        mainMenu();
    }

    public static void main(String[] args) {
        CliMain obj = new CliMain();
        obj.mainMenu();
    }
}
