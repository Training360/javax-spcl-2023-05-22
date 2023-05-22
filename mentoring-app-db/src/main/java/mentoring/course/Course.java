package mentoring.course;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import mentoring.skilllevel.SkillLevel;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "courses")
@NamedQuery(name = "findAll", query = "select distinct c from Course c left join fetch c.providedSkills")
@NamedQuery(name = "findCourseById", query = "select distinct c from Course c left join fetch c.providedSkills where c.id = :courseId")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ElementCollection
    @CollectionTable(name = "course_provided_skills")
    private List<SkillLevel> providedSkills;

    public Course(String name, List<SkillLevel> providedSkills) {
        this.name = name;
        this.providedSkills = providedSkills;
    }

}
