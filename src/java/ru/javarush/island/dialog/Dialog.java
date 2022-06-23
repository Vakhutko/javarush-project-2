package ru.javarush.island.dialog;

import ru.javarush.island.tools.Settings;

import java.util.Scanner;
import java.util.Set;

public class Dialog {
    private static final String STOP = "Stop changing settings";
    private static final String EXIT = "EXIT";
    private final Scanner scanner = new Scanner(System.in);
    private Settings settings;

    public void startDialog(Settings settings) {
        System.out.println(("Hello"));
        this.settings = settings;
        changeSettings();
    }

    private void changeSettings() {
        System.out.println(("Current settings is:"));
        for (String s : settings.getProperties().stringPropertyNames()) {
            System.out.println((s + " = " + settings.getProperties().getProperty(s)));
        }
        checkChoice();
    }

    public void checkChoice() {
        System.out.println(("Do you want to change setting? (Y/N)"));
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("Y")) {
            System.out.println(("Enter a setting to change. Or type " + EXIT));
            checkKey(settings.getProperties().stringPropertyNames());
        } else if (!answer.equalsIgnoreCase("N")) {
            System.out.println(("Wrong entry = " + answer));
            checkChoice();
        } else if (answer.equalsIgnoreCase("N")) {
            System.out.println((STOP));
        }
    }

    public void checkKey(Set<String> example) {
        String entry = scanner.nextLine();
        if (entry.equalsIgnoreCase(EXIT)) {
            System.out.println((STOP));
        } else if (!example.contains(entry)) {
            System.out.println(("Wrong entry = " + entry + ".\nEnter a setting to change. Or type " + EXIT));
            checkKey(example);
        } else {
            System.out.println(("Enter a new value. Or type " + EXIT));
            checkValue(entry);
        }
    }

    public void checkValue(String key) {
        String value = scanner.nextLine();
        if (value.equals(EXIT)) {
            System.out.println((STOP));
        }
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            System.out.println((value + " not a number!"));
            checkValue(key);
        }
        settings.setProperties(key, value);
        changeSettings();
    }
}
