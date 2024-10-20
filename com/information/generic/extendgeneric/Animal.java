package com.information.generic.extendgeneric;


public class Animal {

    private int legs;
    private double avgSpeed;

    public Animal(int legs, double avgSpeed) {
        this.legs = legs;
        this.avgSpeed = avgSpeed;
    }

    public void print(){

        System.out.println("Animal speed : " + avgSpeed + "Legs :" + legs);
    }
}
