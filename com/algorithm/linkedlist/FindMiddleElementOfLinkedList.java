package com.algorithm.linkedlist;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class FindMiddleElementOfLinkedList {

    public static void main(String[] args){

        LinkedList<Integer> linkedList = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter integers (enter -1 to stop):");
        while (scanner.hasNext()){

            int input = scanner.nextInt();
            if (input == -1) {
                break;
            }
            linkedList.addLast(input);

        }

        // Basic approach
        System.out.println("Middle Element");
        if(!linkedList.isEmpty())
            // linkedList.size() -> o(1) linklist maintains count + linklist.get(i) -> o(n) b/c no indexing
            System.out.println(linkedList.get(linkedList.size()/2));
        else {
            System.out.println("No Result");
        }

        // Best Approch
        ListIterator<Integer> fastIterator = linkedList.listIterator();
        ListIterator<Integer> slowIterator = linkedList.listIterator();

        // 1,2,3,4,s5,6,7,8,f9
        while(fastIterator != null && fastIterator.hasNext()){

            //moved my single node
            slowIterator.next();

            // moved by double
            fastIterator.next();
            if(fastIterator.hasNext()){
                fastIterator.next();
            }
        }

        System.out.println(slowIterator.previous());


    }
}
