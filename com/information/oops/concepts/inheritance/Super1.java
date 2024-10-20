package com.information.oops.concepts.inheritance;

public class Super1 {

    private int number;

    Super1(int number){
        this.number = number;
    }

    Super1(){

        System.out.println("HI");
    }

    public int square(){
        return number*number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }


    //TODO: Why multiple inheritance is not supported??

    //++++++++++++++++++++++++++++++++++++++++++++
    //TODO: PENDING JAVA T POINT WE WILL LEARN LATER

}
