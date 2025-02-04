package com.information.collectionframework.part2internal.list;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// Arraylist and LinkedList are not thread safe can cause problem in concurrent modification
// i.e. removing from list while traversing(can solve using iterator)
// or multiple threads concurrently modifying single array object
// and Vector and Stack is synchronized so here lock will be used
// all above problem-solved by CopyOnWriteArrayList
public class CopyOnWriteArrayListInternal {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        // Used only when there is Read intensive task or works
        /*
            Here there is 2 Operation
            1. Read : Here it will be unaffected by concurrent threads write operation b/c
                      it will be Read from original list
            2. Write: It will not change the original list, this will create a copy of the original list and
                      perform modification. After all modification original list will be updated
         */

        CopyOnWriteArrayListInternal copy = new CopyOnWriteArrayListInternal();

        /* Below this his is one example there can be another example where you can create 2 or more thread
        *  and execute read and write thread concurrently using arrayList and CopyOnWriteArrayList arrayList
        *  will throw exception while CopyOnWriteArrayList will not */
        // 1:
        // copy.usingArrayList();  // this will throw concurrent modification to resolve this issue we use ths DS
        // 2:
        copy.usingCopyOnWriteArrayList();

    }

    public void usingArrayList() {
        List<Integer> list = new ArrayList<>();
        list.add(1);

        for(Integer i : list){
            if(i == 1){
                list.add(2); // Here we are modifying list at the time of iteration
                // this will throw concurrent modification exception
            }
        }
    }

    public void usingCopyOnWriteArrayList() {
        List<Integer> list = new CopyOnWriteArrayList<>();
        list.add(1);
        list.add(2);

        for(Integer i : list){
            if(i == 1){
                list.add(3); // this will execute after the for loop task complete
            }

            System.out.println(i); // old list element will print
        }

        // after for loop new updated list will be print
        System.out.println(list);
    }


}
