package net.trialtest.springboot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.trialtest.springboot.bean.EmpBean;
import net.trialtest.springboot.entity.EmployeeTax;
import net.trialtest.springboot.repository.EmployeeRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;

    Logger log = LogManager.getLogger(EmployeeService.class);

//    public EmployeeTax saveEmp(EmpBean employeeTax){
//      return employeeRepository.save(employeeTax);
//    }

    public List<EmployeeTax> saveEmployee(List<EmployeeTax> saveEmp){
        return employeeRepository.saveAll(saveEmp);
    }

    public List<EmployeeTax> getEmployeeDetails(){
        log.info("Information logger");
        log.error("Error logger");
       return employeeRepository.findAll();
    }

    public String getEmpTax(int id) throws JsonProcessingException{
        Optional<EmployeeTax> byId = employeeRepository.findById(id);

        EmployeeTax employeeTax = byId.get();
        ObjectMapper ob = new ObjectMapper();
        String st = ob.writeValueAsString(employeeTax);
        log.debug("Debug logger");
        return st;

    }

    public String delEmployee(int id){
        employeeRepository.deleteById(id);
        return "Employee Removed"+id;
    }

    public EmployeeTax updateEmpTax(EmployeeTax empTax){
        EmployeeTax existingEmp = employeeRepository.findById(empTax.getEmpId()).orElse(null);
        existingEmp.setEmpId(empTax.getEmpId());
        existingEmp.setEmployeename(empTax.getEmployeename());
        existingEmp.setAdhaarcardnumber(empTax.getAdhaarcardnumber());
        existingEmp.setEmailid(empTax.getEmailid());
        return employeeRepository.save(existingEmp);
    }
}

