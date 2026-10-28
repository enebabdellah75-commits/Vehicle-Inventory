package com.pluralsight;

import java.util.Scanner;

public class VehicleInventoryApp {

    static int numberOfVehiclesInInventory = 0;

    public static void main(String[] args) {

        //create a scanner
        Scanner scanner = new Scanner(System.in);

        //create an array capable of holding up to 20 vehicles
        Vehicle[] inventory = new Vehicle[20];

        //create 6 vehicles and put them in the array
        Vehicle vehicle1 = new Vehicle(101121, "Ford Explorer", "Red", 45000, 13500);
        Vehicle vehicle2 = new Vehicle(101122, "Toyota Camry", "Blue", 60000, 11000);
        Vehicle vehicle3 = new Vehicle(101123, "Chevrolet Malibu", "Black", 50000, 9700);
        Vehicle vehicle4 = new Vehicle(101124, "Honda Civic", "White", 70000, 7500);
        Vehicle vehicle5 = new Vehicle(101125, "Subaru Outback", "Green", 55000, 14500);
        Vehicle vehicle6 = new Vehicle(101126, "Jeep Wrangler", "Yellow", 30000, 16000);


        inventory[0] = vehicle1;
        inventory[1] = vehicle2;
        inventory[2] = vehicle3;
        inventory[3] = vehicle4;
        inventory[4] = vehicle5;
        inventory[5] = vehicle6;

        numberOfVehiclesInInventory = 6;

        //create a loop with this menu in the loop
        /*
        What do you want to do?
        1 - List all vehicles
        2 - Search by make/model
        3 - Search by price range
        4 - Search by color
        5 - Add a vehicle
        6 - Quit
        Enter your command:
         */

        //focus on menu items 1, 2, and 5
        boolean appRunning = true;
        while (appRunning) {

            //create the menu
            System.out.println();
            System.out.println("What do you want to do?");
            System.out.println(" 1 - List all vehicles");
            System.out.println(" 2 - Search by make/model");
            System.out.println(" 3 - Search by price range");
            System.out.println(" 4 - Search by color");
            System.out.println(" 5 - Add a vehicle");
            System.out.println(" 6 - Quit");
            System.out.println("Enter your command: ");

            //store the answer
            int command = scanner.nextInt();

            //eat newline
            scanner.nextLine();

            //do something based on the answer
            switch (command) {
                case 1 -> listAllVehicles(inventory);
                case 3 -> searchByPriceRange(scanner, inventory);
                case 6 -> appRunning = false;
                default -> System.out.println("Invalid command");
            }

        }
        System.out.println("Goodbye!");
        scanner.close();
    }
    // prints all the details of ONE vehicle
    public static void displayVehicle(Vehicle vehicle) {
        System.out.printf("%d | %s | %s | %d miles | $%.2f%n",
                vehicle.getVehicleId(),
                vehicle.getMakeModel(),
                vehicle.getColor(),
                vehicle.getOdometerReading(),
                vehicle.getPrice());
    }

    //list all the vehicles
    public static void listAllVehicles(Vehicle[] inventory) {
        for(int i = 0; i < numberOfVehiclesInInventory; i++) {
            System.out.println("make : " + inventory[i].getMakeModel());
            displayVehicle(inventory[i]);
        }
    }

    //searchByColor
    public static void searchByModel(Scanner theScanner, Vehicle[] inventory) {

        //ask for the make model
        System.out.println("Please enter the make: ");
        String makeModel = theScanner.nextLine();

        for(int i = 0; i < numberOfVehiclesInInventory; i++) {
            if(inventory[i].getMakeModel().equalsIgnoreCase(makeModel)) {
                System.out.println("make : " + inventory[i].getMakeModel());
            }
        }
    }
    // option 3: search by price range
    public static void searchByPriceRange(Scanner theScanner, Vehicle[] inventory) {
        System.out.println("Please enter the minimum price: ");
        double minPrice = theScanner.nextDouble();
        System.out.println("Please enter the maximum price: ");
        double maxPrice = theScanner.nextDouble();
        theScanner.nextLine();   // eat the newline

        boolean found = false;

        for (int i = 0; i < numberOfVehiclesInInventory; i++) {
            double price = inventory[i].getPrice();
            if (price >= minPrice && price <= maxPrice) {   // both must be true
                displayVehicle(inventory[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No vehicles found in that price range.");
        }
    }

    // option 4: search by color
    public static void searchByColor(Scanner theScanner, Vehicle[] inventory) {
        System.out.println("Please enter the color: ");
        String color = theScanner.nextLine();

        boolean found = false;

        for (int i = 0; i < numberOfVehiclesInInventory; i++) {
            if (inventory[i].getColor().equalsIgnoreCase(color)) {
                displayVehicle(inventory[i]);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No vehicles found with that color.");
        }
    }

    public static void addVehicle(Scanner theScanner, Vehicle[] inventory) {

        //ask all the questions
        System.out.println("Please enter the vehicle's id: ");
        int id = theScanner.nextInt();

        //eat the newline
        theScanner.nextLine();

        System.out.println("Please enter the make: ");
        String makeModel = theScanner.nextLine();
        System.out.println("Please enter the color: ");
        String color = theScanner.nextLine();
        System.out.println("Please enter the odometer reading: ");
        int odometerReading = theScanner.nextInt();
        System.out.println("Please enter the price: ");
        double price = theScanner.nextDouble();

        //create the vehicle
        Vehicle newVehicle = new Vehicle(id, makeModel, color, odometerReading, price);

        //add it to the last open spot in the ivnetory
        inventory[numberOfVehiclesInInventory] = newVehicle;

        //you have to deal with the inventory count
        numberOfVehiclesInInventory++;


    }


}