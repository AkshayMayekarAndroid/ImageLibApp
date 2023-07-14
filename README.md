# ImageLibApp

This README file contains information and instructions on how to set up and use the Android project.

<h1>Project Description</h1>
This Android project is designed to fetch Dog images from the API.

include the following libs to your project for library to work
        
        //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation 'com.squareup.retrofit2:converter-gson:2.9.0'

        //okhttp
    implementation "com.squareup.okhttp3:okhttp:4.10.0"
    implementation "com.squareup.okhttp3:logging-interceptor:4.10.0"

To Initialize the Library, used following -
        
    val imageLib = ImageLib()
    imageLib.init()

with the help of the below helper methods you  can fetch images as required.

    suspend fun getImage(onImageLoadListener: OnImageLoadListener) // Gets one image of a dog from the library.

    suspend fun getImages(
        number: Int,
        onImageLoadListener: OnMultipleImageLoadListener
    ) // Gets the number of dog images mentioned in the method

    suspend fun getNextImage(onImageLoadListener: OnImageLoadListener) // Gets the next image of a dog

    suspend fun getPreviousImage(onImageLoadListener: OnImageLoadListener) // Gets the previous image of a dog


<h3>It is developed using below mention points </h3> - [mention programming languages, libraries, frameworks, or tools used in the project].

<h2>Tools/IDE </h2>
<b>- Android Studio</b>
<H2><b>Programming languages </h2>
<b>- Kotlin</b>

<h2>Networking </h2>

<B> - OKHTTP3 </B><br>
<B> - Retrofit2 </B>



<B>  </B><br>
<B>  </B><br>
<B>  </B><br>

Getting Started
To set up the Android project, follow these steps:

Clone the repository from [https://github.com/AkshayMayekarAndroid/ImageLibApp.git].
bash
Copy code
git clone [[repository URL](https://github.com/AkshayMayekarAndroid/ImageLibApp.git)]
Open Android Studio and select "Open an existing Android Studio project". Navigate to the cloned repository and select the project folder.

Android Studio will automatically sync the project and download any missing dependencies.

Connect an Android device or set up an emulator to run the app.

Build and run the project in Android Studio to install the app on the connected device or emulator.



<h2>Contact Information<h2>
[Email - Akshaymayekar2008@gmail.com]


