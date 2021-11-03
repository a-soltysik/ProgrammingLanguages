package com.github.a_soltysik;

import java.util.Comparator;
import java.util.Objects;

public class Car extends SimpleCar{

    public Car(String manufacturer, String model, short yearOfProduction, short power) {
        super(manufacturer, model, yearOfProduction, power);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return getYearOfProduction() == car.getYearOfProduction()
                && getPower() == car.getPower()
                && getManufacturer().equals(car.getManufacturer())
                && getModel().equals(car.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getManufacturer(), getModel(), getYearOfProduction(), getPower());
    }

    public static class ManufacturerComparator implements Comparator<SimpleCar> {

        @Override
        public int compare(SimpleCar o1, SimpleCar o2) {
            return o1.getManufacturer().compareToIgnoreCase(o2.getManufacturer());
        }
    }

    public static class PowerComparator implements Comparator<SimpleCar> {

        @Override
        public int compare(SimpleCar o1, SimpleCar o2) {
            return Short.compare(o1.getPower(), o2.getPower());
        }
    }
}
