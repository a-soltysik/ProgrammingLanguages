package com.github.a_soltysik;

public class SimpleCar implements Comparable<SimpleCar> {
    private final String manufacturer;
    private final String model;
    private final short yearOfProduction;
    private final short power;

    public SimpleCar(String manufacturer, String model, short yearOfProduction, short power) {
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

    public short getYearOfProduction() {
        return yearOfProduction;
    }

    public short getPower() {
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
