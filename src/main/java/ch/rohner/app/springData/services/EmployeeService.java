package ch.rohner.app.springData.services;

import ch.rohner.app.springData.models.Employee;
import ch.rohner.app.springData.repos.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private EmployeeRepo employeeRepo;

    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }


    public Iterable<Employee> getEmployees() {
        final Iterable<Employee> employees = this.employeeRepo.findAll();
        return employees;

    }

    public Employee findEmployeeById(int employeeId) {
        final Optional<Employee> employee = this.employeeRepo.findById(employeeId);
        return employee.orElse(new Employee());
    }

    public List<Employee> findByRole(String employeeRole) {
        final List<Employee> employees = this.employeeRepo.findByRole(employeeRole);
        return employees;
    }

    public List<Employee> findAllByLastName(String lastName) {
        final List<Employee> employees = this.employeeRepo.findAllByLastName(lastName);
        return employees;
    }


    public Employee findEmployeeByFirstName(String firstName) {
        final Optional<Employee> employee = this.employeeRepo.findOneByFirstName(firstName);
        return employee.orElse(new Employee());
    }

    public List<Employee> getDevsFromComputers() {
        final List<Employee> devsFromComputers = this.employeeRepo.getDevsFromComputers();
        return devsFromComputers;
    }

    public List<Employee> getAdminFromDepartment(String department) {
        final List<Employee> adminFromDepartment = this.employeeRepo.getAdminFromDepartment(department.toUpperCase());
        return adminFromDepartment;
    }

    public List<Employee> getMediumSalaryFromRole(String employeeRole) {
        final List<Employee> mediumSalaryFromRole = this.employeeRepo.getMediumSalaryFromRole(employeeRole.toUpperCase());
        return mediumSalaryFromRole;
    }

    public List<Employee> getEmployeesByRoleAndMinSalary(String role, float minSalary) {
        final List<Employee> employeesByRoleAndMinSalary = this.employeeRepo.getEmployeesByRoleAndMinSalary(role.toUpperCase(), minSalary);
        return employeesByRoleAndMinSalary;
    }
}
