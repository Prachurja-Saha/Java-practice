package com.practice;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = 0;

        for(int i = 2; i <= n; i++){
            if(!String.valueOf(i).contains("2") && !String.valueOf(i).contains("3") &&
                    !String.valueOf(i).contains("4") && !String.valueOf(i).contains("5") && !String.valueOf(i).contains("7")){

                String s = String.valueOf(i);
                k++;

                int count1 = 0, count8 = 0;

                if(!s.contains("6") && !s.contains("9")) {
                    for (int j = 0; j < s.length(); j++) {
                        if (s.charAt(j) == '8') {
                            count8++;
                        } else if (s.charAt(j) == '1') {
                            count1++;
                        } else {
                            break;
                        }
                    }
                    if(count1==s.length() || count8==s.length()){
                        k--;
                    }
                }
            }
        }

        System.out.println(k);
    }
}
