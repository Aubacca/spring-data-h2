package ch.rohner.app.springData;

import ch.rohner.app.springData.models.Employee;
import ch.rohner.app.springData.services.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class EmployeeHandler {
    @Autowired
    private EmployeeService employeeService;

    public void doAll() {
        showAllEmployees();
        showEmployeesByRole("DEV");
        showEmployeesByRole("GURU");
        showOneEmployee(0);
        showOneEmployee(33);
        showOneEmployee(67);
        showOneEmployee(99999);
        showAllEmployeesByLastName("Ridpath");
        showAllEmployeesByLastName("Everybody");
        showEmployeeByFirstName("Pegeen");
        showEmployeeByFirstName("Noon");
        showDevelopersFromComputers();
        getAdminFromDepartment("Books");
        getAdminFromDepartment("Shoes");
        getAdminFromDepartment("Tools");
        getMediumSalaryFromRole("Read");
        getMediumSalaryFromRole("write");
        getMediumSalaryFromRole("NoNe");
        getEmployeesByRoleAndMinSalary("admin", 75000.01f);
        getEmployeesByRoleAndMinSalary("read", 98800.01f);
        getEmployeesByRoleAndMinSalary("nobody", .01f);
        getEmployeesByRoleAndMinSalary("", -1);
    }

    private void showAllEmployees() {
        final Iterable<Employee> employees = this.employeeService.getEmployees();
        employees.forEach(employee -> {
            log.info("showAllEmployees>" + employee.toString());
        });
    }

    private void showOneEmployee(int employeeId) {
        log.info("showOneEmployee>employeeId=" + employeeId);
        final Employee employee = this.employeeService.findEmployeeById(employeeId);
        log.info("showOneEmployee>" + employee.toString());
    }

    private void showEmployeesByRole(String employeeRole) {
        log.info("showEmployeesByRole>employeeRole=" + employeeRole);
        final List<Employee> employees = this.employeeService.findByRole(employeeRole);
        employees.forEach(employee -> {
            log.info("showEmployeesByRole>" + employee.toString());
        });
        for (Employee employee : employees) {
            log.info("showEmployeesByRole>" + employee.toString());
        }
    }

    private void showAllEmployeesByLastName(String lastName) {
        log.info("showAllEmployeesByLastName>lastName=" + lastName);
        final List<Employee> employees = this.employeeService.findAllByLastName(lastName);
        employees.forEach(employee -> {
            log.info("showAllEmployeesByLastName>" + employee.toString());
        });
    }

    private void showEmployeeByFirstName(String firstName) {
        log.info("showEmployeeByFirstName>firstName=" + firstName);
        final Employee employee = this.employeeService.findEmployeeByFirstName(firstName);
        log.info("showEmployeeByFirstName>" + employee.toString());
    }

    private void showDevelopersFromComputers() {
        log.info("showDevelopersFromComputers>");
        final List<Employee> employees = this.employeeService.getDevsFromComputers();
        employees.forEach(employee -> {
            log.info("showDevelopersFromComputers>" + employee.toString());
        });
    }

    private void getAdminFromDepartment(String department) {
        log.info("getAdminFromDepartment>department=" + department);
        final List<Employee> employees = this.employeeService.getAdminFromDepartment(department);
        employees.forEach(employee -> {
            log.info("getAdminFromDepartment>" + employee.toString());
        });
    }

    public void getMediumSalaryFromRole(String userRole) {
        log.info("getMediumSalaryFromRole>userRole=" + userRole);
        final List<Employee> employees = this.employeeService.getMediumSalaryFromRole(userRole);
        employees.forEach(employee -> {
            log.info("getMediumSalaryFromRole>" + employee.toString());
        });
    }

    public void getEmployeesByRoleAndMinSalary(String role, float lowLevelSalary) {
        log.info("getEmployeesByRoleAndMinSalary>role=" + role + ", lowLevelSalary=" + lowLevelSalary);
        final List<Employee> employees = this.employeeService.getEmployeesByRoleAndMinSalary(role, lowLevelSalary);
        employees.forEach(employee -> {
            log.info("getEmployeesByRoleAndMinSalary>" + employee.toString());
        });    }
}
