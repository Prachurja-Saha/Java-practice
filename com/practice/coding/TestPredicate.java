package com.practice.coding;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;


class User {

    public String name;
    public int roll;
    public LocalDate dob;

    public User(String name, int roll, LocalDate dob) {
        this.name = name;
        this.roll = roll;
        this.dob = dob;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", roll=" + roll +
                ", dob=" + dob +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getRoll() {
        return roll;
    }

    public LocalDate getDob() {
        return dob;
    }
}

public class TestPredicate {

    public <T> Predicate<T> check(T element){

        return (o1)->{

            if(element instanceof String && (element == null || ((String) element).isBlank())) {

                    return true;
            } else if (element instanceof Integer && (element == null || element.equals(0))) {

                return  true;
            }

            return o1.equals(element);
        };
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        TestPredicate testPredicate = new TestPredicate();

        List<User> dataBaseDummy = new ArrayList<>();
        dataBaseDummy.add(new User("Amit", 1, LocalDate.of(2000, 1, 13)));
        dataBaseDummy.add(new User("Akash", 1, LocalDate.of(2000, 1, 13)));
        dataBaseDummy.add(new User("Ronit", 2, LocalDate.of(2000, 1, 13)));
        dataBaseDummy.add(new User("Amit", 2, LocalDate.of(2000, 2, 13)));
        dataBaseDummy.add(new User("Akash", 1, LocalDate.of(2000, 1, 13)));


        System.out.print("Enter Name to Search: ");
        String name = scanner.nextLine();

        System.out.println("Enter Roll: ");
        Integer roll = scanner.nextInt();


        Predicate<String> testName = testPredicate.check(name);

        Predicate<Integer> testRoll = testPredicate.check(roll);


        System.out.println("After filtering");
        for(User u : dataBaseDummy){

            if(testName.test(u.name) && testRoll.test(u.roll)){
                System.out.println(u);
            }

        }

        //ListIterator<User> iterator = dataBaseDummy.listIterator();

        //System.out.println(testName.test("Amit"));

        //System.out.println("Enter DOB");
    }
}
