package az.iktex.hibernatetask.config;

import az.iktex.hibernatetask.models.Course;
import az.iktex.hibernatetask.models.CourseStudent;
import az.iktex.hibernatetask.models.Student;
import az.iktex.hibernatetask.models.enums.Gender;
import az.iktex.hibernatetask.models.instructor.Instructor;
import az.iktex.hibernatetask.models.instructor.PermanentInstructor;
import az.iktex.hibernatetask.models.instructor.VisitingResearcher;
import az.iktex.hibernatetask.repositories.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.Month;

@Configuration
@RequiredArgsConstructor
@Slf4j
public class TestDataConfigurer implements CommandLineRunner {

    //private static final Logger logger = Logger.getLogger("TestDataConfigurer");

    //@PersistenceContext
    //EntityManager entityManager;

    private final CourseRepository courseRepository;
    private final CourseStudentRepository courseStudentRepository;
    private final InstructorRepository instructorRepository;
    private final StudentRepository studentRepository;
    private final VisitingInsRepository visitingInsRepository;
    private final PermanentInsRepository permanentInsRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // prepare entities ( in transient state)
        Student student1 = new Student("Cavid", LocalDate.of(1995, 2, 2), Gender.MALE);
        Student student2 = new Student("Aygun", LocalDate.of(1988, 2, 2), Gender.FEMALE);

        Course course1 = new Course("hibernate", 2, 2 );
        Course course2 = new Course("hibernate2", 1, 1 );

        CourseStudent courseStudent1 = new CourseStudent(true, "name1");
        CourseStudent courseStudent2 = new CourseStudent(false, "name2");

        student1.setStudentSet(courseStudent1);
        course1.setCourseSet(courseStudent1);

        student2.setStudentSet(courseStudent2);
        course2.setCourseSet(courseStudent2);

        Instructor instructor1 = new PermanentInstructor("a","a2","a3", 5.0);
//        instructor1.getCourseList().add(course1);

        Instructor instructor2 = new VisitingResearcher("b","b2","b3", 6.0);
//        instructor2.getCourseList().add(course2);

        course1.setInstructor(instructor1);
        course2.setInstructor(instructor2);

        // persist entities ( in persisted state)
        studentRepository.save(student1);
        studentRepository.save(student2);

        courseRepository.save(course1);
        courseRepository.save(course2);

        instructorRepository.save(instructor1);
        instructorRepository.save(instructor2);

        log.info("All data saved....");

    }
}
