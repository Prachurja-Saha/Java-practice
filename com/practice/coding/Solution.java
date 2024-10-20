package com.practice.coding;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;
/*
 * Create the Student and Priorities classes here.
 */

class Student {
    private String name;
    private Double cgpa;
    private Integer id;

    Student(String name, Double cgpa, Integer id){
        this.cgpa = cgpa;
        this.name = name;
        this.id = id;
    }

    String getName(){
        return this.name;
    }

    Double getCgpa(){
        return this.cgpa;
    }

    Integer getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return name+" "+cgpa+" "+id;
    }

}

class Priorities {

    public List<Student> getStudents (List<String> events){

        Queue<Student> queue = new PriorityQueue<>(
                Comparator.comparingDouble(Student::getCgpa).reversed()
                        .thenComparing(Student::getName)
                        .thenComparingInt(Student::getId));

        for(String s : events){
            if(s.contains("ENTER")){
                queue.add(setStudents(s));
                System.out.println("a->" + queue);
            } else {
                System.out.println("r->" + queue);
                queue.poll();
            }
        }
        List<Student> list = new ArrayList<>(queue);
        return list;
    }

    // Return Student
    public Student setStudents(String s){

        int count = -1;
        String name="";
        String cgpa = "";
        String id = "";

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) != ' ' && count== -1){
                continue;

            } else if(s.charAt(i) != ' ' && count == 0) {
                name += s.charAt(i);
            }  else if(s.charAt(i) != ' ' && count == 1) {
                cgpa += s.charAt(i);
            } else if(s.charAt(i) != ' ' && count == 2){
                id += s.charAt(i);
            } else{
                count++;
            }
        }

        return new Student(name, Double.valueOf(cgpa), Integer.parseInt(id));

    }
}


public class Solution {
    private final static Scanner scan = new Scanner(System.in);
    private final static Priorities priorities = new Priorities();

    public static void main(String[] args) {
        int totalEvents = Integer.parseInt(scan.nextLine());
        List<String> events = new ArrayList<>();

        while (totalEvents-- != 0) {
            String event = scan.nextLine();
            events.add(event);
        }

        List<Student> students = priorities.getStudents(events);

        if (students.isEmpty()) {
            System.out.println("EMPTY");
        } else {
            for (Student st: students) {
                System.out.println(st.getName());
            }
        }
    }
}