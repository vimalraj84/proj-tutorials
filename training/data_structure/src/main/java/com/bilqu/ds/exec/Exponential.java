package com.bilqu.ds.exec;

// Calculate p^k, where k is a non-negative integer? What is the complexity of the solution
public class Exponential {

    public static void main(String[] args) {

        System.out.println(String.format("10^10 = %d",pow(10,10)));
        System.out.println(String.format("2^5 = %d",pow(2,5)));
    }

    //Trivial solution has the complexity of O(k) but This solution results in a complexity of O(log k)

//    FUNCTION pow(base, exponent)
//    IF exponent == 0
//    RETURN 1
//    ELSE IF exponent is even
//    RETURN pow(base * base, exponent / 2)  -- p^k = (p^2)^(k/2), will reduce the number of required multiplications almost in half.
//    ELSE
//    RETURN base * pow(base * base, (exponent - 1) / 2) -- For an odd value of k, choosing x = 1 and y=k-1 will result in y being even
//    END IF

     public static int pow(int base,int exponent){
        if(exponent == 0 )
            return 1;
        else if(exponent%2 == 0){
            return pow(base * base, exponent /2);
        }else{
            return pow(base * base, (exponent -1) /2);
        }
     }

}
