package com.neosuniversity.data.jdbc.controller;

import com.neosuniversity.data.jdbc.domain.Chair;
import com.neosuniversity.data.jdbc.domain.Department;
import com.neosuniversity.data.jdbc.repositpory.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentRestController {

    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping("/department")
    public Department createNewDepartment(){

        Chair deanJones = new Chair("Dean Jones");
        departmentRepository.save(new Department("Humanities", deanJones));
        //departmentRepository.save(new Department("Humanities"));


        Department department= departmentRepository.findByName("Humanities").get();
       // System.out.println(department.toString());
        System.out.println(department.getChair().getName() +"-" + department.getChair().getDepartment());

        return department;
    }
}
