package com.github.a_soltysik;

import java.util.*;

public class ConsoleApp {

    private static String COLLECTION_MENU =
            """
                    Wybierz typ kolekcji:
                    - Set:
                        1 - HashSet
                        2 - TreeSet
                    - List:
                        3 - ArrayList
                        4 - LinkedList
                    - Map:
                        5 - HashMap
                        6 - TreeMap
                    """;

    private static String OPERATION_MENU =
            """
                    Wybierz operację:
                    1 - Dodaj kilka tych samych obiektów z nadpisananymi metodami hashCode i equals, comparable oraz comparatorem.
                    2 - Dodaj kilka różnych obiektów z nadpisananymi metodami hashCode i equals, comparable oraz comparatorem.
                    3 - Dodaj kilka tych samych obiektów z domyślnymi metodami hashCode i equals, comparable.
                    4 - Dodaj kilka różnych obiektów z domyślnymi metodami hashCode i equals, comparable.
                    5 - Usuń losowy element.
                    6 - Wyświetl kontener.
                    7 - Zapisz kontener do pliku.
                    """;

    Set<SimpleCar> currentSet;
    List<SimpleCar> currentList;
    Map<SimpleCar, Integer> currentMap;

    Mode currentMode = Mode.NONE;


    public void init() {

    }

    private void collectionMenu() {
        System.out.println(COLLECTION_MENU);
    }

    private void deleteRandomElement() {
        Random random = new Random();
        switch (currentMode) {
            case LIST -> currentList.remove(
                    random.nextInt(currentList.size())
            );
            case SET -> {
                int index = 0;
                int indexToRemove = random.nextInt(currentSet.size());
                for (var element : currentSet) {
                    if (index == indexToRemove) {
                        currentMap.remove(element);
                        return;
                    }
                    index++;
                }
            }
            case MAP -> {
                int index = 0;
                int indexToRemove = random.nextInt(currentMap.size());
                for (var pair : currentMap.entrySet()) {
                    if (index == indexToRemove) {
                        currentMap.remove(pair.getKey());
                        return;
                    }
                    index++;
                }
            }
        }
    }

    //add several the same objects with hash code and equals methods overridden, comparator and comparable
    private void addSeveralEqualCars() {
        SimpleCar car1 = new Car("Dodge", "Challanger", 2015, 707);
        SimpleCar car2 = new Car("Dodge", "Challanger", 2015, 707);
        SimpleCar car3 = new Car("Dodge", "Challanger", 2015, 707);

        addElements(car1, car2, car3);
    }

    //add several different objects with hash code and equals methods overridden, comparator and comparable
    private void addSeveralDifferentCars() {
        SimpleCar car1 = new Car("Dodge", "Challanger", 2015, 707);
        SimpleCar car2 = new Car("Dodge", "Charger", 1969, 335);
        SimpleCar car3 = new Car("Ferrari", "F40", 1990, 478);
        SimpleCar car4 = new Car("Ferrari", "Testarossa", 1990, 440);
        SimpleCar car5 = new Car("Ferrari", "Enzo", 2003, 660);

        addElements(car1, car2, car3, car4, car5);
    }

    //add several the same objects with default hash code and equals methods and comparable
    private void addSeveralEqualSimpleCars() {
        SimpleCar car1 = new SimpleCar("Dodge", "Challanger", 2015, 707);
        SimpleCar car2 = new SimpleCar("Dodge", "Challanger", 2015, 707);
        SimpleCar car3 = new SimpleCar("Dodge", "Challanger", 2015, 707);

        addElements(car1, car2, car3);
    }

    //add several different objects with default hash code and equals methods and comparable
    private void addSeveralDifferentSimpleCars() {
        SimpleCar car1 = new SimpleCar("Dodge", "Challanger", 2015, 707);
        SimpleCar car2 = new SimpleCar("Dodge", "Charger", 1969, 335);
        SimpleCar car3 = new SimpleCar("Ferrari", "F40", 1990, 478);
        SimpleCar car4 = new SimpleCar("Ferrari", "Testarossa", 1990, 440);
        SimpleCar car5 = new SimpleCar("Ferrari", "Enzo", 2003, 660);

        addElements(car1, car2, car3, car4, car5);
    }

    private void addElements(SimpleCar... cars) {
        switch (currentMode) {
            case SET -> Collections.addAll(currentSet, cars);
            case LIST -> Collections.addAll(currentList, cars);
            case MAP -> {
                for (int i = 0; i < cars.length; i++)
                    currentMap.put(cars[i], i + 1);
            }
        }
    }

    private enum Mode {
        SET, LIST, MAP, NONE
    }
}
