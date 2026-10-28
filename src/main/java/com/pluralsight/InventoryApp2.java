
package com.pluralsight;

import java.util.ArrayList;
import java.util.Scanner;

public class InventoryApp2 {

    public static void main(String[] args) {

        // Create a scanner so we can ask the user questions
        Scanner myScanner = new Scanner(System.in);

        // Load our inventory
        ArrayList<Vehicle> inventory = getInventory();

        // Create a variable to keep the menu looping
        boolean menuRunning = true;

        // Loop the menu
        while (menuRunning) {

            // Display the menu and store the selection
            int command = displayMainMenu(myScanner);

            switch (command) {

                case 1:
                    listAllInventory(inventory);
                    break;

                case 2:
                    listVehiclesByMakeModel(myScanner, inventory);
                    break;

                case 5:
                    addVehicle(myScanner, inventory);
                    break;

                case 6:
                    menuRunning = false;
                    break;

                default:
                    System.out.println("=== Invalid command. Try again. ===");
            }
        }

        myScanner.close();
        System.out.println("Goodbye!");
    }

    // List all vehicles
    public static void listAllInventory(ArrayList<Vehicle> inventory) {

        for (Vehicle vehicle : inventory) {
            System.out.println("=== Vehicle Details ===");
            System.out.println("Vehicle ID: " + vehicle.getVehicleId());
            System.out.println("Make/Model: " + vehicle.getMakeModel());
            System.out.println("Color: " + vehicle.getColor());
            System.out.println("Odometer: " + vehicle.getOdometerReading());
            System.out.printf("Price: $%.2f%n", vehicle.getPrice());
            System.out.println();
        }
    }

    // Search vehicles by make/model
    public static void listVehiclesByMakeModel(
            Scanner myScanner, ArrayList<Vehicle> inventory) {

        System.out.println("What make/model are you looking for?");
        String search = myScanner.nextLine();

        boolean found = false;

        for (Vehicle vehicle : inventory) {

            if (vehicle.getMakeModel().toLowerCase()
                    .contains(search.toLowerCase())) {

                System.out.println("=== Vehicle Details ===");
                System.out.println("Vehicle ID: " + vehicle.getVehicleId());
                System.out.println("Make/Model: " + vehicle.getMakeModel());
                System.out.println("Color: " + vehicle.getColor());
                System.out.println("Odometer: " + vehicle.getOdometerReading());
                System.out.printf("Price: $%.2f%n", vehicle.getPrice());
                System.out.println();

                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching vehicles found.");
        }
    }

    // Add a new vehicle
    public static void addVehicle(
            Scanner myScanner, ArrayList<Vehicle> inventory) {

        System.out.println("Please enter the vehicle ID:");
        long vehicleId = myScanner.nextLong();
        myScanner.nextLine();

        System.out.println("Please enter the make/model:");
        String makeModel = myScanner.nextLine();

        System.out.println("Please enter the color:");
        String color = myScanner.nextLine();

        System.out.println("Please enter the odometer reading:");
        int odometerReading = myScanner.nextInt();

        System.out.println("Please enter the price:");
        double price = myScanner.nextDouble();
        myScanner.nextLine();

        // Create a new vehicle
        Vehicle newVehicle = new Vehicle(
                vehicleId,
                makeModel,
                color,
                odometerReading,
                price
        );

        // Add the vehicle to the inventory
        inventory.add(newVehicle);

        System.out.println("Vehicle added successfully!");
    }

    // Display the main menu
    public static int displayMainMenu(Scanner scanner) {

        System.out.println("""
                What do you want to do?
                    1 - List all vehicles
                    2 - Search by make/model
                    3 - Search by price range
                    4 - Search by color
                    5 - Add a vehicle
                    6 - Quit
                Enter your command:
                """);

        int menuSelection = scanner.nextInt();

        // Consume the newline before reading text
        scanner.nextLine();

        return menuSelection;
    }

    // Create and load the inventory
    public static ArrayList<Vehicle> getInventory() {

        ArrayList<Vehicle> inventory = new ArrayList<>();

        Vehicle vehicle1 = new Vehicle(
                123, "Mazda Miata", "Green", 175000, 32000.57);

        Vehicle vehicle2 = new Vehicle(
                456, "Ford Mustang", "Red", 85000, 28500.00);

        Vehicle vehicle3 = new Vehicle(
                789, "Honda Civic", "Blue", 62000, 21999.99);

        Vehicle vehicle4 = new Vehicle(
                321, "Jeep Wrangler", "Black", 94000, 34750.50);

        Vehicle vehicle5 = new Vehicle(
                654, "Toyota Corolla", "Silver", 48000, 23500.00);

        Vehicle vehicle6 = new Vehicle(
                987, "Toyota Camry", "White", 71000, 26750.25);

        Vehicle vehicle7 = new Vehicle(
                555, "Dodge Ram", "Black", 66000, 85000.00);

        // Add the vehicles to the inventory
        inventory.add(vehicle1);
        inventory.add(vehicle2);
        inventory.add(vehicle3);
        inventory.add(vehicle4);
        inventory.add(vehicle5);
        inventory.add(vehicle6);
        inventory.add(vehicle7);

        return inventory;
    }
}
