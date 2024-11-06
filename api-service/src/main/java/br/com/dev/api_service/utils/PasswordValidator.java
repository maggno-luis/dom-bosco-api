package br.com.dev.api_service.utils;

public class PasswordValidator {
    public static boolean isValidPassword(String password){
        String regex = "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$";
        return password.matches(regex);
    }
}
