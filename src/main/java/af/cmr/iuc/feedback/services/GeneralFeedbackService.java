package af.cmr.iuc.feedback.services;

import af.cmr.iuc.feedback.entities.GeneralFeedback;
import af.cmr.iuc.feedback.exception.ResourceNotFoundException;
import af.cmr.iuc.feedback.repository.GeneralFeedbackRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GeneralFeedbackService {
    private final GeneralFeedbackRepository generalFeedbackRepository;

    public GeneralFeedback createGeneralFeedback(GeneralFeedback feedback) {
        feedback.setCreatedAt(LocalDateTime.now());
        return generalFeedbackRepository.save(feedback);
    }

    public GeneralFeedback getGeneralFeedbackById(Long id) {
        return generalFeedbackRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("GeneralFeedback not found with id: " + id));
    }

    public List<GeneralFeedback> getAllGeneralFeedbacks() {
        return generalFeedbackRepository.findAll();
    }

    public List<GeneralFeedback> getGeneralFeedbackByStudent(Long studentId) {
        return generalFeedbackRepository.findByStudentId(studentId);
    }

    public List<GeneralFeedback> getGeneralFeedbackByType(String feedbackType) {
        return generalFeedbackRepository.findByFeedbackType(feedbackType);
    }

    public GeneralFeedback updateGeneralFeedback(Long id, GeneralFeedback feedbackDetails) {
        GeneralFeedback feedback = getGeneralFeedbackById(id);
        feedback.setFeedbackType(feedbackDetails.getFeedbackType());
        feedback.setComments(feedbackDetails.getComments());
        feedback.setFeedbackDate(feedbackDetails.getFeedbackDate());
        return generalFeedbackRepository.save(feedback);
    }

    public void deleteGeneralFeedback(Long id) {
        GeneralFeedback feedback = getGeneralFeedbackById(id);
        generalFeedbackRepository.delete(feedback);
    }
}
