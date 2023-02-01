package com.example.firstplan.utils;

public class Utils {
    public static String nameClass(String name){
        int last = name.lastIndexOf(".");
        return name.substring(last + 1);
    }
}
