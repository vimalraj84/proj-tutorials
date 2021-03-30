package com.bilqu.java8.math;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MissingNumber {

    public static void main (String[] a){

        System.out.format("The missing number is %d",findMissingNumber(new int[]{9,6,3,2,8,10,1,4,7},10));

        System.out.println();
        int[] out =  findAllMissingNumbers(new int[]{9,6,3,2,8,10,1,4},10);
        Arrays.stream(out).forEach(System.out::println);
    }


    public static int findMissingNumber(int[] ip,int ipLen){

        int output = 0;
        //sum of natural number n(n+1)/2
        int nSum =  ipLen*(ipLen+1)/2;
        System.out.println("sum of natural number : "+nSum);

        //Compute input array sum
        int ipArraySum = 0;

        ipArraySum = Arrays.stream(ip).reduce(0, (sum,i)  -> sum+i);

//        for(int i =0 ; i<ip.length;i++){
//            ipArraySum += ip[i];
//        }
        output = nSum - ipArraySum;
        System.out.println(output);
        return output;
    }

    public static int[] findAllMissingNumbers(int[] ip,int ipLen){

        List<Integer> output =  Arrays.stream(ip).boxed().collect(Collectors.toList());



        if (output.stream() != null) {

        }

        int counter = 0;
        int itrCnt = ipLen - ip.length;


        while(counter < itrCnt){
            int out = findMissingNumber(output.stream().filter(Objects::nonNull).mapToInt(Integer::intValue).toArray(),output.size()+1);
            output.add(out);
            counter ++;
        }
        return output.stream().filter(Objects::nonNull).mapToInt(Integer::intValue).sorted().toArray();
    }
}
