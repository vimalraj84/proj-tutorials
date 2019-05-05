package com.bilqu.java8.cons;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.bilqu.bo.emp.EmpId;
import com.bilqu.bo.emp.EmpName;
import com.bilqu.bo.emp.EmpSex;
import com.bilqu.bo.emp.Employee;

public class MethodRefs {

    public static void main (String[] a){

        //Initial Testing

        Map<String,String> map = new HashMap<>();
        map.put("1","One");
        map.put("2","Two");
        System.out.println(map);
        map.computeIfAbsent("1" , k->"Three");
        System.out.println(map);
        map.computeIfAbsent("3" , k->"Three");
        System.out.println(map);
        map.computeIfAbsent("4" , v->new String("Four"));
        System.out.println(map);
        map.computeIfAbsent("5" , String::new);
        System.out.println(map);

        getEmpData();


    }

    public static Map<EmpId, Employee> getEmpData(){
        //Using Employee class
        Map<EmpId, Employee> empMap = new HashMap<>();

        EmpId empId = new EmpId(101,123456781l);
        EmpName empName = new EmpName("Caitlin","Summer");
        empMap.put(empId, new Employee(empId,empName,EmpSex.FEMALE));
        System.out.println("Printed with regular :"+ empMap);

        EmpId empId2 = new EmpId(102,12355678l);

        empMap.computeIfAbsent(empId2, id -> new Employee(id, new EmpName("Anna","Robert"), EmpSex.FEMALE));

        System.out.println("Printed with computeIfAbsent::Lamda :"+ empMap);

        empMap.computeIfAbsent(new EmpId(333,42345678l), id -> new Employee(empId2, new EmpName("Michelle","Gee"),EmpSex.FEMALE));
        System.out.println("Printed with computeIfAbsent::Lamda :"+ empMap);


        Supplier<EmpId> empIdSupplier = ()->{
            return new EmpId(104,62345678);
        };

        Supplier<EmpName> empNameSupplier = ()->{
            return new EmpName("Mia","Ashley");
        };

        empMap.computeIfAbsent(empIdSupplier.get(),id -> new Employee(id,empNameSupplier.get(),EmpSex.FEMALE));
        System.out.println("Printed with Supplier::Lamda :"+ empMap);
        return empMap;
    }


}
