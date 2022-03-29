//package com.Util;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Map;
//
//
//public class TextParser {
//
//    public static List<String> parseText(String userInput) {
//        String[] strArr;
//        String stripRegex = "[^A-Za-z]";
//        ArrayList<String> removeWords = new ArrayList<>();
//        removeWords.add("the");
//        removeWords.add("to");
//        removeWords.add("");
//
//        strArr = userInput.toLowerCase().trim().split(stripRegex);
//        List<String> parsedArr =
//                new ArrayList<>(Arrays.asList(strArr));
//
//        parsedArr.removeAll(removeWords);
//
//        return parsedArr;
//    }
//
//    public static String getVerb(String userInput) {
//        List<String> parsedArr = parseText(userInput.toLowerCase());
//        Map<String, ArrayList<String>> verbMap = JSON_Handler.jsonToMapStringList("verbs.json", "config");
//
//        for (String word : parsedArr) {
//            assert verbMap != null;
//            if (verbMap.containsKey(word)) {
//                return word;
//            }
//            for (Map.Entry<String, ArrayList<String>> entry : verbMap.entrySet()) {
//                if (entry.getValue().contains(word)) {
//                    return entry.getKey();
//                }
//            }
//        }
//        return "";
//    }
//
//    public static ArrayList<String> getNouns(String userInput) {
//        List<String> parsedArr = parseText(userInput.toLowerCase());
//        Map<String, ArrayList<String>> nounMap = JSON_Handler.jsonToMapStringList("nouns.json", "config");
//
//        ArrayList<String> nouns = new ArrayList<>();
//
//        for (String s : parsedArr) {
//            assert nounMap != null;
//            if (nounMap.containsKey(s)) {
//                nouns.add(s);
//            }
//            for (Map.Entry<String, ArrayList<String>> entry : nounMap.entrySet()) {
//                if (entry.getValue().contains(s)) {
//                    nouns.add(entry.getKey());
//                }
//            }
//        }
//        if(nouns.isEmpty()) nouns.add("empty");
//
//        return nouns;
//    }
//
//}
