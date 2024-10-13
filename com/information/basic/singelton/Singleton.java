package com.information.basic.singelton;

/**
 * When there is no need to create multiple instance there we use Singleton
 * example -> Enum, A logging class or configuration manager
 * In Enum we just define Constant with values no need to create multiple instance one instance is enough for
 * the application. helps Improve performance and reduce complexity
 */
public class Singleton {

    /*
            A Singleton is a design pattern in object-oriented programming that ensures a class has only one instance
            and provides a global point of access to that instance.
            This is useful when exactly one object is needed to coordinate actions across the system
            (e.g., logging, database connection, etc.).
     */

    /*
    * Key Characteristics of a Singleton:
        Single Instance: Only one instance of the class is created during the lifetime of the application.
        Global Access: The single instance is accessible globally, meaning you can use it anywhere in your application.
        Private Constructor: The constructor is made private to prevent other classes from creating a new instance.
     */


    // The single instance of the class
    private static Singleton instance;

    public static final int NoOfSea = 7;
    public static final int NoOfPlanet = 11;

    // Private constructor to prevent instantiation from outside
    private Singleton() {
        // Initialization code (if any)
    }

    // Public method to provide access to the single instance
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();  // Lazy initialization
        }
        return instance;
    }

    public static void main(String[] args){

        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        // Both variables point to the same instance
        System.out.println(singleton1 == singleton2);  // true

        System.out.println(singleton1.NoOfPlanet);
    }

    /*
    Configuration Management: A singleton can be used to manage application settings and configurations.
    Logging: A logging utility often follows the singleton pattern to ensure that all parts of the application
                log messages to the same output.
    Caching: Singletons can be used to manage caches where multiple parts of the application need to
                access cached data.
     */
}
