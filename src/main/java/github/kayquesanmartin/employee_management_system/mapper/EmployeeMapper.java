package github.kayquesanmartin.employee_management_system.mapper;

import github.kayquesanmartin.employee_management_system.dto.EmployeeDto;
import github.kayquesanmartin.employee_management_system.entity.Employee;

public class EmployeeMapper {

    // Converte um objeto Employee (entidade) para EmployeeDto (transfer object)
    public static EmployeeDto mapToEmployeeDto(Employee employee) {
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    // Converte um objeto EmployeeDto (transfer object) para Employee (entidade)
    public static Employee mapToEmployee(EmployeeDto employeeDto) {
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
