# Project: 49: Not Optimus Prime

 A ASR for dysarthric individuals using transformers.

## Setup environment

The project was executed on Windows and the instructions are for the same.

1. Unzip the file and open Anaconda command and change directory to the root folder.

2. Create a new envoronment on anaconda

```bash
conda create -n name
```

3. Activate the environment

```bash
conda activate test
```

4. Install pip

```bash
conda install pip
```

5. Install required packages

```bash
pip install -r requirements.txt
```

6. Install [ngrok](https://ngrok.com/) and also make an account.

7. Unzip the zipped ngrok folder.

## To Run

1.  Double click on the ngrok app in the zipped folder and follow Step 2 of [this](https://dashboard.ngrok.com/get-started/setup) documentation to connect your account.

2.  Open Anaconda and open the previously created environment and direct to the root repository and run flask

```bash
flask run
```

Note the port number this is running on. It was port 5000 but it might differ.

3. Now open ngrok application from the folder and run this command.

```bash
ngrok http 5000
```

Change the portnumber if it was not the same for you.

Note and copy the forwarding link which should be in this form

```bash
Forwarding                    https://590b-2407-7000-8955-b100-bc00-4e9f-118-f242.au.ngrok.io -> http://localhost:5000
```

We would only need the first part

```bash
https://590b-2407-7000-8955-b100-bc00-4e9f-118-f242.au.ngrok.io
```

4. Open NotOptimusPrime folder on Android studio and open SpeakerDetailsActivity.java.

5) Change the String ngrok to the forwarding link you just receieved.

```java
String ngrok = "https://590b-2407-7000-8955-b100-bc00-4e9f-118-f242.au.ngrok.io";
```

6. Run the application on emulator or any physical device.

## Navigating on the app

1. You would be able to see different speakers, their gender and their intelligiblity levels. You can aslo run the mdeia and try guessing what the speaker is trying to say.

2. Clicking on the tilte would redirect to the page with imformation about the command.
   This page also has option to predict using a normal speech recogniton and using the model proposed in this research.
   The prediction is real time nd thus might take some time.
