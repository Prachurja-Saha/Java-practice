package com.information.annotaion;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
/**
 * <p style = "color: white">
 *     Annotation provides meta data/ information <br>
 *     Annotation helps developer not do mistakes, it corrects us in compile time i.e. @override, @functional interface
 *     and many more
 * </p>
 */
@Prachurja
public class CreatingCustomAnnotation {

    @ImportantString
    String name;

    public CreatingCustomAnnotation(String name) {
        this.name = name;
    }

    @Saha
    void test(){
        System.out.println("Test");
    }

    @RunImmediately(times = 1)
    void cat(){
        System.out.println("cat");
    }

    void dog(){
        System.out.println("dog");
    }

    public static void main(String[] args){

        CreatingCustomAnnotation creatingCustomAnnotation = new CreatingCustomAnnotation("Antu");

        if(creatingCustomAnnotation.getClass().isAnnotationPresent(Prachurja.class)){
            System.out.println("creatingCustomAnnotation is annotated with Prachurja");
        }

        try {

            // invoking method which contains RunImmediately annotation
            for(Method sigleMethod : creatingCustomAnnotation.getClass().getDeclaredMethods()) {

                if (sigleMethod.isAnnotationPresent(RunImmediately.class)){
                    System.out.println("If there is RunImmediately annotation then method will run immediately");
                    sigleMethod.invoke(creatingCustomAnnotation);
                    RunImmediately runImmediately = sigleMethod.getAnnotation(RunImmediately.class);
                    System.out.println(runImmediately.times());
                }
            }

            // extracting test method and testing it contains Saha annotation
            Method method = creatingCustomAnnotation.getClass().getDeclaredMethod("test");
            if(method.isAnnotationPresent(Saha.class)){
                System.out.println("test is annotated with Saha");
            }

            // invoking fields which contains ImportantString annotation
            for(Field field : creatingCustomAnnotation.getClass().getDeclaredFields()) {

                if (field.isAnnotationPresent(ImportantString.class)){
                     Object o = field.get(creatingCustomAnnotation);

                     if(o instanceof String myStringName){
                         System.out.println("Important String is " + myStringName);
                     }
                }
            }

        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}
