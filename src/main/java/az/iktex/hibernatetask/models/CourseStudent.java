package az.iktex.hibernatetask.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class CourseStudent extends AbstractBaseClass{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean active;
    private String name;

    @OneToMany(mappedBy = "studentSet")
    private Set<Student> studentSet = new HashSet<>();

    @OneToMany(mappedBy = "courseSet")
    private Set<Course> courseSet = new HashSet<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Student> getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(Set<Student> studentSet) {
        this.studentSet = studentSet;
    }

    public Set<Course> getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(Set<Course> courseSet) {
        this.courseSet = courseSet;
    }

    public CourseStudent(boolean active, String name) {
        this.active = active;
        this.name = name;
    }

    public CourseStudent() {}
}
