package com.zaitsava.spring.rest.controller;

import com.zaitsava.spring.rest.entity.Employee;
import com.zaitsava.spring.rest.exception_handling.EmployeeIncorrectData;
import com.zaitsava.spring.rest.exception_handling.NoSuchEmployeeException;
import com.zaitsava.spring.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class MyRESTController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public List<Employee> showAllEmployees(){
        List <Employee> allEmployees=employeeService.getAllEmployees();
        return allEmployees;
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee=employeeService.getEmployee(id);

        if(employee==null){
            throw new NoSuchEmployeeException("There os no employee with" +
                    "ID = "+id+ " in Database");
        }

        return employee;
    }


}
