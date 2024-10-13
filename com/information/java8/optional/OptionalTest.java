package com.information.java8.optional;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Optional<T> is a class inside there many methods are present
 * Some Important methods in Optional which is very useful
 * For Null Check it is used
 */
public class OptionalTest {

    private static <T> Optional<T> getName(T t){

        /* if t is Null then Exception at below line so we have to use Optional.Nullable*/
        return Optional.of(t);
    }

    // NullableCheck
    private static <T> Optional<T> getNameWithNullCheck(T t){

        return Optional.ofNullable(t);
    }


    public static void main(String[] args) {

        /* Creation of Optional */ System.out.println("Creation of optional started ");

        Optional<String> info = Optional.of("Info");
        System.out.println(info.get());

        // Checking null
        Optional<String> infoCanBeNull = Optional.ofNullable(null);
        String check = infoCanBeNull.isPresent() ? infoCanBeNull.get() : "Not Present";
        System.out.println(check);

        // Alternative1 orElse
        String checkAlternative = infoCanBeNull.orElse("Not present using orElse");
        System.out.println(checkAlternative);

        // Alternative2 orElseGet
        System.out.println(infoCanBeNull.orElseGet(()-> "Not Present using lambda (orElseGet)"));

        // Alternative3 orElseThrow
        Optional<String> infoCanBeNull2 = Optional.ofNullable("Not Null");
        // here infoCanBeNull2 is not null so no exception
        System.out.println(infoCanBeNull2.orElseThrow(() -> new NoSuchElementException()));
        System.out.println(infoCanBeNull2.orElseThrow(NoSuchElementException::new));// same as above



        /* Imp Operation*/ System.out.println("Operation started");

        Optional<String> name = getName("Amit");

        // Null Check
        if(name.isPresent()){
            System.out.println("Name is present :" + name.get()); // Here name is not value inside optional
        }                                                          // that's why used get()

        // using lamda
        name.ifPresent( i -> System.out.println("using lamda "+i)); // Here i is value inside optional


        /* But there is a issue if inside getName() name is null for that we have to use optional.Nullable */
        // Optional<String> nullName = getName(null);

        Optional<String> nullName = getNameWithNullCheck(null);
        nullName.ifPresent(System.out::println); // If Not Null then


        Optional<String> newName = getNameWithNullCheck("amit");
        newName.map(i -> i.toUpperCase()).ifPresent(System.out::println);

        Optional<String> newNameWithNull = getNameWithNullCheck(null);
        newNameWithNull.map(i -> i.toUpperCase()).ifPresent(System.out::println);

    }
}
