package com.github.a_soltysik;

import java.util.Comparator;
import java.util.Objects;

public class Car extends SimpleCar {

    public static final Comparator<SimpleCar> MANUFACTURER_COMPARATOR =
            Comparator.comparing(SimpleCar::getManufacturer)
                    .thenComparing(SimpleCar::getModel)
                    .thenComparingInt(SimpleCar::getYearOfProduction)
                    .thenComparingInt(SimpleCar::getPower);

    public static final Comparator<SimpleCar> YEAR_COMPARATOR =
            Comparator.comparingInt(SimpleCar::getYearOfProduction)
                    .thenComparing(SimpleCar::getManufacturer)
                    .thenComparing(SimpleCar::getModel)
                    .thenComparingInt(SimpleCar::getPower);

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
}
