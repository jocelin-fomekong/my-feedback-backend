package af.cmr.iuc.feedback.repository;

import af.cmr.iuc.feedback.entities.GeneralFeedback;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GeneralFeedbackRepository extends JpaRepository<GeneralFeedback, Long> {
    List<GeneralFeedback> findByStudentId(Long studentId);
    List<GeneralFeedback> findByFeedbackType(String feedbackType);
}
