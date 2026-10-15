package repository;

import model.Vehicle;

public class ArrayVehicleRepository implements VehicleRepository {
    private Vehicle[] vehicles = new Vehicle[10];

    public void add(Vehicle vehicle) {
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == null) {
                vehicles[i] = vehicle;
                return;
            }
        }
        throw new RuntimeException("Parking is full");
    }

    public void remove(Vehicle vehicle) {
        for (int i = 0; i < vehicles.length; i++) {
            if (vehicles[i] == vehicle) {
                vehicles[i] = null;
                return;
            }
        }
        throw new RuntimeException("Vehicle not found");
    }

    public Vehicle[] getAll() {
        return vehicles;
    }
}
