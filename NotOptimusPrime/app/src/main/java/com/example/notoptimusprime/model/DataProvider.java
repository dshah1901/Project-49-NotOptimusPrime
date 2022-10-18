package com.example.notoptimusprime.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DataProvider {
    public static Map<Integer, String> generateSpeakers(){
        Map<Integer, String> speakers = new LinkedHashMap<>();
        speakers.put(1, "F02");
        speakers.put(2, "F03");
        speakers.put(3, "F04");
        speakers.put(4, "M01");
        speakers.put(5, "M05");
        speakers.put(6, "M08");
        speakers.put(7, "M09");
        speakers.put(8, "M16");
        return speakers;
    }
    public static Map<Integer, String> generateCommands(){
        Map<Integer, String> commands = new LinkedHashMap<>();
        commands.put(1, "Sentence");
        commands.put(2, "Left");
        commands.put(3, "Said");
        commands.put(4, "Enter");
        commands.put(5, "Had");
        commands.put(6, "Escape");
        commands.put(7, "Upward");
        commands.put(8, "More");
        return commands;
    }

    public static Map<Integer, String> generateIntelligibility(){
        Map<Integer, String> commands = new LinkedHashMap<>();
        commands.put(1, "Low");
        commands.put(2, "Very Low");
        commands.put(3, "Mild");
        commands.put(4, "Very Low");
        commands.put(5, "Mild");
        commands.put(6, "High");
        commands.put(7, "High");
        commands.put(8, "Low");
        return commands;
    }

    public static Map<Integer, String> generateOriginalFileName(){
        Map<Integer, String> commands = new LinkedHashMap<>();
        commands.put(1, "F02_B1_C12_M3.wav");
        commands.put(2, "F03_B1_C18_M8.wav");
        commands.put(3, "F04_B1_CW39_M8.wav");
        commands.put(5, "M01_B1_C4_M6.wav");
        commands.put(4, "M05_B1_CW27_M7.wav");
        commands.put(6, "M08_B1_C6_M5.wav");
        commands.put(7, "M09_B1_C16_M2.wav");
        commands.put(8, "M16_B1_CW70_M3.wav");
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
