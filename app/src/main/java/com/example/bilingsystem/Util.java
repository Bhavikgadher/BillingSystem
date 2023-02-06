package com.example.bilingsystem;

public class Util {
    public static int stringToInt(String param) {
        try {
            return Integer.parseInt(param);
        } catch(NumberFormatException e) {
            return -1;
        }
    }
}