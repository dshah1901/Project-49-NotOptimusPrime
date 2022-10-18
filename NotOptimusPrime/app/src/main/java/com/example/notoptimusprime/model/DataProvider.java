package com.example.notoptimusprime.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataProvider {
    public static Map<Integer, String> generateMaoriDigits(){
        Map<Integer, String> words = new LinkedHashMap<>();
        words.put(1, "Tahi");
        words.put(2, "Rua");
        words.put(3, "Toru");
        words.put(4, "Wha");
        words.put(5, "Rima");
        words.put(6, "Ono");
        words.put(7, "Whitu");
        words.put(8, "Waru");
        words.put(9, "Iwa");
        return words;
    }

    public static List<Speaker> getSpeaker(){
        List<Speaker> speakerList = new ArrayList<Speaker>();
        Map<Integer, String> speakers = generateMaoriDigits();
        for (Integer key : speakers.keySet()){
            int digit = key;
            String maoriTranslation = speakers.get(key);
            String icon = "icon" + String.valueOf(key);
            String audio = "audio_" + String.valueOf(key);

            Speaker s = new Speaker(digit, audio, icon, maoriTranslation);
            speakerList.add(s);
        }
        return speakerList;
    }
}
