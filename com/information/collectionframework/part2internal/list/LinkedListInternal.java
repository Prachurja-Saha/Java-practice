package com.information.collectionframework.part2internal.list;

import java.util.LinkedList;

public class LinkedListInternal<E> {

    private Node<E> head;
    private Node<E> tail;

    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public void addLast(E element) {

        if(head == null) {
            head = new Node<>(null, element, null);
            tail = head;
        } else {

            if(head.next == null) {
                tail = new Node<>(tail, element, null);
                head.next = tail;
            } else {
                tail.next = new Node<>(tail, element, null);
            }
        }
    }

    public void addFirst(E element) {

        if(head == null) {
            head = new Node<>(null, element, null);
        } else {
            head = new Node<>(null, element, head);
        }
    }

    // need to improve
    public void add(int index, E element) {

        int size = 0;
        Node<E> traverseNode = head;
        if(traverseNode != null && index > 0 ) {
            index--;
            traverseNode = traverseNode.next;
            size++;
        }

        Node<E> newNode = new Node<>(null, element, traverseNode);
        traverseNode.prev.next = newNode;
        traverseNode.prev = newNode;

    }

    public Node<E> getInitialNode() {
        return head;
    }


    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();

        // Singly LinkedList contains single node -> (contains next element address)
        // Doubly LinkedList conains 2 node -> (contains previous and next element address)

        LinkedListInternal<Integer> list2 = new LinkedListInternal<Integer>();
        list2.addLast(1);
        list2.addLast(2);
        list2.addLast(3);

        Node<Integer> head = list2.getInitialNode();
        while(head != null) {

            System.out.println(head.item.toString());
            head = head.next;
        }

        list2.addFirst(100);
        list2.addFirst(200);

        System.out.println("After addFirst");
        Node<Integer> head2 = list2.getInitialNode();
        while(head2 != null) {

            System.out.println(head2.item.toString());
            head2 = head2.next;
        }

    }
}
