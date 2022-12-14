package com.sayed.saber.util;

import java.util.*;

public class GeneralUtil {

    public enum Messages {

        NOT_ADMIN("you not authorized here ...."),
        ADMIN(" Hello admin user you are authorized here ...."),
        UNEXPECTED("UN EXPECTED BEHAVIOR"),
        NOT_LOGGED_IN("you have to login here first ");

        Messages(String value) {
            this.value = value;
        }

        private String value;

        public String getValue() {
            return value;
        }
    }

    public static final String AdministrativeUserName = "admin";

    public static List<String> categories = new ArrayList<>();

    public static List<String> allowedExtensions = new ArrayList<>();

    public static Map<String, String> loggedInUser = new HashMap<>();


    static {

        categories.add("living thing");
        categories.add("nature");
        categories.add("machine");

        allowedExtensions.add("jpg");
        allowedExtensions.add("png");
        allowedExtensions.add("gif");

        loggedInUser.put("username", "");
    }

    public static Messages isAdministrativeUser() {

        if (loggedInUser.get("username").isEmpty())
            return Messages.NOT_LOGGED_IN;

        else if (!Objects.equals(loggedInUser.get("username"), AdministrativeUserName))
            return Messages.NOT_ADMIN;

        else if (Objects.equals(loggedInUser.get("username"), AdministrativeUserName))
            return Messages.ADMIN;

        else
            return Messages.UNEXPECTED;
    }

    public static boolean validCategory(String category) {

        return categories.contains(category);
    }

    public static boolean validExtension(String extension) {

        return allowedExtensions.contains(extension);
    }

    public static String getFileExtension(String filename) {

        return Optional.ofNullable(filename)
                .filter(f -> f.contains("."))
                .map(f -> f.substring(filename.lastIndexOf(".") + 1)).orElse("");
    }

}
