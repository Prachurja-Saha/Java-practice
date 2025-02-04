package com.information.collectionframework.part2internal.list;

import java.util.Arrays;
import java.util.Stack;

public class StackInternal<E> {

    private Object[] stackArray;
    private int stackSize = 0;
    private int stackCapacity = 10;

    StackInternal() {
        stackArray = new Object[stackCapacity];
    }

    public void push(E e) {

        if(stackSize >= stackCapacity) {
            stackArray = Arrays.copyOf(stackArray, stackCapacity * 2);
            stackCapacity *= 2;
        }
        stackArray[stackSize] = e;
        stackSize++;

    }

    public E pop() {
        if(stackSize != 0 && stackSize <= stackCapacity && stackArray[stackSize - 1] != null) {
            stackArray[stackSize - 1] = null;
            stackSize--;
            return (E) stackArray[stackSize-1]; // class cast exception handle
        } else {
            return null;
        }
    }

    public void getALL(){
        for(int i = 0; i < stackSize; i++) {
            System.out.println(stackArray[i]);
        }
    }


    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();

        StackInternal<Integer> stackInternal = new StackInternal<Integer>();
        stackInternal.push(1);
        stackInternal.push(2);
        stackInternal.push(3);
        stackInternal.push(4);
        stackInternal.push(5);

        stackInternal.getALL();

        stackInternal.pop();

        stackInternal.getALL();
    }
}
