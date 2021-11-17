package com.github.a_soltysik;

import java.util.Arrays;
import java.util.HashMap;

public class UserDataBase {
    private final HashMap<String, char[]> data = new HashMap<>();

    public UserDataBase() {

    }

    public UserDataBase(boolean demo) {
        if (demo) {
            fillDemoDataBase();
        }
    }

    public void addUser(String username, char[] password) {
        data.put(username, password);
    }

    public boolean checkUser(String username, char[] password) {
        char[] value = data.get(username);
        boolean result = (value != null);

        if (result) {
            result = Arrays.equals(password, value);
        }
        clearPassword(password);
        return result;
    }

    private void clearPassword(char[] password) {
        Arrays.fill(password, '\0');
    }

   private void fillDemoDataBase() {
        addUser("Andrzej", "12345678".toCharArray());
        addUser("Student", "abcdefg".toCharArray());
        addUser("Guest", "1111".toCharArray());
    }
}
