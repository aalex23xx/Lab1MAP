package repository;

import model.Vehicle;

public interface VehicleRepository {
    void add(Vehicle vehicle);
    void remove(Vehicle vehicle);
    Vehicle[] getAll();
}
