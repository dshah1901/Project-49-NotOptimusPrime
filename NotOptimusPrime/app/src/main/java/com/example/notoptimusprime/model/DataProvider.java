package com.example.notoptimusprime.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataProvider {
    public static Map<Integer, String> generateMaoriDigits(){
        Map<Integer, String> words = new LinkedHashMap<>();
        words.put(1, "F02");
        words.put(2, "F04");
        words.put(3, "F05");
        words.put(4, "M01");
        words.put(5, "M07");
        words.put(6, "F05");
        words.put(7, "M19");
        words.put(8, "F17");
        words.put(9, "M19");
        return words;
    }

    public static List<Speaker> getSpeaker(){
        List<Speaker> speakerList = new ArrayList<Speaker>();
        Map<Integer, String> speakers = generateMaoriDigits();
        for (Integer key : speakers.keySet()){
            int digit = key;
            String maoriTranslation = speakers.get(key);
            String icon;
            if(maoriTranslation.contains("F")){
                icon = "icon_female";
            } else{
                icon = "icon_male";
            }

            String audio = "audio_" + String.valueOf(key);

            Speaker s = new Speaker(digit, audio, icon, maoriTranslation);
            speakerList.add(s);
        }
        return speakerList;
    }
}
