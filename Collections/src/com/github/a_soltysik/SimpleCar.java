package com.github.a_soltysik;

public class SimpleCar implements Comparable<SimpleCar> {
    private final String manufacturer;
    private final String model;
    private final int yearOfProduction;
    private final int power;

    public SimpleCar(String manufacturer, String model, int yearOfProduction, int power) {
        this.manufacturer = manufacturer;
        this.model = model;
        this.yearOfProduction = yearOfProduction;
        this.power = power;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public int getPower() {
        return power;
    }

    @Override
    public String toString() {
        return "Car{" +
                "manufacturer='" + getManufacturer() + '\'' +
                ", model='" + getModel() + '\'' +
                ", yearOfProduction=" + getYearOfProduction() +
                ", power=" + getPower() + '}';
    }

    @Override
    public int compareTo(SimpleCar o) {
        return getManufacturer().compareToIgnoreCase(o.getManufacturer());
    }
}
