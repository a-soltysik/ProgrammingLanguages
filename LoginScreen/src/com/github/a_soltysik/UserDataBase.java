package com.github.a_soltysik;

import java.util.Arrays;
import java.util.HashMap;

public class UserDataBase {
    private final HashMap<String, String> data = new HashMap<>();

    public UserDataBase() {

    }

    public UserDataBase(boolean demo) {
        if (demo) {
            fillDemoDataBase();
        }
    }

    public void addUser(String username, String password) {
        data.put(username, password);
    }

    public boolean checkUser(String username, char[] password) {
        String value = data.get(username);
        boolean result = (value != null);

        if (result) {
            result = Arrays.equals(password, value.toCharArray());
        }
        clearPassword(password);
        return result;
    }

    private void clearPassword(char[] password) {
        Arrays.fill(password, '\0');
    }

   private void fillDemoDataBase() {
        addUser("Andrzej", "12345678");
        addUser("Student", "abcdefg");
        addUser("Guest", "1111");
    }
}
