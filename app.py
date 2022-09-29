from flask import Flask
import speech_recognition as sr
import sys
from Flask import Functions
import glob
from flask_cors import CORS

app = Flask(__name__)
CORS(app)
r = sr.Recognizer()


@app.route("/dysarthric_speech/<wav>")
def infer_audio(wav):
    speaker, block, word_key, mic = wav.split('_')
    pred = Functions.predictWord("./Code/"+wav, speaker)
    return pred

@app.route("/normal_speech/<wav>")
def infer_Normalaudio(wav):
    text=""
    with sr.AudioFile("./Code/"+wav) as source:
        r.adjust_for_ambient_noise(source, duration=1)
        audio_file = r.record(source)
        text = r.recognize_google(audio_file)
    
    return text
@app.route("/test",methods = ["GET", "POST"])
def infer_Normalaudio(wav):
    text="hello"
    
    return text



if __name__ == "__main__":
    app.run(debug=True)    