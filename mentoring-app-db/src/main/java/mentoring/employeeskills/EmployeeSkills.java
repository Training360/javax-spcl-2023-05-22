package mentoring.employeeskills;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import mentoring.skilllevel.SkillLevel;

import javax.persistence.*;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "employee_skills")
@NamedQuery(name = "findByEmployeeId", query = "select distinct s from EmployeeSkills s join fetch s.acquiredSkills where s.employeeId = :employeeId")
public class EmployeeSkills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long employeeId;

    @ElementCollection
    @CollectionTable(name = "employee_acquired_skills")
    private List<SkillLevel> acquiredSkills;

    public EmployeeSkills(Long employeeId, List<SkillLevel> acquiredSkills) {
        this.employeeId = employeeId;
        this.acquiredSkills = acquiredSkills;
    }

    public void acquireSkills(List<SkillLevel> skillLevelsToAdd) {
        var skillsById = acquiredSkills.stream()
                .collect(Collectors.toMap(SkillLevel::getSkillId, Function.identity()));

        for (var skillToAdd: skillLevelsToAdd) {
            var existingSkill = skillsById.get(skillToAdd.getSkillId());
            if (existingSkill == null) {
                acquiredSkills.add(skillToAdd);
            }
            else {
                if (existingSkill.getLevel() < skillToAdd.getLevel()) {
                    acquiredSkills.remove(existingSkill);
                    acquiredSkills.add(skillToAdd);
                }
            }
        }

    }
}
