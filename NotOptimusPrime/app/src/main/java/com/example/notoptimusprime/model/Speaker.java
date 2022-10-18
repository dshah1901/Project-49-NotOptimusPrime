package com.example.notoptimusprime.model;

public class Speaker {
    int digit;
    String audioFilename, iconFilename, maoriTranslation;

    public int getDigit() {
        return digit;
    }

    public String getAudioFilename() {
        return audioFilename;
    }

    public String getIconFilename() {
        return iconFilename;
    }

    public String getMaoriTranslation() {
        return maoriTranslation;
    }

    public Speaker(int digit, String audioFilename, String iconFilename, String maoriTranslation) {
        this.digit = digit;
        this.audioFilename = audioFilename;
        this.iconFilename = iconFilename;
        this.maoriTranslation = maoriTranslation;
    }
}
