package com.jlegaspy.wcbcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jlegaspy.wcbcs.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}