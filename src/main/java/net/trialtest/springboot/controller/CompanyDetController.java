package net.trialtest.springboot.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import net.trialtest.springboot.entity.CompanyDet;
import net.trialtest.springboot.exception.CustomException;
import net.trialtest.springboot.service.CompanyDetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/co_api")
public class CompanyDetController {

    @Autowired
    private CompanyDetService companyDetService;

    @PostMapping("/save_co_detail")
    public CompanyDet addCoDet(@RequestBody CompanyDet companyDetails){
        return companyDetService.saveDet(companyDetails);

    }

    @PostMapping("/add_co_details")
    public List<CompanyDet> addCoDetail(@RequestBody List<CompanyDet> saveCoDetails){
        return companyDetService.saveCompDet(saveCoDetails);

    }


    @GetMapping("/{id}")
    public ResponseEntity<String> getCoEmp(@PathVariable int id) throws NoSuchElementException{

        try {
            String coEmp = companyDetService.getCoTaxDet(id);
            return ResponseEntity.ok().body(coEmp);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("User Not found");
        }
    }


    @DeleteMapping("/delete")
    public String deletCoDetEmp(@PathVariable int id){
        return companyDetService.compDel(id);
    }


    @GetMapping("/alll")
    public ResponseEntity<String> getCoTaxAllserv() throws CustomException{
        try {
            String coTaxAllServ = companyDetService.getCoTaxAll();
            return ResponseEntity.ok().body(coTaxAllServ);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}










//    @PutMapping("/update_emp")
//    public CompanyDet updateCoDet(@RequestBody CompanyDet companydetail) {
//        return companyDetService.updateCompdet(companydetail);
//    }