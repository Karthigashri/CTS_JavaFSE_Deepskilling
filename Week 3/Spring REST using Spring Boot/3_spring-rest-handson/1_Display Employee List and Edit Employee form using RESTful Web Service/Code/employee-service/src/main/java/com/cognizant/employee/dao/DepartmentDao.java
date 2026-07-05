package com.cognizant.employee.dao;

import java.util.ArrayList;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.employee.model.Department;

@Repository
public class DepartmentDao {

    public static ArrayList<Department> DEPARTMENT_LIST;

    public DepartmentDao() {
        DEPARTMENT_LIST = new ArrayList<>();

        try(ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("employee.xml")){


        DEPARTMENT_LIST.add(context.getBean("dept1", Department.class));
        DEPARTMENT_LIST.add(context.getBean("dept2", Department.class));
        DEPARTMENT_LIST.add(context.getBean("dept3", Department.class));

    }
        }

    public ArrayList<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }

}