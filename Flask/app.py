from flask import Flask
import speech_recognition as sr
import sys
from Functions import*
import glob

app = Flask(__name__)
r = sr.Recognizer()

@app.route("/dysarthric_speech/<wav>")
def infer_audio(wav):
    speaker, block, word_key, mic = wav.split('_')
    pred = predictWord("../Code/"+wav, speaker)
    return pred

@app.route("/normal_speech/<wav>")
def infer_Normalaudio(wav):
    text=""
    with sr.AudioFile("../Code/"+wav) as source:
        r.adjust_for_ambient_noise(source, duration=1)
        audio_file = r.record(source)
        text = r.recognize_google(audio_file)
    
    return text




if __name__ == "__main__":
    app.run(debug=True)    