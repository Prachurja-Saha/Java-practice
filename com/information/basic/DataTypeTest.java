package com.information.basic;

public class DataTypeTest {

    /*
    *
    * Primitive data types - includes byte , short , int , long , float , double , boolean and char.
    * They’re stored directly on the stack
    *
    * Non-primitive data types - such as String , Arrays and Classes(all object type)
     * */

    public  static  void main(String[] args){

        int x = 2;
        int largeNumber = 10_1_11121; // we can provide underscore it will act as ` , ` for large numver
        double y = 5; // 5.0
        String s = "abc";
        String m = ""+1+2+""; // ans is 12 not 3 we have to provide ()
        System.out.println(m);
        m = ""+(1+2)+"";
        System.out.println(m); // now 3
        // <variable type> <variable name> = <object type> => here right side will evaluate first and assign to left side

        switch (x){
            case 1,2,3,4:
                System.out.println("found");
                break;

            case 6,7:
                System.out.println("-");
                break;
            default:
                System.out.println('l');
                break;
        }

    }
}
