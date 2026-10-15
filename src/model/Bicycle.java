package model;

public class Bicycle implements Vehicle {
    private String color;

    public Bicycle(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public String toString() {
        return "Bicycle (" + color + ")";
    }
}
