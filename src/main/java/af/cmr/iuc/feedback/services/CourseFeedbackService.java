package af.cmr.iuc.feedback.services;

import af.cmr.iuc.feedback.entities.CourseFeedback;
import af.cmr.iuc.feedback.exception.ResourceNotFoundException;
import af.cmr.iuc.feedback.repository.CourseFeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseFeedbackService {
    private final CourseFeedbackRepository courseFeedbackRepository;

    public CourseFeedback createCourseFeedback(CourseFeedback feedback) {
        feedback.setCreatedAt(LocalDateTime.now());
        return courseFeedbackRepository.save(feedback);
    }

    public CourseFeedback getCourseFeedbackById(Long id) {
        return courseFeedbackRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CourseFeedback not found with id: " + id));
    }

    public List<CourseFeedback> getAllCourseFeedbacks() {
        return courseFeedbackRepository.findAll();
    }

    public List<CourseFeedback> getCourseFeedbackByCourse(Long courseId) {
        return courseFeedbackRepository.findByCourseId(courseId);
    }

    public List<CourseFeedback> getCourseFeedbackByStudent(Long studentId) {
        return courseFeedbackRepository.findByStudentId(studentId);
    }

    public CourseFeedback updateCourseFeedback(Long id, CourseFeedback feedbackDetails) {
        CourseFeedback feedback = getCourseFeedbackById(id);
        feedback.setRating(feedbackDetails.getRating());
        feedback.setComments(feedbackDetails.getComments());
        feedback.setFeedbackDate(feedbackDetails.getFeedbackDate());
        return courseFeedbackRepository.save(feedback);
    }

    public void deleteCourseFeedback(Long id) {
        CourseFeedback feedback = getCourseFeedbackById(id);
        courseFeedbackRepository.delete(feedback);
    }
}
