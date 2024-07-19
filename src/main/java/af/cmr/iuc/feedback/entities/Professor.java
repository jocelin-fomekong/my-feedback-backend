package af.cmr.iuc.feedback.entities;

import af.cmr.iuc.feedback.enums.UserType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "professors")
@Data
@EqualsAndHashCode(callSuper = true)
public class Professor extends User {
    @Column(nullable = false)
    private String department;

    @PrePersist
    public void prePersist() {
        setUserType(UserType.PROFESSOR);
    }
}
