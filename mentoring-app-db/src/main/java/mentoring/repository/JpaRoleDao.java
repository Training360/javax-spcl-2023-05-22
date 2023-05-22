package mentoring.repository;

import lombok.AllArgsConstructor;
import mentoring.role.Role;
import mentoring.role.RoleDao;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class JpaRoleDao implements RoleDao {

    private PersistenceContextHandler handler;

    @Override
    public void create(Role role) {
        handler.doInTransaction(entityManager -> entityManager.persist(role));
    }

    @Override
    public List<Role> findByIds(Set<Long> ids) {
        return handler.query(entityManager -> entityManager.createNamedQuery("getByIds").setParameter("ids", ids).getResultList());
    }
}
