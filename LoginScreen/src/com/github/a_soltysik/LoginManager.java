package com.github.a_soltysik;

public class LoginManager {
    public static int FAILURE = 0;
    public static int SUCCESS = 1;
    public RESULT login(String userName, char[] password) {
        return RESULT.SUCCESS;
    }

    public enum RESULT {
        FAILURE, SUCCESS;
    }
}
