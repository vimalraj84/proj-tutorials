package com.bilqu.java8.cons;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.bilqu.bo.emp.EmpId;
import com.bilqu.bo.emp.EmpName;
import com.bilqu.bo.emp.Employee;
import com.bilqu.bo.utils.StubGenerator;

public class StreamsTest {

    public static void main(String[] a){

        Map<EmpId, Employee> input = StubGenerator.getEmpData();

        List<EmpName> empLNameList =  input.entrySet().stream()
                .map(entry -> entry.getValue().getName())
                .distinct()
                .sorted((empNm1,empNm2) -> empNm1.getlName().compareTo(empNm2.getlName()))
                .collect(Collectors.toList());
        System.out.println("Employees Sorted by Last Name :\n " + empLNameList);


        List<EmpName> empFNameList = input.entrySet().stream()
                .map(entry -> entry.getValue().getName())
                .distinct()
                .sorted(Comparator.comparing(EmpName::getfName))
                .collect(Collectors.toList());
        System.out.println("Employees Sorted by First Name :\n " + empFNameList);

        List<EmpId> empIds = input.entrySet().stream()
                .map(entry -> entry.getKey())
                .sorted(Comparator.comparing(EmpId::getId))
                .collect(Collectors.toList());
        System.out.println("Employees Sorted by Id :\n " + empIds);


        List<Integer> empNos = input.entrySet().stream()
                .map(entry -> entry.getKey().getId())
                .sorted((empId1,empId2) -> empId1.compareTo(empId2))
                .collect(Collectors.toList());
        System.out.println("Employees Sorted by Id :\n " + empNos);


        List<Long> empSsn = input.entrySet().stream()
                .map(entry -> entry.getKey().getSsn())
                .sorted((empS1,empS2) -> empS1.compareTo(empS2))
                .collect(Collectors.toList());
        System.out.println("Employees Sorted by SSN :\n " + empSsn);
        
        //initializing a Array
        
        Integer[] intArr = Stream.generate(() -> 1).limit(10).toArray(Integer[]::new);
        
        Arrays.stream(intArr).forEachOrdered(i -> System.out.println(i));
    }

}
