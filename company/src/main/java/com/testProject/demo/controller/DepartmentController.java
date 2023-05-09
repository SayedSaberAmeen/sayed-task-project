package com.testProject.demo.controller;

import com.testProject.demo.dto.requestDto.DepartmentRequestDto;
import com.testProject.demo.dto.responseDto.DepartmentResponseDto;
import com.testProject.demo.service.DepartmentServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Department")
@RequiredArgsConstructor
public class DepartmentController {



    private final DepartmentServiceImp departmentServiceImpc ;

    @PostMapping("/departSave")
    public DepartmentResponseDto departSave(@RequestBody DepartmentRequestDto departmentRequestDto) {
        return  departmentServiceImpc.departSave(departmentRequestDto);
    }

    @GetMapping("getDepartBYID/{id}")
    public DepartmentResponseDto getDepartByID(@PathVariable(name = "id") int id) {
       return departmentServiceImpc.getDepartByID(id);
    }
    @GetMapping("/getDepartAll")
    public List<DepartmentResponseDto> getAllDepart() {
        return departmentServiceImpc.getAllDepart();
    }

    @PostMapping("/updateDepart/{id}")
    public DepartmentResponseDto updateDepart(@RequestBody DepartmentRequestDto departmentRequestDto,
                                              @PathVariable(name = "id") int id) {
        return departmentServiceImpc.updateDepart(departmentRequestDto,id);
    }







}
