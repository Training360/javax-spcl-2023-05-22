package mentoring.repository;

import lombok.AllArgsConstructor;
import mentoring.employee.Employee;
import mentoring.employee.EmployeeDao;

@AllArgsConstructor
public class JpaEmployeeDao implements EmployeeDao {

    private PersistenceContextHandler handler;

    @Override
    public void save(Employee employee) {
        handler.doInTransaction(entityManager -> entityManager.persist(employee));
    }

    @Override
    public Employee findById(long id) {
        return handler.query(entityManager ->
                entityManager.createNamedQuery("findById", Employee.class).setParameter("id", id).getSingleResult());
    }
}
