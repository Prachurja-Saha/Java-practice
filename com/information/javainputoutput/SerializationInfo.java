package com.information.javainputoutput;

/**
 * Serialization is the process of converting an object into a byte stream[binary data] so that it
 * can be saved to a file or transferred over a network. Deserialization is the reverse process, converting a byte stream
 * back into an object.
 */
public class SerializationInfo {

    /* Imprortant Points*/
                                  // Serialization                                     // DeSerialization
    /* Java Object Serialization [java object -> byte-stream -> (Data-Base, file, memory) -> byte-stream -> object*/
    // 1. Classes that are eligible for Serialization needs to implement Serializable interface (Marker interface)
    // 2. All the field  in the class must be Serializable.
    //            If a field is not serializable than it must be marked transient
    // 3. Static fields are not serializable (b/c static belongs to the class not object).
    // 4. ByteStream are platform independent (means once u have stream of bytes u can convert it into any object and
    //            run it to any kind of environment. but java object are platform dependent(JVM dependent).
/*
          5. way to convert an object into stream -> ObjectOutputStream consist method -> writeObject()
          way to convert an stream into object -> ObjectInputStream  consist method -> readObject()
*/

    /* watch code decode yt video for more learning*/

    /*
    *   JAR File: A Java ARchive (JAR) is a compressed file format that contains the entire project,
    *   including compiled classes (.class files), resources, libraries, and metadata.
    *   It's used to distribute and deploy Java applications or libraries.
    *
    *   Byte Stream (in Serialization): A byte stream is a sequence of bytes representing an object or data.
    *   Serialization converts a Java object into this byte stream so it can be stored in a file, sent over a
    *   network, or transmitted between systems. It focuses on transferring object data, not the entire project.
    *
    *   example -> microservice communication via data However, in modern microservices, formats
    *      like JSON or XML (which are text-based) are more common than traditional Java serialization
    *      (which is binary)
    *
    *   Modern ->Serialization-(java object -> json/xml) Deserialization ( json/xml -> Java object)
    * */

    /*
    *  Byte streams indeed transmit raw binary data directly, which means simple byte-by-byte data doesn't need
    *  further serialization or deserialization. However, when dealing with complex objects or structured data in
    *  Java, you absolutely need serialization and deserialization.

        Key Points:
        Raw Binary Data: For simple byte-by-byte data transfer
        * (e.g., reading or writing raw bytes from/to a file), no serialization/deserialization is needed.

        Example: Reading/writing binary files like images, where data is handled as raw bytes.

        Complex Objects or Structured Data:
        When transferring complex objects, Java provides serialization to convert these objects into a byte stream.

        Serialization: Converts a Java object into a byte stream.
        Deserialization: Converts the byte stream back into a Java object.
    * */


}
