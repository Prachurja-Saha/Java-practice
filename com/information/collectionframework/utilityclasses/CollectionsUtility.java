package com.information.collectionframework.utilityclasses;

import java.util.Collections;
import java.util.List;

public class CollectionsUtility {

    public static void main(String[] args) {

        List<String> advocates = List.of("Ana", "Billy", "Denys", "Heather", "Jim", "Nicolai");
        System.out.println(Collections.binarySearch(advocates, "Billy"));//1

        Collections.frequency(advocates, "Denys");//1
        Collections.swap(advocates, 0, advocates.size() -1);

        // rotate 3 times
        Collections.rotate(advocates, 3);//Heather, Jim, Nicolai, Ana, Billy, Denys

    }
}
