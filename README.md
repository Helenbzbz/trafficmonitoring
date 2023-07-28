# TensorFlow Lite Object Detection Android
## DSMG-17 Harvard Extension
### Author: TensorFlow, Sean Greene, Team  Traffic Detection

### Overview

This app uses both prebuilt tensorflow lite libraries and a custom tensorflow lite model to process a continuous stream from an Android device. 

[MobileNet SSD](https://tfhub.dev/tensorflow/lite-model/ssd_mobilenet_v1/1/metadata/2),
[EfficientDet Lite 0](https://tfhub.dev/tensorflow/lite-model/efficientdet/lite0/detection/metadata/1),
[EfficientDet Lite1](https://tfhub.dev/tensorflow/lite-model/efficientdet/lite1/detection/metadata/1),
or
[EfficientDet Lite2](https://tfhub.dev/tensorflow/lite-model/efficientdet/lite2/detection/metadata/1)
model trained on the [COCO dataset](http://cocodataset.org/).

## Models Uses
Model files are downloaded as .tflite files with medidata prepackaged. See tensorflow hub for available prebuilt models. 
Additional models can be added by using TensorFlows model converter and saving as a tflite.


# Initialize additional tflite models #   
1. Download a prebuilt tflite (object detection) model: https://tfhub.dev/
2. Save a copy of the tflite file in src/main/assets folder
3. In the ObjectDetectorHelper.kt kotlin file, add a new Key:Value under val modelName OR set modelName directly to your model's filename

**Terms:** By accessing or using TensorFlow Lite in Google Play services APIs,
you agree to the [Terms of Service](https://www.tensorflow.org/lite/android/play_services#tos).
Please read and understand all applicable terms and policies before accessing
the APIs.

# This application should be run on a physical Android device #

## Adjusting Model Performance ##   
Adjust model's options such as the prediction threshold and number of results:
val optionsBuilder =
`code()` 
ObjectDetector.ObjectDetectorOptions.builder()
.setScoreThreshold(threshold)
.setMaxResults(maxResults)   

--------- NEED DEMO VIDEO ----------------


## Build in Android Studio. This was tested in Flamingo

### Prerequisites

*   The **[Android Studio](https://developer.android.com/studio/index.html)**
    IDE. This sample has been tested on Android Studio Bumblebee.

*   A physical Android device with a minimum OS version of SDK 24 (Android 7.0 -
    Nougat) with developer mode enabled. The process of enabling developer mode
    may vary by device. This device will also need to have the latest version of
    Google Play Services installed.

### Building

*   Open Android Studio. From the Welcome screen, select Open an existing
    Android Studio project.

*   From the Open File or Project window that appears, navigate to and select
    the tensorflow-lite/examples/object_detection/android_play_services
    directory. Click OK.

*   If it asks you to do a Gradle Sync, click OK.

*   With your Android device connected to your computer and developer mode
    enabled, click on the green Run arrow in Android Studio.

### Models used   
1. MobileNetV2 as tflite with metadata file
2. EfficientDet as tflite with metadata file
3. MobileNetV2 - fine tuned and converted to a tflite file
