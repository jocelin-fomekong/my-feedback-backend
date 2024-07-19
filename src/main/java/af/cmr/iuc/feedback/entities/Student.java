package af.cmr.iuc.feedback.entities;


import af.cmr.iuc.feedback.enums.UserType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "students")
@Data
public class Student extends User {
    @Column(name = "enrollment_date", nullable = false)
    private LocalDate enrollmentDate;

    @PrePersist
    public void prePersist() {
        setUserType(UserType.STUDENT);
    }
}

