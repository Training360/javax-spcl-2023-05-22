package mentoring.admitemployee;

import lombok.Value;
import mentoring.skilllevel.SkillLevel;

import java.util.List;
import java.util.Set;

@Value
public class AdmitEmployeeCommand {

    private String name;

    private Set<Long> roles;

    private List<SkillLevel> skillLevels;
}
