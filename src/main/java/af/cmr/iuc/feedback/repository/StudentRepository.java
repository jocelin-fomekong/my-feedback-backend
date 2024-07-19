package af.cmr.iuc.feedback.repository;

import af.cmr.iuc.feedback.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Student findByEmail(String email);
}

