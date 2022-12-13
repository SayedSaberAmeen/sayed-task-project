package com.sayed.saber.util;

import java.util.*;

public class GeneralUtil {

    public static final String AdministrativeUserName="admin";

    public static List<String> categories = new ArrayList<>();

    public static List<String> allowedExtensions = new ArrayList<>();

    public static Map<String,String> loginUser = new HashMap<>();


    static {

        categories.add("living thing");
        categories.add("nature");
        categories.add("machine");

        allowedExtensions.add("jpg");
        allowedExtensions.add("png");
        allowedExtensions.add("gif");

        loginUser.put("username","");
    }

    public static boolean isAdministrativeUser(){

        return Objects.equals(loginUser.get("username"), AdministrativeUserName);
    }

    public static boolean validCategory( String category){

        return categories.contains(category);
    }

    public static boolean validExtension( String extension){

        return allowedExtensions.contains(extension);
    }

    public static String getFileExtension(String filename) {

        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1)).orElse("");
    }

}
