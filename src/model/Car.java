package model;

public class Car implements Vehicle {
    private String color;

    public Car(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        return "Car (" + color + ")";
    }
}
