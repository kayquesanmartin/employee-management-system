package github.kayquesanmartin.employee_management_system.service.impl;

import github.kayquesanmartin.employee_management_system.dto.EmployeeDto;
import github.kayquesanmartin.employee_management_system.entity.Employee;
import github.kayquesanmartin.employee_management_system.exception.ResourceNotFoundException;
import github.kayquesanmartin.employee_management_system.mapper.EmployeeMapper;
import github.kayquesanmartin.employee_management_system.repository.EmployeeRepository;
import github.kayquesanmartin.employee_management_system.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        // Converte o DTO para entidade
        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        // Salva no banco de dados (usando o repository)
        Employee savedEmployee = employeeRepository.save(employee);

        // Converte a entidade salva de volta para DTO
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id: " + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {

        List<Employee> employees = employeeRepository.findAll();

        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id: " + employeeId));

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id: " + employeeId));

        employeeRepository.deleteById(employeeId);
    }

}
