package com.epam.rd.autotasks.words;

import java.util.ArrayList;
import java.util.Arrays;

public class StringUtil {
    public static int countEqualIgnoreCaseAndSpaces(String[] words, String sample) {
        if (sample == null || words == null) return 0;
        int counter = 0;
        for (String elem : words) {
            if (elem.strip().equalsIgnoreCase(sample.strip())) counter++;
        }
        return counter;
    }
    public static String[] splitWords(String text) {
        if (text == null || text.equals("") || text.matches("[^a-zA-Z0-9]+")) return null;
        return Arrays.stream(text.split("[^a-zA-Z0-9]+"))
                .filter(e -> e.trim().length() > 0).toArray(String[]::new);
    }

    public static String convertPath(String path, boolean toWin) {
        if (path == null || path.equals("")) return null;
        if (path.indexOf('/') > -1 && path.indexOf('\\') > -1) return null;
        if (path.lastIndexOf('~') > 0) return null;
        if (path.lastIndexOf(':') > 1) return null;
        if (path.indexOf('~') > -1 && path.indexOf('\\') > -1) return null;
        if (path.indexOf(':') > -1 && path.indexOf('/') > -1) return null;

        if (toWin && path.matches
                ("~?\\.*[/[a-zA-Z0-9_\\s]*]*/*\\.*[/[a-zA-Z0-9_\\s]*]*[a-zA-Z0-9_\\s]*\\.?[a-zA-Z0-9_\\s]*") ||
                toWin && path.matches("C?:?\\.?[\\\\[a-zA-Z0-9_\\s]*]*\\\\*\\.*[\\\\[a-zA-Z0-9_\\s]*]*[a-zA-Z0-9_\\s]*\\.?[a-zA-Z0-9_\\s]*")) {
            return path.indexOf('~') > -1 ? path.replace('/','\\')
                    .replaceAll("~","C:\\\\User") : path.startsWith(".") || path.charAt(0) > 47 &&
                    path.charAt(0) < 58 || path.charAt(0) > 64 && path.charAt(0) < 91 || path.charAt(0) > 96 &&
                    path.charAt(0) < 123 ? path.replace('/','\\') : "C:" +
                    path.replace('/','\\');
        }

        if (!toWin && path.matches
                ("C?:?\\.?[\\\\[a-zA-Z0-9_\\s]*]*\\\\*\\.*[\\\\[a-zA-Z0-9_\\s]*]*[a-zA-Z0-9_\\s]*\\.?[a-zA-Z0-9_\\s]*") ||
                !toWin && path.matches ("~?\\.*[/[a-zA-Z0-9_\\s]*]*/*\\.*[/[a-zA-Z0-9_\\s]*]*[a-zA-Z0-9_\\s]*\\.?[a-zA-Z0-9_\\s]*")) {
            return path.startsWith("C:\\User") ? path.replaceAll("C:\\\\User", "~")
                    .replace('\\', '/') : path.startsWith("C:\\") ?
                    path.replaceAll("C:\\\\", "\\\\").replace('\\','/') :
                    path.replace('\\','/');
        }

        return null;
    }

    public static String joinWords(String[] words) {
        if (words == null) return null;
        int counter = 0;
        ArrayList<String> list = new ArrayList<>();
        for (String elem : words) {
            if (elem != null) {
                if (!elem.equals("")) break;
            }
            counter++;
        }
        if (counter == words.length) return null;
        for (String word : words) {
            if (word != "") {
                list.add(word);
            }
        }
        return list.toString();
    }

    public static void main(String[] args) {
        System.out.println("Test 1: countEqualIgnoreCaseAndSpaces");
        String[] words = new String[]{" WordS    \t", "words", "w0rds", "WOR  DS", };
        String sample = "words   ";
        int countResult = countEqualIgnoreCaseAndSpaces(words, sample);
        System.out.println("Result: " + countResult);
        int expectedCount = 2;
        System.out.println("Must be: " + expectedCount);

        System.out.println("Test 2: splitWords");
        String text = "   ,, first, second!!!! third";
        String[] splitResult = splitWords(text);
        System.out.println("Result : " + Arrays.toString(splitResult));
        String[] expectedSplit = new String[]{"first", "second", "third"};
        System.out.println("Must be: " + Arrays.toString(expectedSplit));

        System.out.println("Test 3: convertPath");
        String unixPath = "/some/unix/path";
        String convertResult = convertPath(unixPath, true);
        System.out.println("Result: " + convertResult);
        String expectedWinPath = "C:\\some\\unix\\path";
        System.out.println("Must be: " + expectedWinPath);

        System.out.println("Test 4: joinWords");
        String[] toJoin = new String[]{"go", "with", "the", "", "FLOW"};
        String joinResult = joinWords(toJoin);
        System.out.println("Result: " + joinResult);
        String expectedJoin = "[go, with, the, FLOW]";
        System.out.println("Must be: " + expectedJoin);
    }
}