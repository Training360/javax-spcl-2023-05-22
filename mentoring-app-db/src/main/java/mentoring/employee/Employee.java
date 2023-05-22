package mentoring.employee;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@NamedQuery(name = "findEmployeesWithRoles", query = "select distinct e from Employee e left join fetch e.roles")
@NamedQuery(name = "findById", query = "select distinct e from Employee e left join fetch e.roles where id = :id")
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "employee_roles")
    private Set<Long> roles;

    public Employee(String name, Set<Long> roles) {
        this.name = name;
        this.roles = roles;
    }

    public void addRoles(Set<Long> rolesToAdd) {
        roles.addAll(rolesToAdd);
    }

}
