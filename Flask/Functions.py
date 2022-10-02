

import pandas as pd
from . import TransformerCode



def get_word_list_UA():

    word_list_xls = pd.read_excel("./Flask/speaker_wordlist.xls", sheet_name="Word_filename", header=0)
    word_dictionary = {}

    for i in range(word_list_xls.shape[0]):
        value = word_list_xls.iloc[i].values
        word_dictionary[value[1]] = value[0]

    return word_dictionary

def get_data_UA(wavs):
    data = []
    removed_files = []
    word_dictionary = get_word_list_UA()

    for wav in wavs:
        speaker, block, word_key, mic = wavs.split('_')
        # use only the 155 words shared by all speakers
        if word_key.startswith('U'):
            # word_key = '_'.join([block, word_key])
            continue
        text = word_dictionary.get(word_key, -1)
        if text == -1:
            continue
        elif block == 'B1' or block == 'B2' or block == 'B3':
            data.append({'audio': wavs, 'text': text})


    return data


def DataProcess(wavfile):
    wavs = []
    wavs += wavfile

    data = get_data_UA(wavfile)
    # white_noise("./datasets/UASPEECHOLD/audioold/M04/M04_B3_CW12_M7.wav")

    return data


def predictWord(wavfile,models):
    predict_ds = DataProcess(wavfile)
    predict_dss = TransformerCode.create_tf_dataset(predict_ds, bs =1)
    actPred = TransformerCode.predict(models,predict_dss)
    return actPred


    