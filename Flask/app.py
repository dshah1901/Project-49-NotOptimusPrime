from flask import Flask
import speech_recognition as sr
import sys
from Functions import*


app = Flask(__name__)
r = sr.Recognizer()

@app.route("/predictF02")
def infer_audio():
    pred = predictWord("Code\F02_B1_C10_M2.wav","F02")
    return pred

@app.route("/NormalASR")
def infer_Normalaudio():
    text="Boss"
    with sr.AudioFile("F05_B1_C10_M2.wav") as source:
        r.adjust_for_ambient_noise(source, duration=1)
        audio_file = r.record(source)
        text = r.recognize_google(audio_file)
    
    return text




if __name__ == "__main__":
    app.run(debug=True)    