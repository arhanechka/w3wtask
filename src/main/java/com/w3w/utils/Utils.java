package com.w3w.utils;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    public static boolean checkWordsSequenceUnique(List<String> wordsSequences){
        List<String> distinctElements = wordsSequences.stream()
                .distinct()
                .collect(Collectors.toList());
        return distinctElements.size() == wordsSequences.size();
    }
}
