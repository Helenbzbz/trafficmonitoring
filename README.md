# TensorFlow Lite Object Detection Deployment
## DSMG-17 Harvard Extension
### Author: TensorFlow, Sean Greene, Helen Zheng, David Rivers, Maggie Ma

# Part 1. Models
## Model Deployed
[MobileNet SSD](https://tfhub.dev/tensorflow/lite-model/ssd_mobilenet_v1/1/metadata/2),
[EfficientDet Lite 0](https://tfhub.dev/tensorflow/lite-model/efficientdet/lite0/detection/metadata/1),
[EfficientDet Lite1](https://tfhub.dev/tensorflow/lite-model/efficientdet/lite1/detection/metadata/1),
or
[EfficientDet Lite2](https://tfhub.dev/tensorflow/lite-model/efficientdet/lite2/detection/metadata/1)
model trained on the [COCO dataset](http://cocodataset.org/).

## Model Download
Model files are downloaded as .tflite files with medidata prepackaged. See tensorflow hub for available prebuilt models. 
Additional models can be added by using TensorFlows model converter and saving as a tflite.

# Part 2. Deployment on Android
## Overview
This app uses both prebuilt tensorflow lite libraries and a custom tensorflow lite model to process a continuous stream from an Android device. 
**This application should be run on a physical Android device**
**Build in Android Studio. This was tested in Flamingo**

Video DEMO
Videos & Graphs/Android Deployment.mp4
The video is also available at: https://www.youtube.com/watch?v=WqbGBtzQJUc

## Prerequisites

*   The **[Android Studio](https://developer.android.com/studio/index.html)**
    IDE. This sample has been tested on Android Studio Bumblebee.

*   A physical Android device with a minimum OS version of SDK 24 (Android 7.0 -
    Nougat) with developer mode enabled. The process of enabling developer mode
    may vary by device. This device will also need to have the latest version of
    Google Play Services installed.

## Building

*   Open Android Studio. From the Welcome screen, select Open an existing
    Android Studio project.

*   From the Open File or Project window that appears, navigate to and select
    the tensorflow-lite/examples/object_detection/android_play_services
    directory. Click OK.

*   If it asks you to do a Gradle Sync, click OK.

*   With your Android device connected to your computer and developer mode
    enabled, click on the green Run arrow in Android Studio.

## Initialize additional tflite models on Android
1. Download a prebuilt tflite (object detection) model: https://tfhub.dev/
2. Save a copy of the tflite file in src/main/assets folder
3. In the ObjectDetectorHelper.kt kotlin file, add a new Key:Value under val modelName OR set modelName directly to your model's filename

**Terms:** By accessing or using TensorFlow Lite in Google Play services APIs,
you agree to the [Terms of Service](https://www.tensorflow.org/lite/android/play_services#tos).
Please read and understand all applicable terms and policies before accessing
the APIs. 

##  Adjusting Model Performance  
Adjust model's options such as the prediction threshold and number of results:
val optionsBuilder =
`code()` 
ObjectDetector.ObjectDetectorOptions.builder()
.setScoreThreshold(threshold)
.setMaxResults(maxResults) 

# Part 3. Deployment on Raspberry Pi

## Overview
The deployment applies prebuilt tensorflow lite libraries and a custom tensorflow lite model to process a continuous stream on the Raspberry pi. 
**The code below referred to: https://github.com/tensorflow/examples/tree/master/lite/examples/object_detection/raspberry_pi**

Demo Video
Videos & Graphs/Raspberry Pi.mp4

## Hardwares Required
Components needed
Videos & Graphs/Hardware needed.jpg

* Raspberry pi 4 Model B
* Raspberry pi Camera Module v2/v3
* SD Card (with 64 bit OS System)
* Mouse
* Keyboard
* External Screen with HDMI connector
* Raspberry pi Charger

## Hardware setup

Demo Video
Videos & Graphs/Raspberry pi installation.mp4

1. Write 64-bit OS System to the SD card (32-bit will not work given Tensorflow Lite do not support 32-bit OS system). Further question please referred to: https://www.raspberrypi.com/documentation/computers/getting-started.html
2. Connect Raspberry pi with mouse, keyboards, charger, external screens, and camera module. See above video for detailed instructions
3. Raspberry pi should now automatically open itself, follow the instructions to set account, connect to Wifi, and reboot

## Test Camera Module
In the latest Raspberry pi 4 desktop version OS, camera should be automatically enabled. sOpen the terminal, run the following command to test if camera module is working:
`libcamera-still -o test.jpg`
You should see a photo being taken and saved as test.jpg

## Run the Object Detection
1. Download the Raspberry Pi Deployment Folder
2. Run this command in the terminal
`cd Raspberry Pi Deployment`
`sh setup.sh`
3. Open the object_detection.py. Change the parameters in the main() function. The default parameters set the model to efficient_lite0.tflite, Run type to TPU, CPU numbers to 4, and camera size to 640*480
4. Run the object detection code with the following command
`python3 object_detection.py`

## Use other tflite models on Raspberry Pi
1. Download a prebuilt tflite (object detection) model: https://tfhub.dev/
2. Save a copy of the tflite file in Raspberry Pi Deployment folder
3. In the main() function change the path of model file
