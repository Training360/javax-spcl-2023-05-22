package mentoring.findcourse;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;
import org.junit.jupiter.api.extension.ExtendWith;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;

@AnalyzeClasses(packages = "mentoring")
class ArchitectureTest {

    @ArchTest
    static final ArchRule skillRule = classes().that().resideInAPackage("mentoring.skill")
            .should().onlyAccessClassesThat().resideInAnyPackage("java.lang", "mentoring.skill");

    @ArchTest
    static final ArchRule skillLevelRule = classes().that().resideInAPackage("mentoring.skilllevel")
            .should().onlyAccessClassesThat().resideInAnyPackage("java.lang", "mentoring.skilllevel", "mentoring.skill");

    @ArchTest
    static final ArchRule enrollmentRule = classes().that().resideInAPackage("mentoring.enrollment")
            .should().onlyAccessClassesThat().resideInAnyPackage("java.lang", "java.util", "mentoring.enrollment");

    @ArchTest
    static final ArchRule courseRule = classes().that().resideInAPackage("mentoring.course")
            .should().onlyAccessClassesThat().resideInAnyPackage("java.lang","mentoring.course", "mentoring.skilllevel");

    @ArchTest
    static final ArchRule employeeSkillsRule = classes().that().resideInAPackage("mentoring.employeeskills")
            .should().onlyAccessClassesThat().resideInAnyPackage("java.lang","java.util..", "mentoring.employeeskills", "mentoring.skilllevel");

    @ArchTest
    static final ArchRule roleRule = classes().that().resideInAPackage("mentoring.role")
            .should().onlyAccessClassesThat().resideInAnyPackage("java.lang","mentoring.role", "mentoring.skilllevel");

    @ArchTest
    static final ArchRule employeeRule = classes().that().resideInAPackage("mentoring.employee")
            .should().onlyAccessClassesThat().resideInAnyPackage("java.lang","java.util", "mentoring.employee");

    @ArchTest
    static final ArchRule completeCourseRule = classes().that().resideInAPackage("mentoring.completecourse")
            .should().onlyAccessClassesThat().resideInAnyPackage("java.lang","mentoring.completecourse", "mentoring.enrollment", "mentoring.course", "mentoring.employeeskills");

    @ArchTest
    static final ArchRule findCourseRule = classes().that().resideInAPackage("mentoring.findcourse")
            .and().haveSimpleNameNotEndingWith("Test")
            .should().onlyAccessClassesThat().resideInAnyPackage("java.lang","java.util..", "mentoring.findcourse", "mentoring.course", "mentoring.employeeskills", "mentoring.role", "mentoring.employee", "mentoring.skilllevel");

    @ArchTest
    static final ArchRule admitEmployeeRule = classes().that().resideInAPackage("mentoring.admitemployee")
            .should().onlyAccessClassesThat().resideInAnyPackage("java.lang","mentoring.admitemployee", "mentoring.course", "mentoring.employeeskills", "mentoring.employee")
            ;


}
