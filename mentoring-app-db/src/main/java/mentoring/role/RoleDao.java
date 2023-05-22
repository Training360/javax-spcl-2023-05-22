package mentoring.role;

import java.util.List;
import java.util.Set;

public interface RoleDao {

    void create(Role role);

    List<Role> findByIds(Set<Long> ids);
}
