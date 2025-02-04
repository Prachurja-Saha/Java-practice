package com.information.javainputoutput;

// Jackson: Handles the parsing and conversion from JSON string to Java object.
public class JacksonLibraryTest {

    /*
    * Parsing: In Java, the ObjectMapper from Jackson or any other JSON library works with strings to parse the JSON
    * structure and convert it into Java objects.
    *
    * JSONString is a string representation of a JSON object. In Java, when you serialize a Java object to JSON using a
    * library like Jackson, the result is a JSON string. This JSON string is a textual representation of the JSON data.
    * */

    public static void main(String[] args){

        // jsonString is the JSON data in string format.
        // mapper.readValue(jsonString, User.class) converts the JSON string into a Java object of type User.

        // serialization -> [ java object ---> json String ]
        // deserialization -> [ json string ----> java object]

        /*
        * When a Java application receives JSON data, especially in a web application context
        * (such as a Spring Boot application), the data is received as part of an HTTP request.
        * This data is inherently in a text format, which is essentially a JSON string.
        * */

    }
}
