package net.trialtest.springboot.repository;

import net.trialtest.springboot.entity.EmployeeTax;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeTax,Integer> {

}
