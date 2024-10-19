package com.information.string;

public class StringMethods {

    public static void main(String[] args){

        String test = "     The name of our country is India    ";

        String updatedString = test.trim();

        // trim() -> Removed leading space
        System.out.println(updatedString);

        //split() -> split string into array


        //join() ->
        String[] words = {"The", "name", "of", "our", "country", "is", "India"};
        String joinedString = String.join(" ", words); // Joins the strings with a space
        System.out.println(joinedString);

        // Used mainly for sort
        //compareTo() compare two strings lexicographically (dictionary order)
        String str1 = "apple";
        String str2 = "banana";
        int result = str1.compareTo(str2);
        System.out.println(result);  // Output will be negative since "apple" is less than "banana"
     }
}
