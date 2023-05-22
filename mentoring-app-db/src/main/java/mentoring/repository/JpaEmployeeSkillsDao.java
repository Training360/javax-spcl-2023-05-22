package mentoring.repository;

import lombok.AllArgsConstructor;
import mentoring.employeeskills.EmployeeSkills;
import mentoring.employeeskills.EmployeeSkillsDao;

@AllArgsConstructor
public class JpaEmployeeSkillsDao implements EmployeeSkillsDao {

    private PersistenceContextHandler handler;

    @Override
    public void save(EmployeeSkills employeeSkills) {
        handler.doInTransaction(entityManager -> entityManager.persist(employeeSkills));
    }

    @Override
    public EmployeeSkills findByEmployeeId(long employeeId) {
        return handler.query(entityManager ->
                entityManager.createNamedQuery("findByEmployeeId", EmployeeSkills.class).setParameter("employeeId", employeeId).getSingleResult());
    }

    @Override
    public void update(EmployeeSkills employeeSkills) {
        handler.doInTransaction(entityManager -> entityManager.merge(employeeSkills));
    }
}
