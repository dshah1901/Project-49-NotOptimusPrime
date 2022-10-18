package com.example.notoptimusprime.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataProvider {
    public static Map<Integer, String> generateSpeakers(){
        Map<Integer, String> speakers = new LinkedHashMap<>();
        speakers.put(1, "F02");
        speakers.put(2, "F04");
        speakers.put(3, "F05");
        speakers.put(4, "M01");
        speakers.put(5, "M07");
        speakers.put(6, "F05");
        speakers.put(7, "M19");
        speakers.put(8, "F17");
        speakers.put(9, "M19");
        return speakers;
    }
    public static Map<Integer, String> generateCommands(){
        Map<Integer, String> commands = new LinkedHashMap<>();
        commands.put(1, "Hello");
        commands.put(2, "Bye");
        commands.put(3, "IDK");
        commands.put(4, "Why");
        commands.put(5, "I");
        commands.put(6, "Am");
        commands.put(7, "Doing");
        commands.put(8, "This");
        commands.put(9, "scremmmms");
        return commands;
    }

    public static Map<Integer, String> generateIntelligibility(){
        Map<Integer, String> commands = new LinkedHashMap<>();
        commands.put(1, "High");
        commands.put(2, "Low");
        commands.put(3, "Medium");
        commands.put(4, "Very Low");
        commands.put(5, "High");
        commands.put(6, "Low");
        commands.put(7, "Very Low");
        commands.put(8, "Mild");
        commands.put(9, "Mild");
        return commands;
    }

    public static Map<Integer, String> generateOriginalFileName(){
        Map<Integer, String> commands = new LinkedHashMap<>();
        commands.put(1, "F02_B1");
        commands.put(2, "F02_B1");
        commands.put(3, "F02_B1");
        commands.put(5, "F02_B1");
        commands.put(4, "F02_B1");
        commands.put(6, "F02_B1");
        commands.put(7, "F02_B1");
        commands.put(8, "F02_B1");
        commands.put(9, "F02_B1");
        return commands;
    }

    public static List<Speaker> getSpeaker(){
        List<Speaker> speakerList = new ArrayList<Speaker>();
        Map<Integer, String> speakers = generateSpeakers();
        Map<Integer, String> commands = generateCommands();
        Map<Integer, String> intelligibility = generateIntelligibility();
        Map<Integer, String> orginalFileName = generateOriginalFileName();
        for (Integer key : speakers.keySet()){
            int digit = key;
            String speaker = speakers.get(key);
            String icon;
            String command = commands.get(key);
            String intellgibility = intelligibility.get(key);
            String originalFilename = orginalFileName.get(key);
            if(speaker.contains("F")){
                icon = "icon_female";
            } else{
                icon = "icon_male";
            }

            String audio = "audio_" + String.valueOf(key);

            Speaker s = new Speaker(digit, audio, icon, speaker, command,intellgibility,originalFilename);
            speakerList.add(s);
        }
        return speakerList;
    }
}
