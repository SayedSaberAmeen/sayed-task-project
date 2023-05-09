package com.testProject.demo.service;

import com.testProject.demo.common.entity.Department;
import com.testProject.demo.common.entity.Employee;
import com.testProject.demo.dto.requestDto.EmployeeRequestDto;
import com.testProject.demo.dto.responseDto.DepartmentResponseDto;
import com.testProject.demo.dto.responseDto.EmployeeResponseDto;
import com.testProject.demo.repository.DepartmentRepository;
import com.testProject.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.testProject.demo.common.util.UtilMessage.endMessage;
import static com.testProject.demo.common.util.UtilMessage.startMessage;
import static com.testProject.demo.common.util.utilTime.end;
import static com.testProject.demo.common.util.utilTime.start;


@Service
@RequiredArgsConstructor
@Slf4j
public class EmployeeServiceEmp implements EmployeeService {

    private final ModelMapper mapperEmp;
    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;


    @Override
    public EmployeeResponseDto addEmployee(EmployeeRequestDto employeeRequestDto, int depart_id) {

        Long start1 = start;

        String methodName = "addEmployee";

        log.info(startMessage, methodName);

        Employee employee = mapperEmp.map(employeeRequestDto, Employee.class);

        Department department = departmentRepository.findById(depart_id).get();

        DepartmentResponseDto departmentResponseDto = mapperEmp.map(department, DepartmentResponseDto.class);

        employee.setDepartment(department);

        employeeRepository.save(employee);

        EmployeeResponseDto employeeResponseDto = mapperEmp.map(employee, EmployeeResponseDto.class);

        Long end1 = end;

        log.info(endMessage, methodName, end - start);

        return new EmployeeResponseDto(employeeResponseDto, departmentResponseDto);


    }

    @Override
    public EmployeeResponseDto getEmpByID(int id) {

        Employee employee = employeeRepository.findById(id).get();

        return mapperEmp.map(employee, EmployeeResponseDto.class);

    }

    @Override
    public List<EmployeeResponseDto> getAllEmp() {

        List<Employee> employees = employeeRepository.findAll();

        List<EmployeeResponseDto> dtos = employees
                .stream()
                .map(employee -> mapperEmp.map(employee, EmployeeResponseDto.class))
                .collect(Collectors.toList());

        return dtos;

    }

    @Override
    public EmployeeResponseDto updateEmp(EmployeeRequestDto employeeRequestDto, int id) {

        Optional<Employee> gitEmployee = employeeRepository.findById(id);

        if (gitEmployee.isEmpty()) {

            throw new RuntimeException("the employee_Id " + id + "not found");

        } else {

            employeeRepository.save(gitEmployee.get());
        }

        return mapperEmp.map(gitEmployee, EmployeeResponseDto.class);

    }
}
