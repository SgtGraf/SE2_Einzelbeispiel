package com.example.seii;

import java.util.Arrays;

public class Sorter {

    static String sort(String mnr){

        char[] retArr = new char[mnr.length()];
        int length = mnr.length();
        int amtEven = 0;

        for (int i = 0; i <length; i++) {
            retArr[i] = mnr.charAt(i);
            if((mnr.charAt(i)%2)==0){
                amtEven++;
            }
        }
        Arrays.sort(retArr);

        char[]arrEven = new char[amtEven];
        int j = 0;

        int amtOdd = length-amtEven;
        char[]arrOdd = new char[amtOdd];
        int k = 0;

        for (int i = 0; i < length; i++) {
            if ((retArr[i] % 2) == 0) {
                arrEven[j] = retArr[i];
                j++;
            } else {
                arrOdd[k] = retArr[i];
                k++;
            }
        }

        for (int i = 0; i < retArr.length; i++) {

            if (j>0){
                retArr[i] = arrEven[amtEven-j];
                j--;
            }
            else {
                retArr[i] = arrOdd[amtOdd-k];
                k--;
            }
        }

        String ret = new String(retArr);

        return ret;
    }

}
