package mentoring.findcourse;

import lombok.ToString;
import mentoring.employeeskills.EmployeeSkills;
import mentoring.role.Role;
import mentoring.skilllevel.SkillLevel;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ToString
public class SkillLevels {

    private Map<Long, SkillLevel> values;

    private SkillLevels(List<SkillLevel> items) {
        values = items.stream().collect(
                Collectors.toMap(SkillLevel::getSkillId, skill -> skill, (s, a) -> s.getLevel() > a.getLevel() ? s : a));
    }

    public static SkillLevels ofRoles(List<Role> roles) {
        var values = roles.stream().flatMap(role -> role.getRequiredSkills().stream()).toList();
        return new SkillLevels(values);
    }

    public static SkillLevels ofEmployeeSkills(EmployeeSkills employeeSkills) {
        var values = employeeSkills.getAcquiredSkills();
        return new SkillLevels(values);
    }

    public SkillLevels notPresent(SkillLevels another) {
        var differences = another.values.values().stream().filter(this::requireButNotPresent).toList();
        return new SkillLevels(differences);
    }

    private boolean requireButNotPresent(SkillLevel requiredSkill) {
        return !values.containsKey(requiredSkill.getSkillId()) ||
                values.get(requiredSkill.getSkillId()).getLevel() < requiredSkill.getLevel();
    }

    public List<SkillLevel> toList() {
        return List.copyOf(values.values());
    }

}
