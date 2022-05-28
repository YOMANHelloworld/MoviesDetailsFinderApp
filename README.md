

About
-----------------------------------------
*This written in kotlin programming language in andriod studio JDE*

This application will search any movie (user input) from the internet and display the detailes like this :

 1. Title:"The Shawshank Redemption"
 2. Year: "1994"
 3. Rated: "R"
 4. Released: "14 Oct 1994"
 5. Runtime: "142 min"
 6. Genre: "Drama"
 7. Director: "Frank Darabont"
 8. Writer: "Stephen King, Frank Darabont"
 9. Actors: "Tim Robbins, Morgan Freeman, Bob Gunton"

If the user want these detailes saved within the application I have used room library so the user can save the above data. 

*fell free to modify this application for your own use*

The context within the content is
------------------------------------------
1. Utilizing room library database
2. Utilizing the extraction of JSON format to view in a text view 
3. Transfer data of JSON format into a room database 
4. Having an understanding on quey in database

Requirements
-----------------------------------------
1. Need to have a API key from http://www.omdbapi.com/ 
2. Basic knowledge of room database, JSON fromat and accessing internet throught andriod studio(need to give permission on manifest file) 

Dependencies
------------------------------------------

In the build.gradle(project:"your project name") add these things

plugins {
    id 'com.android.application' version '7.1.2' apply false
    id 'com.android.library' version '7.1.2' apply false
    id 'org.jetbrains.kotlin.android' version '1.6.10' apply false
    }


In the build.gradle(module:"your project name") add these things

dependencies {
    implementation "androidx.room:room-runtime:2.4.2"
    annotationProcessor "androidx.room:room-compiler:2.4.2"
    kapt("androidx.room:room-compiler:2.4.2")
    implementation "androidx.room:room-ktx:2.4.2"
    implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.9"
    }

