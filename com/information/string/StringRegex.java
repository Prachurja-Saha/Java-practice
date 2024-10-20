package com.information.string;

public class StringRegex {


    /*
    *       Literals:
            Directly matches characters.
            Example: "abc" matches the string "abc".

            Metacharacters (Special Characters):
            . : Matches any character except a newline.
            \d: Matches any digit (0-9).
            \w: Matches any word character (letters, digits, or underscores).
            \s: Matches any whitespace character (spaces, tabs).
            \D: Matches any non-digit.
            \W: Matches any non-word character.
            \S: Matches any non-whitespace.

            Quantifiers:
            + : One or more.
            * : Zero or more.
            ? : Zero or one.
            {n}: Exactly n occurrences.
            {n,}: At least n occurrences.
            {n,m}: Between n and m occurrences.

            Character Classes
            [abc]: Matches any single character in the set (a, b, or c).
            [a-z]: Matches any character in the range (a to z).
            [^abc]: Matches any character except a, b, or c.
            [a-zA-Z_0-9]

            Anchors:
            ^: Start of the string.
            $: End of the string
    * */
    public static void main(String[] args){

        String pattern = "\\d{3}-\\d{2}-\\d{4}"; // {3} -> exactly 3 occurrences and \d -> numbers
        String text = "123-45-6789";
        String text2 = "abc-qq-rrrr";

        System.out.println(text.matches(pattern));  // true
        System.out.println(text2.matches(pattern)); // false \\d -> (0-9)


        String userNamePattern = "^[a-zA-Z][a-zA-Z0-9]{7,29}"; // min 8 and max 30 and start with alphabet
        String userName = "antu1234";
        System.out.println(userName.matches(userNamePattern));


        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";





    }
}
