package com.bilqu.java8.test;

import javax.sound.midi.Soundbank;
import java.util.*;

public class HashEqualTest {


    public static void main (String... a){

        Employee emp1 = new Employee(12345);
        Employee emp2 = new Employee(12345);

        //TODO: To understand hash and equals we can use HashMap collections.

        Map<Employee,String> empMap = new HashMap<>();

        //TODO : Create two employee objects and print them to understand the details

        empMap.put(emp1,"Anna");
        empMap.put(emp2,"Lucy");
        empMap.entrySet().stream().forEach(System.out::println);

        //TODO: Question is even though employee object is same why its printed twice?
        //Also make sure it takes only one into the HashMap

        //Solution: Implements hashcode and equals.


        // Try this,
        System.out.println(System.identityHashCode(emp1));

        System.out.println(System.identityHashCode(emp1));

        System.out.println(emp1.hashCode());
        System.out.println(emp2.hashCode());

        System.out.println(emp1 == emp2);

        System.out.println(emp1.equals(emp2));



        List<Employee> empList = new ArrayList<>();
        empList.add(emp1);
        empList.add(emp2);
        empList.add(new Employee(72345));
        empList.add(new Employee(52345));
        empList.add(new Employee(2345));
        empList.stream().forEach(System.out::println);
        //TODO: Now see how the comparator works
        //TODO: Sort the list

        Collections.sort(empList, (o1,o2) -> o1.id == o2.id ? 0 : o1.id > o2.id ? 1 : -1);
        System.out.println("After Sorting, ");
        empList.stream().forEach(System.out::println);

    }


    public static class Employee{
        private int id;

        public Employee(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        //TIPS:
        //  If you are overriding equals method then you should override hashcode() also.
        //  If two objects are equal then they must have same hashcode.
        //  If two objects have same hashcode then they may or may not be equal.
        //  Always use same attributes to generate equals and hashcode as in our case we have used attr1.


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return id == employee.id;
        }

        @Override
        public int hashCode() {
            return Objects.hash(id);
        }

        @Override
        public String toString() {
            return "Employee{" +
                    "id=" + id +
                    '}';
        }
    }
}
