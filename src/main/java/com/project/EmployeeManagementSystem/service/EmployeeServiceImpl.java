package com.project.EmployeeManagementSystem.service;

import com.project.EmployeeManagementSystem.dto.EmployeeRequestDTO;
import com.project.EmployeeManagementSystem.dto.EmployeeResponseDTO;
import com.project.EmployeeManagementSystem.exception.EmployeeNotFoundException;
import com.project.EmployeeManagementSystem.model.Employee;
import com.project.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public EmployeeResponseDTO addEmployee(
            EmployeeRequestDTO employeeDTO) {

        Employee employee = new Employee();

        employee.setName(employeeDTO.getName());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setSalary(employeeDTO.getSalary());

        Employee savedEmployee =
                employeeRepository.save(employee);

        return convertToResponseDTO(savedEmployee);
    }

    @Override
    public List<EmployeeResponseDTO> getAllEmployees() {

        return employeeRepository.findAll()
                .stream()
                .map(this::convertToResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponseDTO getEmployeeById(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        return convertToResponseDTO(employee);
    }

    @Override
    public EmployeeResponseDTO updateEmployee(
            Long id, EmployeeRequestDTO employeeDTO) {

        Employee existingEmployee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        existingEmployee.setName(employeeDTO.getName());
        existingEmployee.setDepartment(employeeDTO.getDepartment());
        existingEmployee.setSalary(employeeDTO.getSalary());

        Employee updatedEmployee = employeeRepository.save(existingEmployee);

        return convertToResponseDTO(updatedEmployee);
    }

    @Override
    public boolean deleteEmployee(Long id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(id));

        employeeRepository.delete(employee);

        return true;
    }

    private EmployeeResponseDTO convertToResponseDTO(
            Employee employee) {

        return new EmployeeResponseDTO(
                employee.getEmployeeId(),
                employee.getName(),
                employee.getDepartment(),
                employee.getSalary()
        );
    }
}