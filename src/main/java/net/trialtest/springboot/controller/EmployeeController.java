package net.trialtest.springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.trialtest.springboot.bean.EmpBean;
import net.trialtest.springboot.entity.EmployeeTax;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import net.trialtest.springboot.service.EmployeeService;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

//    @PostMapping("/ad_employee")
//    public EmployeeTax addEmp(@RequestBody EmpBean empBean){
//        return employeeService.saveEmp(empBean);
//    }


    @PostMapping("/save_emp")
    public List<EmployeeTax> addSavEmp(@RequestBody List<EmployeeTax> saveEmp) {
        return employeeService.saveEmployee(saveEmp);
    }


    @GetMapping("/all")
    public List<EmployeeTax> findallEmployee(){
        return employeeService.getEmployeeDetails();
    }

    @GetMapping("/{id}")
    public ResponseEntity<String> getEmpTaxDet(@PathVariable int id) throws JsonProcessingException{
        try {
            String content = employeeService.getEmpTax(id);
            return ResponseEntity.ok().body(content);
        } catch (JsonProcessingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("E");
        }
    }

    @DeleteMapping("/delete")
    public String deletEmp(@PathVariable int id){
        return employeeService.delEmployee(id);
    }

    @PutMapping("/update_emp")
    public EmployeeTax updateEmp(@RequestBody EmployeeTax empTax) {
        return employeeService.updateEmpTax(empTax);
    }

}
