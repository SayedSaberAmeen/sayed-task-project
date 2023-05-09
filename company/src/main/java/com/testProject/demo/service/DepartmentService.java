package com.testProject.demo.service;


import com.testProject.demo.dto.requestDto.DepartmentRequestDto;
import com.testProject.demo.dto.responseDto.DepartmentResponseDto;

import java.util.List;

public interface DepartmentService {
    public DepartmentResponseDto departSave(DepartmentRequestDto departmentRequestDto);
    public DepartmentResponseDto getDepartByID(int id);
    public List<DepartmentResponseDto> getAllDepart();
    public DepartmentResponseDto updateDepart(DepartmentRequestDto departmentRequestDto, int id);

}
