package net.trialtest.springboot.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "employeetax")
public class EmployeeTax {

    @ManyToOne
    @JoinColumn(name = "emp_id",nullable = false,insertable = false,updatable = false)
    @JsonBackReference
    private CompanyDet companyDet;

    @Id
    @GeneratedValue
    @Column(name = "adhaar_card_number")
    private int adhaarcardnumber;

    @Column(name = "emp_id")
    private int empId;

    @Column(name = "employee_name")
    private String employeename;

    @Column(name = "email_id")
    private String emailid;

}

//    @JoinColumn(name="company_id", nullable=false,insertable = false ,updatable = false)
//    @JsonBackReference
//    @ManyToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name="company_id", nullable=false,insertable = false ,updatable = false)
//    @JsonBackReference
//    Company company;

