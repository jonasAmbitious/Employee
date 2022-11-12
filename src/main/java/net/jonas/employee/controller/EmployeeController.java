package net.jonas.employee.controller;

import net.jonas.employee.model.Employee;
import net.jonas.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.sql.Timestamp;
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/viewemployeelist")
    public List<Employee> getEmployee(){return employeeService.listEmployee();}
    //localhost:9011/employee/viewemployeelist

    @GetMapping("/{employeeID}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long employeeID){
        try {
            Employee employee = employeeService.getEmployee(employeeID);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //localhost:9011/employee/{employeeID}

    @PostMapping("/addEmployee")
    public ResponseEntity<Employee> addEmployee(@RequestBody  Employee employee){
        try {
            employee.setDateAdded(LocalDateTime.now());
            employeeService.addEmployee(employee);
            return new ResponseEntity<>(employeeService.getEmployee(employee.getEmployeeId()), HttpStatus.CREATED);
        }catch (NoSuchElementException e){
            return  new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }
    }
    //localhost:9011/employee/addEmployee

    @PutMapping("/{employeeID}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long employeeID, @RequestBody Employee employee){
        try {
            return new ResponseEntity<>(employeeService.updateEmployee(employee,employeeID),HttpStatus.OK);
        }catch (NoSuchElementException e){
            return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //localhost:9011/employee/{updateEmployee}
    }


