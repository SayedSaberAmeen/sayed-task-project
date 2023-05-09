package com.testProject.demo.service;

import com.testProject.demo.common.entity.Department;
import com.testProject.demo.dto.requestDto.DepartmentRequestDto;
import com.testProject.demo.dto.responseDto.DepartmentResponseDto;
import com.testProject.demo.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class DepartmentServiceImp implements DepartmentService {
    private final ModelMapper mapperDep;
    private final DepartmentRepository RepositoryDepart;


    @Override
    public DepartmentResponseDto departSave(DepartmentRequestDto departmentRequestDto) {


        Department department = mapperDep.map(departmentRequestDto, Department.class);

        RepositoryDepart.save(department);

        return mapperDep.map(department, DepartmentResponseDto.class);

    }

    @Override
    public DepartmentResponseDto getDepartByID(int id) {

        Department department = RepositoryDepart.findById(id).get();

        return mapperDep.map(department, DepartmentResponseDto.class);

    }

    @Override
    public List<DepartmentResponseDto> getAllDepart() {

        List<Department> departments = RepositoryDepart.findAll();
        List<DepartmentResponseDto> dtos = departments
                .stream()
                .map(department -> mapperDep.map(department, DepartmentResponseDto.class))
                .collect(Collectors.toList());

        return dtos;
    }

    @Override
    public DepartmentResponseDto updateDepart(DepartmentRequestDto departmentRequestDto, int id) {

        Optional<Department> gitDepartment = RepositoryDepart.findById(id);

        if (gitDepartment.isEmpty()) {

            throw new RuntimeException("the department_Id " + id + "not found");
        } else {

            RepositoryDepart.save(gitDepartment.get());
        }


        return mapperDep.map(gitDepartment, DepartmentResponseDto.class);

    }
}
