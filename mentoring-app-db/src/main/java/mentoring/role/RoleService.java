package mentoring.role;

import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Set;

@AllArgsConstructor
public class RoleService {

    private RoleDao roleDao;

    public void createRole(Role role) {
        roleDao.create(role);
    }

    public List<Role> findRolesById(Set<Long> ids) {
        return roleDao.findByIds(ids);
    }
}
