package af.cmr.iuc.feedback.repository;

import af.cmr.iuc.feedback.entities.CourseFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseFeedbackRepository extends JpaRepository<CourseFeedback, Long> {
    List<CourseFeedback> findByCourseId(Long courseId);
    List<CourseFeedback> findByStudentId(Long studentId);
}

