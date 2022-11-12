package net.jonas.employee.service;

import net.jonas.employee.model.Employee;
import net.jonas.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> listEmployee(){
        return employeeRepository.findAll();
    }
    public Employee getEmployee(Long EmployeeID){
        return employeeRepository.findById(EmployeeID).orElseThrow(
                () -> new NoSuchElementException()
        );
    }
    public void addEmployee(Employee employee){
        employeeRepository.saveAndFlush(employee);
    }
    public Employee updateEmployee(Employee employee,Long EmployeeID){
        Employee existingEmployee = employeeRepository.findById(EmployeeID).orElseThrow(
                () -> new NoSuchElementException()
        );
        if (employee.getFirstName()!=null){
            existingEmployee.setFirstName(employee.getFirstName());
        }
        if (employee.getLastName()!=null){
            existingEmployee.setLastName(employee.getLastName());
        }
        if (employee.getEmail()!=null){
            existingEmployee.setEmail(employee.getEmail());
        }
        if (employee.getBusinessUnit()!=null){
            existingEmployee.setBusinessUnit(employee.getBusinessUnit());
        }
        if (employee.getCity()!=null){
            existingEmployee.setCity(employee.getCity());
        }
        if (employee.getCountry()!=null){
            existingEmployee.setCountry(employee.getCountry());
        }
        existingEmployee.setDate_last_modified(LocalDateTime.now());
        existingEmployee.setModification_count(existingEmployee.getModification_count()+1);

        employeeRepository.saveAndFlush(existingEmployee);
        return existingEmployee;
    }
}
