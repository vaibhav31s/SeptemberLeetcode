package com.company.DailyChallenge;

import java.util.Arrays;

public class UTF8Validation {
    public static void main(String[] args) {
        int[] data = {248,130,130,130};
        String[] arr = new String[data.length];
       int p = 0;
        for(int x : data){
            String s = Integer.toString(x, 2);
            String a = "";
            for(int i = 0; i < 8- s.length(); i++){
               a+='0';
            }
            a+=s;
            arr[p++] =a ;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(isValid(arr));
    }

    private static boolean isValid(String[] data) {
        int i = 0;
        outer:
        while(i <  data.length){
            if(data[i].charAt(0) == '0') {
                i+=1; continue outer;
            }
            if(data.length - i == 1) return false;

            String s = data[i].substring(0,3);
            if(s.equals("110")){
                if(i+1 >= data.length || !data[i+1].substring(0,2).equals("10")) return false;
                else {i+=2; continue outer;}
            }
            s = data[i].substring(0,4);
            if(s.equals("1110")){
                if(i+2>= data.length || !data[i+1].substring(0,2).equals("10") || !data[i+2].substring(0,2).equals("10")) return false;
                else  {i+=3; continue outer;}
            }
            s = data[i].substring(0,5);
             if(s.equals("11110")) {
                 if(i+3>= data.length || !data[i+1].substring(0,2).equals("10") || !data[i+2].substring(0,2).equals("10") || !data[i+3].substring(0,2).equals("10")) return false;
                 else  {i+=4; continue outer;}
             }


        }


        return true;
    }

}
//    Number of Bytes   |        UTF-8 Octet Sequence
//        |              (binary)
//        --------------------+-----------------------------------------
//        1          |   0xxxxxxx
//        2          |   110xxxxx 10xxxxxx
//        3          |   1110xxxx 10xxxxxx 10xxxxxx
//        4          |   11110xxx 10xxxxxx 10xxxxxx 10xxxxxx