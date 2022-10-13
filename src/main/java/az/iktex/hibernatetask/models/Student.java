package az.iktex.hibernatetask.models;

import az.iktex.hibernatetask.models.enums.Gender;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class Student extends AbstractBaseClass{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate birthDate;
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private CourseStudent studentSet;

    public Student(String name, LocalDate birthDate, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.gender = gender;
    }

    public Student() {}

    public CourseStudent getStudentSet() {
        return studentSet;
    }

    public void setStudentSet(CourseStudent studentSet) {
        this.studentSet = studentSet;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "models.Student{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", gender=" + gender +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;

        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }
}
