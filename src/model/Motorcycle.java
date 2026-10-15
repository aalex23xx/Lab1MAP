package model;

public class Motorcycle implements Vehicle {
    private String color;

    public Motorcycle(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        return "Motorcycle (" + color + ")";
    }
}
