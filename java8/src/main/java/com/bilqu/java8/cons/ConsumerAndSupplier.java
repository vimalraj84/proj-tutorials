package com.bilqu.java8.cons;

import com.bilqu.bo.emp.EmpId;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumerAndSupplier {
    public static double squareLazy(Supplier<Double> lazyValue) {
        return Math.pow(lazyValue.get(), 2);
    }
    public static void main(String[] a){

        Supplier<Double> lazyValue = () -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 9d;
        };

        Double valueSquared = squareLazy(lazyValue);


        Supplier<EmpId> empIdSupplier = () -> {
            return new EmpId(1234,123456789);
        };

        System.out.println(empIdSupplier); //This prints the lambda factory object

        System.out.println(empIdSupplier.get());

        List<EmpId> empIds = new ArrayList();
        empIds.add(empIdSupplier.get());
        empIds.add(empIdSupplier.get());
        empIds.add(new EmpId(34566,33242341));

        Consumer<EmpId> empIdConsumer = (empId) -> System.out.println(empId);
        empIds.stream().forEach(empIdConsumer);
    }
}
