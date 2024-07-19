package af.cmr.iuc.feedback.repository;

import af.cmr.iuc.feedback.entities.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Professor findByEmail(String email);
    List<Professor> findByDepartment(String department);
}

