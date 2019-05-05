package com.bilqu.java8.cons;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.bilqu.bo.emp.EmpId;
import com.bilqu.bo.emp.EmpSex;
import com.bilqu.bo.emp.Employee;
import com.bilqu.bo.utils.StubGenerator;

public class Parallelize {

    public static void main (String[] a){
        Map<EmpId, Employee> input = StubGenerator.getEmpData();

        List<Employee> output = input.entrySet()
                .parallelStream()
                .map(emp -> emp.getValue())
                .distinct()
                .filter(emp -> emp.getSex().equals(EmpSex.FEMALE))
                .collect(Collectors.toList());

        System.out.println(output);


    }
}
