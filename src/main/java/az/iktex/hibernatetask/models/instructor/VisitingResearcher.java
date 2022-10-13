package az.iktex.hibernatetask.models.instructor;

import javax.persistence.Entity;

@Entity
public class VisitingResearcher extends Instructor{

//    @ManyToOne
//    @JoinColumn(name = "salary_id")
    private Double hourlySalary;

    public VisitingResearcher() {

    }

    public VisitingResearcher(String name, String address, String phoneNumber, Double hourlySalary) {
        super(name, address, phoneNumber);
        this.hourlySalary = hourlySalary;
    }

    public VisitingResearcher(Double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public Double getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(Double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }
}
