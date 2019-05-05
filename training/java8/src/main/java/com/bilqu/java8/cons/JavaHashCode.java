package com.bilqu.java8.cons;

import java.util.HashMap;
import java.util.Map;

public class JavaHashCode {

	public static void main(String[] args) {
		Emp emp = new Emp(1, "Emp1");
		System.out.format("\nOverridden hashCode : %d",emp.hashCode());
		System.out.format("\nOriginal hashCode : %d",System.identityHashCode(emp));
		
		
		
		
		Emp emp1 = new Emp(1, "EmpOne");
		System.out.format("\nOverridden hashCode : %d",emp1.hashCode());
		System.out.format("\nOriginal hashCode : %d",System.identityHashCode(emp1));
		
		
		
		// If you are overriding equals method then you should override hashcode() also. 
	    // If two objects are equal then they must have same hashcode. 
	    // If two objects have same hashcode then they may or may not be equal. 
	    // Always use same attributes to generate equals and hashcode. 
		
		System.out.println("\nCheck emp == empi -> "+emp.equals(emp1));
		
		
		

	    
		
		Map<Emp, String> map = new HashMap<>();
		
		// it uses key object hashcode() method to calculate hashcode and they by applying hashing on that hashcode 
		//it identifies bucket location for storing value object.  
		map.put(emp, "Employe 1");
		map.put(emp1,"Employe One");
		
		System.out.println(map);
		
		// While retrieving it uses key object equals method to find out correct key value pair and 
		//return value object associated with that key.  
		System.out.println("\n"+map.get(emp));
		System.out.println("\n"+map.get(emp1));
		
		
		
	}
	
	
	public static class Emp{
		private int id;
		private String name;
		
		public Emp(int id, String name) {
			super();
			this.id = id;
			this.name = name;
		}
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		@Override
		public int hashCode() {
			System.err.println("\nI am checking hashCode");
			return id;
		}
		@Override
		public boolean equals(Object obj) {
			System.err.println("\nI am checking equals");
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Emp other = (Emp) obj;
			
			if (id != other.id)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}
	}

}
