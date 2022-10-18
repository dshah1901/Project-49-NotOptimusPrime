package com.example.notoptimusprime.model;

import java.io.Serializable;

public class Speaker implements Serializable {
    int digit;
    String audioFilename, iconFilename, speakerName, intelligibility, command, originalFileName;

    public String getAudioFilename() {
        return audioFilename;
    }

    public int getDigit() {
        return digit;
    }

    public String getIntelligibility() {
        return intelligibility;
    }

    public String getCommand() {
        return command;
    }

    public String getOriginalFileName() {
        return originalFileName;
    }

    public String getIconFilename() {
        return iconFilename;
    }

    public String getSpeakerName() {
        return speakerName;
    }

    public Speaker(int digit, String audioFilename, String iconFilename, String speakerName, String intelligibility, String command, String originalFileName) {
        this.digit = digit;
        this.audioFilename = audioFilename;
        this.iconFilename = iconFilename;
        this.speakerName = speakerName;
        this.intelligibility = intelligibility;
        this.command = command;
        this.originalFileName = originalFileName;
    }
}
