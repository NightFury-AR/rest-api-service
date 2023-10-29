package com.nightfury.springbootrestapi.controller;

import com.nightfury.springbootrestapi.dto.EmployeeDTO;
import com.nightfury.springbootrestapi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {

    @Autowired private EmployeeService service;

    @PostMapping
    public EmployeeDTO postEmployee(@RequestBody EmployeeDTO dto) {
        return service.createEmployee(dto);
    }

    @GetMapping("/{empId}")
    public EmployeeDTO getEmployeeById(@PathVariable("empId") Long empId) {
        return service.getEmployeeById(empId);
    }

    @GetMapping("/list")
    public List<EmployeeDTO> getEmployeeList() {
        return service.getEmployeeList();
    }

    @PutMapping("/{empId}")
    public EmployeeDTO updateEmployee(@PathVariable("empId") Long empId, @RequestBody EmployeeDTO toBeUpdated) {
        return service.updateEmployee(empId, toBeUpdated);
    }

    @DeleteMapping("/{empId}")
    public void deleteEmployee(@PathVariable("empId") Long empId) {
        service.deleteEmployee(empId);
    }

}
