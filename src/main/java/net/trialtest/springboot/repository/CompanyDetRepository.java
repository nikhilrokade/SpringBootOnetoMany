package net.trialtest.springboot.repository;

import net.trialtest.springboot.entity.CompanyDet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;



@Repository
public interface CompanyDetRepository extends JpaRepository<CompanyDet,Integer> {

}
