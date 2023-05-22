package mentoring.skill;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SkillService {

    private SkillDao skillDao;

    public void createSkill(Skill skill) {
        skillDao.createSkill(skill);
    }
}
