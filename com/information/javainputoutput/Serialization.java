package com.information.javainputoutput;

public class Serialization {

    /* Imprortant Points*/
                                  // Serialization                                     // DeSerialization
    /* Java Object Serialization [ object -> byte-stream -> (Data-Base, file, memory) -> byte-stream -> object*/
    // 1. Classes that are eligible for Serialization needs to implement Serializable interface (Marker interface)
    // 2. All the field  in the class must be Serializable.
    //            If a field is not serializable than it must be marked transient
    // 3. Static fields are not serializable (b/c static belongs to the class not object).
    // 4. ByteStream are platform independent (means once u have stream of bytes u can convert it into any object and
    //            run it to any kind of environment. but java object are platform dependent(JVM dependent).
    // 5. way to convert an object into stream -> ObjectOutputStream consist method -> writeObject()
    //    way to convert an stream into object -> ObjectInputStream  consist method -> readObject()

    /* watch code decode yt video for more learning*/


}
