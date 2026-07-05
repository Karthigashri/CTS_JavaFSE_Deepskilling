package com.cognizant.employee.dao;

import java.util.ArrayList;

import org.springframework.stereotype.Repository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cognizant.employee.model.Employee;

@Repository
public class EmployeeDao {

    public static ArrayList<Employee> EMPLOYEE_LIST;

    public EmployeeDao() {

        EMPLOYEE_LIST = new ArrayList<>();

        try (ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("employee.xml")) {

            EMPLOYEE_LIST.add(context.getBean("emp1", Employee.class));
            EMPLOYEE_LIST.add(context.getBean("emp2", Employee.class));
            EMPLOYEE_LIST.add(context.getBean("emp3", Employee.class));
            EMPLOYEE_LIST.add(context.getBean("emp4", Employee.class));
        }
    }

    public ArrayList<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}