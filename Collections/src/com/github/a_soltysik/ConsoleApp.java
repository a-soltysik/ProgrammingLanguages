package com.github.a_soltysik;

import java.io.FileNotFoundException;
import java.util.*;

public class ConsoleApp {

    private static final String FILE_NAME = "out.txt";

    private static final String COLLECTION_MENU =
            """
                    Wybierz typ kolekcji:
                    - Set:
                        1 - HashSet
                        2 - TreeSet
                        3 - TreeSet z Comparator
                    - List:
                        4 - ArrayList
                        5 - LinkedList
                    - Map:
                        6 - HashMap
                        7 - TreeMap
                        8 - TreeMap z Comparator
                    9 - Wyjście
                    """;

    private static final String SCENARIO_MENU =
            """
                    Wybierz operację:
                    1 - Dodaj kilka tych samych obiektów z nadpisananymi metodami hashCode i equals, comparable oraz comparatorem.
                    2 - Dodaj kilka różnych obiektów z nadpisananymi metodami hashCode i equals, comparable oraz comparatorem.
                    3 - Dodaj kilka tych samych obiektów z domyślnymi metodami hashCode i equals, comparable.
                    4 - Dodaj kilka różnych obiektów z domyślnymi metodami hashCode i equals, comparable.
                    5 - Usuń losowy element.
                    6 - Wyświetl kontener.
                    7 - Zapisz kontener do pliku.
                    8 - Wróć.
                    """;

    Console console = new Console();
    FileWriter file = new FileWriter();

    Set<SimpleCar> currentSet;
    List<SimpleCar> currentList;
    Map<SimpleCar, Integer> currentMap;

    Mode currentMode;

    public void init() {
        try {
            file.open(FILE_NAME, false);
        } catch (FileNotFoundException e) {
            console.printError("Nie udało się otworzyć pliku");
        }
        while (true) {
            collectionMenu();
        }
    }

    private void collectionMenu() {
        console.printLine(COLLECTION_MENU);
        switch (console.requestInt("> ")) {
            case 1 -> {
                currentSet = new HashSet<>();
                currentMode = Mode.SET;
            }
            case 2 -> {
                currentSet = new TreeSet<>();
                currentMode = Mode.SET;
            }
            case 3 -> {
                currentSet = new TreeSet<>(Car.YEAR_COMPARATOR);
                currentMode = Mode.SET_COMP;
            }
            case 4 -> {
                currentList = new ArrayList<>();
                currentMode = Mode.LIST;
            }
            case 5 -> {
                currentList = new LinkedList<>();
                currentMode = Mode.LIST;
            }
            case 6 -> {
                currentMap = new HashMap<>();
                currentMode = Mode.MAP;
            }
            case 7 -> {
                currentMap = new TreeMap<>();
                currentMode = Mode.MAP;
            }
            case 8 -> {
                currentMap = new TreeMap<>(Car.YEAR_COMPARATOR);
                currentMode = Mode.MAP_COMP;
            }
            case 9 -> {
                file.close();
                System.exit(0);
            }
            default -> collectionMenu();
        }
        while (!scenarioMenu()) ;
    }

    private boolean scenarioMenu() {
        boolean back = false;
        console.printLine(SCENARIO_MENU);
        switch (console.requestInt("> ")) {
            case 1 -> addSeveralEqualCars();
            case 2 -> addSeveralDifferentCars();
            case 3 -> {
                if (currentMode == Mode.MAP_COMP || currentMode == Mode.SET_COMP) {
                    console.printLine("Scenariusz niedostępny dla wybranego kontenera");
                } else {
                    addSeveralEqualSimpleCars();
                }
            }
            case 4 -> {
                if (currentMode == Mode.MAP_COMP || currentMode == Mode.SET_COMP) {
                    console.printLine("Scenariusz niedostępny dla wybranego kontenera");
                } else {
                    addSeveralDifferentSimpleCars();
                }
            }
            case 5 -> deleteRandomElement();
            case 6 -> printData();
            case 7 -> writeDataToFile();
            case 8 -> back = true;
            default -> scenarioMenu();
        }
        return back;
    }

