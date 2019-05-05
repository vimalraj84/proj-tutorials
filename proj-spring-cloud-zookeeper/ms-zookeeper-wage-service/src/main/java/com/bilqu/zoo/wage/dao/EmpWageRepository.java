package com.bilqu.zoo.wage.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bilqu.zoo.wage.bo.EmpWage;

public interface EmpWageRepository extends JpaRepository<EmpWage, Integer>{
	
	EmpWage findByRoll(String roll);
	
}
