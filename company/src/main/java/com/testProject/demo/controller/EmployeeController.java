package com.testProject.demo.controller;

import com.testProject.demo.dto.requestDto.EmployeeRequestDto;
import com.testProject.demo.dto.responseDto.EmployeeResponseDto;
import com.testProject.demo.service.EmployeeServiceEmp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeServiceEmp employeeServiceEmp;


    @PostMapping("/saveEmp/{depart_id}")
    public EmployeeResponseDto addEmployee(@RequestBody EmployeeRequestDto employeeRequestDto,
                                           @PathVariable(name = "depart_id") int depart_id) {
        return employeeServiceEmp.addEmployee(employeeRequestDto, depart_id);
    }


    @GetMapping("/getEmp/{id}")
    public EmployeeResponseDto getEmpByID(@PathVariable(value = "id") int id) {
        return employeeServiceEmp.getEmpByID(id);
    }

    @GetMapping("/getEmpAll")
    public List<EmployeeResponseDto> getAllEmp() {
        return employeeServiceEmp.getAllEmp();
    }

    @PostMapping("/updateEmp/{id}")
    public EmployeeResponseDto updateEmp(@RequestBody EmployeeRequestDto employeeRequestDto,
                                         @PathVariable(name = "id") int id) {
        return employeeServiceEmp.updateEmp(employeeRequestDto, id);
    }
}
