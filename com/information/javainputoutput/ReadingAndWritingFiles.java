package com.information.javainputoutput;

import java.io.*;
import java.util.Arrays;

public class ReadingAndWritingFiles {

    public static void main(String[] args) throws FileNotFoundException {

        /* Create and Write File -> Buffer Writer*/
        String[] names = {"Amit", "Utshow", "Shudipto", "Prachurja", "Arka", "Banik"};
        try {

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("saha.txt"));
            // It will create a new File name saha.txt in project file location if not present
            // If i want any specific location than i have to provide full path with double \\
            // i.e -> C:\\Users\\PS75215\\AppData\\Local\\saha.txt

            bufferedWriter.write("Hi Everyone");
            bufferedWriter.write("\n new Line Hi");

            for(String name : names){
                bufferedWriter.write("\n"+name);
            }

            // Not working
//            Arrays.stream(names).forEach( i -> {
//                try {
//                    bufferedWriter.write("\n"+i);
//                    bufferedWriter.close();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            });

            bufferedWriter.close(); // -> imp otherwise file will not create

        } catch (IOException e) {
            e.printStackTrace();
            throw new FileNotFoundException(e.getMessage());
        }


        /* Read File -> Buffer Reader*/

        try {

            BufferedReader bufferedReader = new BufferedReader(new FileReader("saha.txt"));
            System.out.println(bufferedReader.readLine()); // print first line

            String s;
            while((s = bufferedReader.readLine())!=null)
                System.out.println(s);


        } catch (FileNotFoundException e){
            throw new FileNotFoundException("File Not Found");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