    private void deleteRandomElement() {
        Random random = new Random();
        switch (currentMode) {
            case LIST -> {
                if (currentList.size() == 0)
                    return;
                currentList.remove(
                        random.nextInt(currentList.size())
                );
            }
            case SET -> {
                if (currentSet.size() == 0)
                    return;
                int index = 0;
                int indexToRemove = random.nextInt(currentSet.size());
                for (var element : currentSet) {
                    if (index == indexToRemove) {
                        currentSet.remove(element);
                        return;
                    }
                    index++;
                }
            }
            case MAP -> {
                if (currentMap.size() == 0)
                    return;
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
        SimpleCar car1 = new Car("Dodge", "Challenger", 2015, 707);
        SimpleCar car2 = new Car("Dodge", "Challenger", 2015, 707);
        SimpleCar car3 = new Car("Dodge", "Challenger", 2015, 707);

        addElements(car1, car2, car3);
    }

    //add several different objects with hash code and equals methods overridden, comparator and comparable
    private void addSeveralDifferentCars() {
        SimpleCar car1 = new Car("Dodge", "Challenger", 2015, 707);
        SimpleCar car2 = new Car("Dodge", "Charger", 1969, 335);
        SimpleCar car3 = new Car("Ferrari", "F40", 1990, 478);
        SimpleCar car4 = new Car("Ferrari", "Testarossa", 1990, 440);
        SimpleCar car5 = new Car("Ferrari", "Enzo", 2003, 660);

        addElements(car1, car2, car3, car4, car5);
    }

    //add several the same objects with default hash code and equals methods and comparable
    private void addSeveralEqualSimpleCars() {
        SimpleCar car1 = new SimpleCar("Dodge", "Challenger", 2015, 707);
        SimpleCar car2 = new SimpleCar("Dodge", "Challenger", 2015, 707);
        SimpleCar car3 = new SimpleCar("Dodge", "Challenger", 2015, 707);

        addElements(car1, car2, car3);
    }

    //add several different objects with default hash code and equals methods and comparable
    private void addSeveralDifferentSimpleCars() {
        SimpleCar car1 = new SimpleCar("Dodge", "Challenger", 2015, 707);
        SimpleCar car2 = new SimpleCar("Dodge", "Charger", 1969, 335);
        SimpleCar car3 = new SimpleCar("Ferrari", "F40", 1990, 478);
        SimpleCar car4 = new SimpleCar("Ferrari", "Testarossa", 1990, 440);
        SimpleCar car5 = new SimpleCar("Ferrari", "Enzo", 2003, 660);

        addElements(car1, car2, car3, car4, car5);
    }

    private void addElements(SimpleCar... cars) {
        switch (currentMode) {
            case SET, SET_COMP -> Collections.addAll(currentSet, cars);
            case LIST -> Collections.addAll(currentList, cars);
            case MAP, MAP_COMP -> {
                for (int i = 0; i < cars.length; i++) {
                    currentMap.put(cars[i], i + 1);
                }
            }
        }
    }

    private void writeDataToFile() {
        file.write(currentMode.name() + ":");
        switch (currentMode) {
            case SET, SET_COMP -> file.write(currentSet);
            case LIST -> file.write(currentList);
            case MAP, MAP_COMP -> file.write(currentMap);
        }
        file.write("");
    }

    private void printData() {
        console.printLine(currentMode.name() + ":");
        switch (currentMode) {
            case SET, SET_COMP -> console.printLine(Utils.toString(currentSet));
            case LIST -> console.printLine(Utils.toString(currentList));
            case MAP, MAP_COMP -> console.printLine(Utils.toString(currentMap));
        }
        console.printLine("");
    }

    private enum Mode {
        SET, LIST, MAP, SET_COMP, MAP_COMP
    }
}
