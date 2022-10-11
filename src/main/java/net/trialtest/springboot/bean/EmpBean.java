package net.trialtest.springboot.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmpBean {

    private int adhaarcardnumber;
    private int empId;
    private String employeename;
    private String emailid;
}
