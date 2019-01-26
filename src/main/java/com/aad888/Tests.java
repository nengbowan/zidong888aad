package com.aad888;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Tests {
    public static void main(String[] args) {


        int sumA = 0;
        long start = System.currentTimeMillis();

        List<Integer> ids = new ArrayList<>();
        for(int i = 0 ; i<9999999;i++){
            ids.add(i);
        }
        for(int ii = 0 ; ii < ids.size(); ii++){
            sumA = ii;
        }
        long end = System.currentTimeMillis();


        System.out.println(end - start);

        System.out.println(sumA);

        long start1 = System.currentTimeMillis();
//        int sum = ids.parallelStream().mapToInt(x-> 1).reduce( 0 , (a,b)-> a + b);
        int aa = IntStream.range(0,9999999).max().orElse(-1);
        long end1 = System.currentTimeMillis();

        System.out.println(end1 - start1);

        System.out.println(aa);


//        int aaa = IntStream.range(0,9999999).bo
    }
}
