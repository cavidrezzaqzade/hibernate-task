package az.iktex.hibernatetask.models;

import az.iktex.hibernatetask.models.instructor.Instructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints = {
        @UniqueConstraint(name = "UniqueCourseName", columnNames = {"courseName"}),
        @UniqueConstraint(name = "UniqueCourseCodeAndCreditScore", columnNames = {"courseCode", "creditScore"})})
public class Course extends AbstractBaseClass{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String courseName;
    @NaturalId
    private Integer courseCode;
    private Integer creditScore;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private CourseStudent courseSet;

    @ManyToOne
    private Instructor instructor;

    public Course(String courseName, Integer courseCode, Integer creditScore) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.creditScore = creditScore;
    }

    public Course() {}

    public CourseStudent getCourseSet() {
        return courseSet;
    }

    public void setCourseSet(CourseStudent courseSet) {
        this.courseSet = courseSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(Integer courseCode) {
        this.courseCode = courseCode;
    }

    public Integer getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(Integer creditScore) {
        this.creditScore = creditScore;
    }


    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @Override
    public String toString() {
        return "models.Course{" +
                "id=" + id +
                ", courseName='" + courseName + '\'' +
                ", courseCode=" + courseCode +
                ", creditScore=" + creditScore +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;

        return getId() != null ? getId().equals(course.getId()) : course.getId() == null;
    }

    @Override
    public int hashCode() {
        return getId() != null ? getId().hashCode() : 0;
    }
}
