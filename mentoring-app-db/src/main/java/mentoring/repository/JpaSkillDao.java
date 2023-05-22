package mentoring.repository;

import lombok.AllArgsConstructor;
import mentoring.skill.Skill;
import mentoring.skill.SkillDao;

@AllArgsConstructor
public class JpaSkillDao implements SkillDao {

    private PersistenceContextHandler handler;

    public void createSkill(Skill skill) {
        handler.doInTransaction(entityManager -> entityManager.persist(skill));
    }
}
