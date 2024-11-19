package github.kayquesanmartin.employee_management_system.repository;

import github.kayquesanmartin.employee_management_system.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
