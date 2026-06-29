package test;

/**
 * Modularity: Every project needs jar file (rt.jar-> runtime jar)
 * it contains everything which we used in our project (i.e. String class.. all)
 * In a project we are using all Jars instead of required jars. This problems solved in JDK 9
 * In JDK 9 java developer created modules (approx 99 modules) and we can create our own module
 * We just need to specify the modules (in module-info.java)
 *
 * Jigsaw project
 */
public class Mainn {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}