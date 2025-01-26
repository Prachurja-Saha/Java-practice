package com.information.collectionframework.part2internal.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListInternal<E> {

    List<Integer> integerList = new ArrayList<>(5); // by default arraylist capacity is 10
    // if size exceeds capacity then capacity will increase by 1.5 times

    public int defaultSize = 10;
    int elementCount = 0;

    Object[] elementData = new Object[defaultSize];

    public boolean add(E element) {
        elementCount++;
        if(elementCount > elementData.length ) {

            Object[] newElementData = new Object[elementData.length * 2];
            for(int i = 0; i < elementData.length; i++) {
                newElementData[i] = elementData[i];
            }
            elementData = newElementData;

            /* Alternative */
            //elementData = Arrays.copyOf(elementData, elementData.length * 2);

            System.out.println("New Array" + Arrays.toString(elementData));
            elementData[elementCount-1] = element;

        } else{
            elementData[elementCount-1] = element;
        }
      return true;
    }

    public boolean remove(E element) {

        for(int i=0; i<elementData.length; i++) {
            if(elementData[i] == element) {
                remove(i);
            }
        }

        return true;
    }

    public boolean remove(int index) {

        for(int i = index; i < elementCount; i++) {

            elementData[i] = elementData[i+1];
        }
        elementData[elementCount-1] = null;
        elementCount--;

        return true;
    }

    public void getElementData() {
        for (int i = 0; i < elementCount; i++) {
            System.out.println(elementData[i]);
        }
    }

    public int getCapacity(){
        return elementData.length;
    }

    public int getSize(){
        return elementCount;
    }

    public static void main(String[] args) {
        System.out.println("ArrayList");
        ArrayListInternal<String> s = new ArrayListInternal<String>();
        s.add("a");
        s.add("b");
        s.add("c");
        s.add("d");
        s.add("e");
        s.getElementData();
        System.out.println("capacity: " + s.getCapacity() + " - " + "Size: " + s.getSize());
        s.add("f");
        s.add("g");
        s.add("h");
        s.add("i");
        s.add("j");
        s.add("k");
        s.add("l");

        s.getElementData();
        System.out.println("capacity: " + s.getCapacity() + " - " + "Size: " + s.getSize());

        s.remove(0);
        System.out.println("checking remove");
        s.getElementData();
    }
}
