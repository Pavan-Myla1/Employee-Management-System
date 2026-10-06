package com.project.EmployeeManagementSystem.service;

import com.project.EmployeeManagementSystem.dto.EmployeeRequestDTO;
import com.project.EmployeeManagementSystem.dto.EmployeeResponseDTO;
import com.project.EmployeeManagementSystem.model.Employee;

import java.util.List;


public interface EmployeeService {

    EmployeeResponseDTO addEmployee(EmployeeRequestDTO employeeDTO);

    List<EmployeeResponseDTO> getAllEmployees();

    EmployeeResponseDTO getEmployeeById(Long id);

    EmployeeResponseDTO updateEmployee(
            Long id,
            EmployeeRequestDTO employeeDTO);

    boolean deleteEmployee(Long id);


}
