package net.trialtest.springboot.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import javax.persistence.*;
import java.util.List;



@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "companyDetails")
public class CompanyDet {

    @OneToMany
    @JoinColumn(name = "emp_id")
    private List<EmployeeTax> employeeTaxes;

    @Id
    @GeneratedValue
    @Column(name = "emp_id")
    private int empId;

    @Column(name = "coRegNo")
    private int companyRegistrationNumber;

    @Column(name = "coName")
    private String companyName;

    @Column(name = "coFax")
    private String emailandFax;

}





































//    @OneToMany(mappedBy = "",cascade = {CascadeType.ALL})
//    @JsonManagedReference
//    Set<EmployeeTax> employeeTaxes = new HashSet<>();


//    @OneToMany(mappedBy = "company", cascade = {CascadeType.ALL})
//    @JsonManagedReference
//    List<Employee> employees;


//    @OneToMany(mappedBy = "emp_id", cascade = {CascadeType.ALL})
//    @JsonManagedReference
//    List<EmployeeTax> employees = new ArrayList<>();

//    @OneToMany(mappedBy = "",cascade = {CascadeType.ALL})
//    @JsonManagedReference
//    Set<EmployeeTax> employeeTaxes = new HashSet<>();