package com.nightfury.springbootrestapi.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 950733986999279151L;
    private Long empId;
    private String empName;
    private String empDept;
    private Long empSalary;
}
