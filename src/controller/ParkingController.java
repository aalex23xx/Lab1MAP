package controller;

import model.Vehicle;
import repository.VehicleRepository;

public class ParkingController {
    private VehicleRepository repository;

    public ParkingController(VehicleRepository repository) {
        this.repository = repository;
    }

    public void addVehicle(Vehicle vehicle) {
        repository.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {
        repository.remove(vehicle);
    }

    public Vehicle[] getVehicles() {
        return repository.getAll();
    }

    public void removeVehicleAt(int position) {
        Vehicle[] vehicles = repository.getAll();

        if (position < 0 || position >= vehicles.length || vehicles[position] == null) {
            throw new RuntimeException("Vehicle not found");
        }

        removeVehicle(vehicles[position]);
    }

    public String getRedVehicles() {
        String result = "";

        for (Vehicle vehicle : repository.getAll()) {
            if (vehicle != null && vehicle.getColor().equalsIgnoreCase("red"))  {
                result = result + vehicle + "\n";
            }
        }

        return result;
    }
}
