package com.aad888.util;

public class NumberUtil {
    public static boolean isJiShu(Integer num){
        if(num != null){
            if(num % 2 ==0){
                return false;
            }else{
                return true;
            }
        }
        return false;
    }

    public static int cut4(String num){
        String last4 = num.substring(num.length() - 4  );

        char [] chars = last4.toCharArray();

        int sum = 0;

        if(chars != null && chars.length == 4){
            for(char c : chars){
                sum+=Integer.valueOf(c+"");
            }
        }else{
            System.out.println("获取期数异常!!!");
        }
        System.out.println("当前和值:"+sum);
        return sum;
    }
}
