package net.trialtest.springboot.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import net.trialtest.springboot.entity.CompanyDet;
import net.trialtest.springboot.exception.CustomException;
import net.trialtest.springboot.repository.CompanyDetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CompanyDetService {

    @Autowired
    private CompanyDetRepository companyDetRepository;

    public CompanyDet saveDet(CompanyDet companyDet) {
    return companyDetRepository.save(companyDet);
    }

    public List<CompanyDet> saveCompDet(List<CompanyDet> companyDet){
        return companyDetRepository.saveAll(companyDet);

    }
    public String getCoTaxDet(int id) throws CustomException, JsonProcessingException {

            Optional<CompanyDet> optionalCompanyDet = companyDetRepository.findById(id);
            CompanyDet companyDetail = optionalCompanyDet.get();
            ObjectMapper objCo = new ObjectMapper();
            String getSt = objCo.writeValueAsString(companyDetail);
            return getSt;
    }


    public String compDel(int id){

        companyDetRepository.deleteById(id);
        return "Removed Successfully"+id;
    }

    public String getCoTaxAll() throws JsonProcessingException{

            List<CompanyDet> optionalAll = companyDetRepository.findAll();
            ObjectMapper objAll = new ObjectMapper();
            String getAll = objAll.writeValueAsString(optionalAll);
            return getAll;
    }


}








//    public CompanyDet updateCompdet(@NotNull CompanyDet coDetails){
//        CompanyDet existingCompdet = companyDetRepository.findById(coDetails.getCompanyRegistrationNumber()).orElse(null);
//        existingCompdet.setCompanyRegistrationNumber(coDetails.getCompanyRegistrationNumber());
//        existingCompdet.setCompanyName(coDetails.getCompanyName());
//        existingCompdet.setEmailandFax(coDetails.getEmailandFax());
//        existingCompdet.setEmpId(coDetails.getEmpId());
//        return companyDetRepository.save(existingCompdet);
//
//    }



//    public String saveCoDet() throws JsonProcessingException {
//        List<CompanyDet> companyDetOptional = companyDetRepository.save();
//        CompanyDet companyDeta = companyDetOptional.set();
//        ObjectMapper objSave = new ObjectMapper();
//        String getSave = objSave.writeValueAsString(companyDeta);
//        return getSave;
//
//    }
