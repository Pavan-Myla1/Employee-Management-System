package com.project.EmployeeManagementSystem.controller;

import com.project.EmployeeManagementSystem.dto.EmployeeRequestDTO;
import com.project.EmployeeManagementSystem.dto.EmployeeResponseDTO;
import com.project.EmployeeManagementSystem.model.Employee;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.project.EmployeeManagementSystem.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public EmployeeResponseDTO addEmployee(
            @Valid @RequestBody EmployeeRequestDTO employeeDTO) {
        return employeeService.addEmployee(employeeDTO);
    }

    @GetMapping
    public List<EmployeeResponseDTO> getAllEmployees() {

        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public EmployeeResponseDTO getEmployeeById(
            @PathVariable Long id) {

        return employeeService.getEmployeeById(id);
    }

    @PutMapping("/{id}")
    public EmployeeResponseDTO updateEmployee(
            @PathVariable Long id,
            @Valid @RequestBody EmployeeRequestDTO employeeDTO) {
        return employeeService.updateEmployee(id, employeeDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {

        boolean deleted = employeeService.deleteEmployee(id);

        if (deleted) {
            return "Employee deleted successfully";
        }

        return "Employee not found";
    }
}
