package com.project.EmployeeManagementSystem.dto;

public class EmployeeResponseDTO {

    private Long employeeId;
    private String name;
    private String department;
    private double salary;

    public EmployeeResponseDTO() {
    }

    public EmployeeResponseDTO(
            Long employeeId,
            String name,
            String department,
            double salary) {

        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
