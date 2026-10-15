
package view;

import java.util.Scanner;
import model.*;
import repository.*;
import controller.*;
// MAP Lab 1 - Parking Lot
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        VehicleRepository repo = new ArrayVehicleRepository();
        ParkingController ctrl = new ParkingController(repo);

        while (true) {
            System.out.println("\n1. Add");
            System.out.println("2. Remove");
            System.out.println("3. Show red vehicles");
            System.out.println("4. Show all vehicles");
            System.out.println("0. Exit");

            try {
                int option = Integer.parseInt(sc.nextLine());

                if (option == 0)
                    break;

                if (option == 1) {
                    
                    System.out.print("Type (1=Car, 2=Moto, 3=Bike): ");
                    int type = Integer.parseInt(sc.nextLine());

                    System.out.print("Color: ");
                    String color = sc.nextLine().trim();

                    if (color.equalsIgnoreCase("red"))
                        color = "Red";

                    Vehicle v;
                    if (type == 1)
                        v = new Car(color);
                    else if (type == 2)
                        v = new Motorcycle(color);
                    else if (type == 3)
                        v = new Bicycle(color);
                    else
                        throw new RuntimeException("Invalid type");

                    ctrl.addVehicle(v);
                    System.out.println("Added");
                }

                else if (option == 2) {
                    Vehicle[] vehicles = ctrl.getVehicles();

                    for (int i = 0; i < vehicles.length; i++)
                        if (vehicles[i] != null)
                            System.out.println(i + ": " + vehicles[i]);

                    System.out.print("Position: ");
                    int pos = Integer.parseInt(sc.nextLine());
                    ctrl.removeVehicleAt(pos);
                    System.out.println("Removed");
                }

                else if (option == 3) {
                    System.out.println("Red vehicles:");
                    System.out.print(ctrl.getRedVehicles());
                }

                else if (option == 4) {
                    System.out.println("All vehicles:");
                    Vehicle[] vehicles = ctrl.getVehicles();

                    for (int i = 0; i < vehicles.length; i++)
                        if (vehicles[i] != null)
                            System.out.println(i + ": " + vehicles[i]);
                }

                else
                    System.out.println("Invalid option");

            } catch (NumberFormatException e) {
                System.out.println("Error: Enter a number");
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        sc.close();
    }
}
