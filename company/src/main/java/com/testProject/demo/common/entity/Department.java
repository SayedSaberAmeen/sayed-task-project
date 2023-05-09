package com.testProject.demo.common.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "department")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Department {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id  ;
    private String departName ;
    private String description;

    @OneToMany(mappedBy="department",cascade = CascadeType.ALL)
    private Set<Employee> employees;




    public void addEmploy(Employee employee){
        if (employees == null){
            if(employee!=null) {
                employees = new HashSet<>();


                employees.add(employee);
                employee.setDepartment(this);

            }

        }



    }


}
