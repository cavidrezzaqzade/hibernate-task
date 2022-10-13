package az.iktex.hibernatetask.models.instructor;


import javax.persistence.Entity;

@Entity
public class PermanentInstructor extends Instructor{

//    @ManyToOne
//    @JoinColumn(name = "salary_id")
    private Double fixedSalary;

    public PermanentInstructor() {

    }

    public PermanentInstructor(String name, String address, String phoneNumber, Double fixedSalary) {
        super(name, address, phoneNumber);
        this.fixedSalary = fixedSalary;
    }

    public PermanentInstructor(Double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }

    public Double getFixedSalary() {
        return fixedSalary;
    }

    public void setFixedSalary(Double fixedSalary) {
        this.fixedSalary = fixedSalary;
    }
}
