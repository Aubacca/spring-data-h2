package ch.rohner.app.springData.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@NamedQuery(
        name = "Employee.getDevsFromComputers",
        query = "Select e from Employee e where e.role = 'DEV' and e.department = 'Computers'")
@NamedNativeQuery(
        name = "Employee.getAdminFromDepartment",
        query = "Select * from employees e where upper(e.dept) = upper(:department) and e.role = 'ADMIN'",
        resultClass = Employee.class)
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int Id;
    private int version;
    @NonNull
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name", nullable = false)
    @NonNull
    private String lastName;
    @NonNull
    private String role;
    @NonNull
    @Column(name = "DEPT", nullable = false, length = 50)
    private String department;
    @NonNull
    @Column(name = "SALARY", precision = 2)
    private float salary;
    @NonNull
    @Column(name = "HIRE_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date hireDate;
}
