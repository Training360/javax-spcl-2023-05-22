package mentoring.role;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import mentoring.skilllevel.SkillLevel;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NamedQuery(name = "getByIds", query = "select distinct r from Role r join fetch r.requiredSkills where r.id in :ids")
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "role_required_skills")
    private List<SkillLevel> requiredSkills;

    public Role(String name, List<SkillLevel> requiredSkills) {
        this.name = name;
        this.requiredSkills = requiredSkills;
    }
}
