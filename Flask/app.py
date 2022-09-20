from flask import Flask
import sys
from Functions import*


app = Flask(__name__)

@app.route("/predictF02")
def infer_audio():
    pred = predictWord("Flask\F02_B1_C10_M2.wav","F02")
    return pred

if __name__ == "__main__":
    app.run(debug=True)    