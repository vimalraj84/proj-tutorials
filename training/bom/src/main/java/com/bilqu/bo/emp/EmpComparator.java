package com.bilqu.bo.emp;

import java.util.Comparator;

public class EmpComparator implements Comparator<Employee>{

	
	//Sort based on Employee Age then First name and then with last name 
	
	@Override
	public int compare(Employee e1, Employee e2) {
		int ageComp = e1.getAge() > e2.getAge() ? 1 : e1.getAge() < e2.getAge() ? -1 : 0;
		if(ageComp == 0) {
			int fnComp = e1.getName().getfName().compareToIgnoreCase(e2.getName().getfName());
			if(fnComp == 0)
				return e1.getName().getlName().compareToIgnoreCase(e2.getName().getlName());
			else 
				return fnComp;
		}else {
			return ageComp;
		}
	}
}
