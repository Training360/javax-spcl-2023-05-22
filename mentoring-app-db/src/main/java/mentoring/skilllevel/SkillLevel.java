package mentoring.skilllevel;

import lombok.*;
import mentoring.findcourse.FindCourseService;

import javax.persistence.Embeddable;

@Embeddable
@Value
@AllArgsConstructor
public class SkillLevel {

    private long skillId;

    private long level;

    private SkillLevel() {
        skillId = 0;
        level = 0;
    }
}
