package ru.aston.entity;

public class Vehicle {
    private int id;
    private String plate, model, release_year;

    public Vehicle(int id, String plate, String model, String release_year) {
        this.id = id;
        this.plate = plate;
        this.model = model;
        this.release_year = release_year;
    }

    public int getId() {return id;}
    public String getPlate() {return plate;}
    public String getModel() {return model;}
    public String getRelease_year() {return release_year;}


}
