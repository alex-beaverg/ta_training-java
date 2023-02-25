package com.epam.rd.autotasks.validations;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {
        if (email == null || email.equals("")) return false;
        Pattern pat = Pattern.compile("[a-z]+_[a-z]+[0-9]?@epam\\.com");
        Matcher mat = pat.matcher(email);
        return mat.matches();
    }
}





