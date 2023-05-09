package com.testProject.demo.dto.requestDto;

import com.testProject.demo.common.entity.Employee;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Data
@NoArgsConstructor
public class DepartmentRequestDto {



    private String departName ;
    private String description;

    private Set<Employee> employeesDto;







}
