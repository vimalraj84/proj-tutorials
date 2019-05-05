package com.bilqu.java8.cons;

import java.util.Map;
import java.util.stream.IntStream;

import com.bilqu.bo.emp.EmpId;
import com.bilqu.bo.emp.Employee;
import com.bilqu.bo.utils.StubGenerator;

public class StreamReduction {

    public static void main (String[] a){
    	
    	
    	System.out.println(IntStream.rangeClosed(1, 20).reduce(1,(op,ip) -> op+ip));
		
		System.out.println(IntStream.rangeClosed(1, 20).reduce(0,(op,ip) -> op+ip));
		
		System.out.println(IntStream.rangeClosed(1, 20).sum());
    	
        Map<EmpId, Employee> input = StubGenerator.getEmpData();
        
        Employee emp = input.entrySet().stream()
                .map(entry -> entry.getValue())
                .reduce((emp1,emp2) -> emp1.getPay().getPayRate() * emp1.getPay().getPayFreq() > emp2.getPay().getPayRate() * emp2.getPay().getPayFreq() ? emp1 :emp2)
                .get();
        
        System.out.printf("\nHighly paid Employee: %s \n\t pay rate: %d \n\t pay frequency: %d \n\t Gross Pay: %d%n",emp.getName().toString(),emp.getPay().getPayRate(),emp.getPay().getPayFreq(),emp.getPay().getPayRate()*emp.getPay().getPayFreq());
        
        
        Employee empO = input.entrySet().stream()
                .map(entry -> entry.getValue())
                .reduce((emp1,emp2) -> emp1.getPay().getPayRate() * emp1.getPay().getPayFreq() > emp2.getPay().getPayRate() * emp2.getPay().getPayFreq() ? emp1 :emp2)
                .get();
        
        System.out.printf("Highly paid Employee: %s \n\t pay rate: %d \n\t pay frequency: %d \n\t Gross Pay: %d %n",empO.getName().toString(),empO.getPay().getPayRate(),empO.getPay().getPayFreq(),empO.getPay().getPayRate()*empO.getPay().getPayFreq());
    }
}
