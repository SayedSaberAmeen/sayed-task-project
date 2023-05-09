package com.testProject.demo.service;


import com.testProject.demo.dto.requestDto.EmployeeRequestDto;
import com.testProject.demo.dto.responseDto.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {

 public EmployeeResponseDto addEmployee(EmployeeRequestDto employeeRequestDto, int id);
 public EmployeeResponseDto getEmpByID(int id);
 public List<EmployeeResponseDto> getAllEmp();
 public EmployeeResponseDto updateEmp(EmployeeRequestDto employeeRequestDto,int id);

}