package com.information.basic.singelton;

public final class TestingEnum {

    public static final TestingEnum MON_DAY = new TestingEnum();

    private TestingEnum ( ){

    }

    public static void main(String[] args){

        if(MON_DAY instanceof TestingEnum){
            System.out.println("yes");
        }
    }
}
