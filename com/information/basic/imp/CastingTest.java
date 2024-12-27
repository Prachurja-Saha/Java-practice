package com.information.basic.imp;

public class CastingTest {
    public static void main(String[] args) {

        Object obj = "Amit";
        String a = (String) obj; // type casting

        Object obj2 = 1;
        Integer b = (Integer)obj2;

        System.out.println(a + "-" + b);

        String a2 = obj2 + ""; // Here what is happening -> obj2.toString() + ""
        System.out.println(a2);
        //Integer a1 = (Integer)obj; // Class cast exception at runtime b/c obj of type String

        if(obj2 instanceof String) {
            a2 = (String) obj2;
        }

        int x = 10;
        double d  = x;
        System.out.println(" Int to Double " + d); // output : 10.0
        int y = (int)d;
        System.out.println(" Double to int " + y);

        int k =6;
        while (k > 0) {
            if (k % 2 == 0) {
                // The loop will continue when i is even
                // Add your logic for even numbers here if needed
                k -= 2;
                continue;  // Optional: if you want to skip further code in the loop
            }
            // If i is not even, the loop will break
            break;
        }

    }
}
