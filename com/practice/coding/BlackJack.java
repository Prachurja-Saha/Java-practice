package com.practice.coding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class BlackJack {

    static void printResult(String[] array) {
        String r = "";

        HashMap<String, Integer> cardValues = new HashMap<>();
        cardValues.put("two", 2);
        cardValues.put("three", 3);
        cardValues.put("four", 4);
        cardValues.put("five", 5);
        cardValues.put("six", 6);
        cardValues.put("seven", 7);
        cardValues.put("eight", 8);
        cardValues.put("nine", 9);
        cardValues.put("ten", 10);
        cardValues.put("jack", 11);
        cardValues.put("queen", 12);
        cardValues.put("king", 13);
        cardValues.put("ace", 14);

        int noOfAce = 0;
        int totalSum = 0;
        int highestCard = 0;
        int secondHighest = 0;

        for (String s : array) {

            if (cardValues.get(s) <= 10) {
                totalSum += cardValues.get(s);
            } else if (s.equals("ace")) {
                noOfAce++;
                totalSum = totalSum + 11;
            } else {
                totalSum = totalSum + 10;
            }

            if (cardValues.get(s) > secondHighest) {

                if(cardValues.get(s)> highestCard) {
                    secondHighest = highestCard;
                    highestCard = cardValues.get(s);
                } else {
                    secondHighest = cardValues.get(s);
                }

            }

        }

        if (totalSum > 21) {
            int k = 1;
            while (noOfAce != 0) {

                if ((totalSum - (10 * k)) <= 21) {
                    totalSum = totalSum - (10 * k);
                    highestCard = secondHighest;
                    break;
                } else {
                    k++;
                }
                noOfAce--;
            }

        }

        if (totalSum > 21) {
            r = "above";
        } else if (totalSum < 21) {
            r = "below";
        } else {
            r = "balckjack";
        }

        System.out.println(r);
        System.out.println(highestCard);
    }

    public static void main(String[] args) {

        String[] strArr = {"three", "ace", "eight"}; // still some test case will fail

        List<String> stringList = new ArrayList<>();
        stringList.addAll(List.of(strArr)); //List.of method takes array parameter and return implemented obj of list

        stringList.sort(((o1, o2) -> o2.compareTo(o1)));

        printResult(strArr);
    }
}
