package com.algorithm.basicmath;

public class PrimeNoCheck {

    public static void main(String[] args) {
        int number = 29; // Change this to any number you want to check
        boolean isPrime = isPrime(number);

        if (isPrime) {
            System.out.println(number + " is a prime number.");
        } else {
            System.out.println(number + " is not a prime number.");
        }


        String s = String.valueOf(344);
        for (int i = 0; i < s.length() / 2; i++) {


            if (s.charAt(i) != s.charAt(s.length() - i - 1)) {
                System.out.println("a");
            }

        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false; // 0 and 1 are not prime numbers
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false; // num is divisible by i, hence not prime
            }
        }
        return true; // num is prime
    }

}
