package com.bilqu.bo.utils;

import com.bilqu.bo.emp.EmpId;
import com.bilqu.bo.emp.EmpName;
import com.bilqu.bo.emp.EmpPay;
import com.bilqu.bo.emp.EmpSex;
import com.bilqu.bo.emp.Employee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class StubGenerator {
	
	
	public static List<Employee> getEmployeeList(){
		List<Employee> output = new ArrayList<Employee>();
		
		//Before Java 8
        EmpId empId = new EmpId(101,123456781l);
        EmpName empName = new EmpName("Caitlin","Summer");
        EmpPay empPay = new EmpPay();
        empPay.setPayFreq(25);
        empPay.setPayRate(2000);
        output.add(new Employee(empId,empName,empPay,EmpSex.FEMALE,34));
        
        EmpPay empPay1 = new EmpPay();
        empPay1.setPayFreq(50);
        empPay1.setPayRate(1500);

        EmpPay empPay2 = new EmpPay();
        empPay2.setPayFreq(25);
        empPay2.setPayRate(3000);
        
        EmpPay empPay3 = new EmpPay();
        empPay3.setPayFreq(12);
        empPay3.setPayRate(4000);
        
        EmpPay empPay4 = new EmpPay();
        empPay4.setPayFreq(12);
        empPay4.setPayRate(10000);
        
        EmpPay empPay5 = new EmpPay();
        empPay5.setPayFreq(12);
        empPay5.setPayRate(20000);

        //Using Lambda
        EmpId empId2 = new EmpId(102,12355678l);
        output.add(new Employee(empId2, new EmpName("Anna","Robert"),empPay1, EmpSex.FEMALE,31));

        output.add( new Employee(new EmpId(333,42345678l), new EmpName("Kate","Gee"),empPay3,EmpSex.FEMALE,34));

        //Supplier
        Supplier<EmpId> empIdSupplier = ()->{
            return new EmpId(104,62345678);
        };
        Supplier<EmpName> empNameSupplier = ()->{
            return new EmpName("Mia","Ashley");
        };
        output.add(new Employee(empIdSupplier.get(),empNameSupplier.get(),empPay2,EmpSex.FEMALE,41));


        output.add(new Employee(new EmpId(205,32346676l),new EmpName("Grace","Kelly"),empPay4,EmpSex.FEMALE,29));

        output.add(new Employee(new EmpId(111,72545678l),new EmpName("Aria","Gomez"),empPay5,EmpSex.FEMALE,29));

        output.add(new Employee(new EmpId(117,212345678l),new EmpName("Noelle","Gray"),empPay2,EmpSex.FEMALE,28));

        output.add(new Employee(new EmpId(818,406343608l),new EmpName("Alex","Gray"),empPay3,EmpSex.MALE,28));

        output.add(new Employee(new EmpId(555,812305878l),new EmpName("Rayn","Davis"),empPay3,EmpSex.MALE,26));

        output.add(new Employee(new EmpId(666,618895098l),new EmpName("Mark","Tucker"),empPay2,EmpSex.MALE,34));

        output.add(new Employee(new EmpId(666,617090998l),new EmpName("Gary","Rose"),empPay,EmpSex.OTHER,37));

        output.add(new Employee(new EmpId(666,708093008l),new EmpName("Trisha","Muller"),empPay1,EmpSex.FEMALE,34));

		return output;
		
	}

    public static Map<EmpId, Employee> getEmpData(){
        //Using Employee class
        Map<EmpId, Employee> empMap = new HashMap<>();

        //Before Java 8
        EmpId empId = new EmpId(101,123456781l);
        EmpName empName = new EmpName("Caitlin","Summer");
        EmpPay empPay = new EmpPay();
        empPay.setPayFreq(25);
        empPay.setPayRate(2000);
        empMap.put(empId, new Employee(empId,empName,empPay,EmpSex.FEMALE));
        
        EmpPay empPay1 = new EmpPay();
        empPay1.setPayFreq(50);
        empPay1.setPayRate(1500);

        EmpPay empPay2 = new EmpPay();
        empPay2.setPayFreq(25);
        empPay2.setPayRate(3000);
        
        EmpPay empPay3 = new EmpPay();
        empPay3.setPayFreq(12);
        empPay3.setPayRate(4000);
        
        EmpPay empPay4 = new EmpPay();
        empPay4.setPayFreq(12);
        empPay4.setPayRate(10000);
        
        EmpPay empPay5 = new EmpPay();
        empPay5.setPayFreq(12);
        empPay5.setPayRate(20000);

        //Using Lambda
        EmpId empId2 = new EmpId(102,12355678l);
        empMap.computeIfAbsent(empId2, id -> new Employee(id, new EmpName("Anna","Robert"),empPay1, EmpSex.FEMALE));

        empMap.computeIfAbsent(new EmpId(333,42345678l), id -> new Employee(empId2, new EmpName("Kate","Gee"),empPay3,EmpSex.FEMALE));

        //Supplier
        Supplier<EmpId> empIdSupplier = ()->{
            return new EmpId(104,62345678);
        };
        Supplier<EmpName> empNameSupplier = ()->{
            return new EmpName("Mia","Ashley");
        };
        empMap.computeIfAbsent(empIdSupplier.get(),id -> new Employee(id,empNameSupplier.get(),empPay2,EmpSex.FEMALE));


        empMap.computeIfAbsent(new EmpId(205,32346676l), id-> new Employee(id,new EmpName("Grace","Kelly"),empPay4,EmpSex.FEMALE));

        empMap.computeIfAbsent(new EmpId(111,72545678l), id-> new Employee(id,new EmpName("Aria","Gomez"),empPay5,EmpSex.FEMALE));

        empMap.computeIfAbsent(new EmpId(117,212345678l), id-> new Employee(id,new EmpName("Noelle","Gray"),empPay2,EmpSex.FEMALE));

        empMap.computeIfAbsent(new EmpId(818,406343608l), id-> new Employee(id,new EmpName("Alex","Gray"),empPay3,EmpSex.MALE));

        empMap.computeIfAbsent(new EmpId(555,812305878l), id-> new Employee(id,new EmpName("Rayn","Davis"),empPay3,EmpSex.MALE));

        empMap.computeIfAbsent(new EmpId(666,618895098l), id-> new Employee(id,new EmpName("Mark","Tucker"),empPay2,EmpSex.MALE));

        empMap.computeIfAbsent(new EmpId(666,617090998l), id-> new Employee(id,new EmpName("Gary","Rose"),empPay,EmpSex.OTHER));

        empMap.computeIfAbsent(new EmpId(666,708093008l), id-> new Employee(id,new EmpName("Trisha","Muller"),empPay1,EmpSex.FEMALE));

        System.out.println("Printed with regular :"+ empMap);
        return empMap;
    }

}
