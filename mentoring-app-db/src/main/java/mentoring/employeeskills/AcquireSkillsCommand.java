package mentoring.employeeskills;

import lombok.Value;
import mentoring.skilllevel.SkillLevel;

import java.util.List;

@Value
public class AcquireSkillsCommand {

    long employeeId;

    List<SkillLevel> skillLevels;
}
