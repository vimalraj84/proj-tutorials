package com.bilqu.java8.cons;

import com.bilqu.bo.emp.EmpId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerAndSupplier {

    public static void main(String[] a){

        Supplier<EmpId> empIdSupplier = () -> {
            return new EmpId(1234,123456789);
        };

        System.out.println(empIdSupplier); //This prints teh lambda factory object

        System.out.println(empIdSupplier.get());

        List<EmpId> empIds = new ArrayList();
        empIds.add(empIdSupplier.get());
        empIds.add(empIdSupplier.get());
        empIds.add(new EmpId(34566,33242341));

        Consumer<EmpId> empIdConsumer = (empId) -> System.out.println(empId);
        empIds.stream().forEach(empIdConsumer);
    }
}
