package ch.rohner.app.springData.repos;

import ch.rohner.app.springData.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Integer> {
//public interface EmployeeRepo extends CrudRepository<Employee, Integer> {
    public List<Employee> findByRole(String role);

    public List<Employee> findAllByLastName(String lastName);

    public Optional<Employee> findOneByFirstName(String firstName);

    public List<Employee> getDevsFromComputers();

    public List<Employee> getAdminFromDepartment(String department);

    @Query(value = "Select e from Employee e where upper(e.role) = upper(?1) and e.salary between 25000 and 35000")
    public List<Employee> getMediumSalaryFromRole(String role);

    @Query(
            value = "Select * from Employees e where upper(e.role) = upper(:roleName) and e.salary >= :salaryLevel",
            nativeQuery = true
    )
    public List<Employee> getEmployeesByRoleAndMinSalary(String roleName, float salaryLevel);
}

