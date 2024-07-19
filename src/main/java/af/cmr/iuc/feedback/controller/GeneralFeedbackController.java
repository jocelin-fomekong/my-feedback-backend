package af.cmr.iuc.feedback.controller;


import af.cmr.iuc.feedback.entities.GeneralFeedback;
import af.cmr.iuc.feedback.services.GeneralFeedbackService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/general-feedback")
@Tag(name = "General Feedback", description = "General Feedback management APIs")
@RequiredArgsConstructor
public class GeneralFeedbackController {
    private final GeneralFeedbackService generalFeedbackService;

    @PostMapping
    @Operation(summary = "Create a new general feedback")
    public ResponseEntity<GeneralFeedback> createGeneralFeedback(@RequestBody GeneralFeedback feedback) {
        return ResponseEntity.ok(generalFeedbackService.createGeneralFeedback(feedback));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a general feedback by its id")
    public ResponseEntity<GeneralFeedback> getGeneralFeedbackById(@PathVariable Long id) {
        return ResponseEntity.ok(generalFeedbackService.getGeneralFeedbackById(id));
    }

    @GetMapping
    @Operation(summary = "Get all general feedbacks")
    public ResponseEntity<List<GeneralFeedback>> getAllGeneralFeedbacks() {
        return ResponseEntity.ok(generalFeedbackService.getAllGeneralFeedbacks());
    }

    @GetMapping("/student/{studentId}")
    @Operation(summary = "Get all general feedbacks from a specific student")
    public ResponseEntity<List<GeneralFeedback>> getGeneralFeedbackByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(generalFeedbackService.getGeneralFeedbackByStudent(studentId));
    }

    @GetMapping("/type/{feedbackType}")
    @Operation(summary = "Get all general feedbacks of a specific type")
    public ResponseEntity<List<GeneralFeedback>> getGeneralFeedbackByType(@PathVariable String feedbackType) {
        return ResponseEntity.ok(generalFeedbackService.getGeneralFeedbackByType(feedbackType));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing general feedback")
    public ResponseEntity<GeneralFeedback> updateGeneralFeedback(@PathVariable Long id, @RequestBody GeneralFeedback feedbackDetails) {
        return ResponseEntity.ok(generalFeedbackService.updateGeneralFeedback(id, feedbackDetails));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a general feedback")
    public ResponseEntity<Void> deleteGeneralFeedback(@PathVariable Long id) {
        generalFeedbackService.deleteGeneralFeedback(id);
        return ResponseEntity.ok().build();
    }
}
