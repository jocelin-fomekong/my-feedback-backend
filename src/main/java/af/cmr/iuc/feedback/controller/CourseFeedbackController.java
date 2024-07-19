package af.cmr.iuc.feedback.controller;

import af.cmr.iuc.feedback.entities.CourseFeedback;
import af.cmr.iuc.feedback.services.CourseFeedbackService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/course-feedback")
@Tag(name = "Course Feedback", description = "Course Feedback management APIs")
@RequiredArgsConstructor
public class CourseFeedbackController {
    private final CourseFeedbackService courseFeedbackService;

    @PostMapping
    @Operation(summary = "Create a new course feedback")
    public ResponseEntity<CourseFeedback> createCourseFeedback(@RequestBody CourseFeedback feedback) {
        return ResponseEntity.ok(courseFeedbackService.createCourseFeedback(feedback));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a course feedback by its id")
    public ResponseEntity<CourseFeedback> getCourseFeedbackById(@PathVariable Long id) {
        return ResponseEntity.ok(courseFeedbackService.getCourseFeedbackById(id));
    }

    @GetMapping
    @Operation(summary = "Get all course feedbacks")
    public ResponseEntity<List<CourseFeedback>> getAllCourseFeedbacks() {
        return ResponseEntity.ok(courseFeedbackService.getAllCourseFeedbacks());
    }

    @GetMapping("/course/{courseId}")
    @Operation(summary = "Get all feedbacks for a specific course")
    public ResponseEntity<List<CourseFeedback>> getCourseFeedbackByCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok(courseFeedbackService.getCourseFeedbackByCourse(courseId));
    }

    @GetMapping("/student/{studentId}")
    @Operation(summary = "Get all feedbacks from a specific student")
    public ResponseEntity<List<CourseFeedback>> getCourseFeedbackByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(courseFeedbackService.getCourseFeedbackByStudent(studentId));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing course feedback")
    public ResponseEntity<CourseFeedback> updateCourseFeedback(@PathVariable Long id, @RequestBody CourseFeedback feedbackDetails) {
        return ResponseEntity.ok(courseFeedbackService.updateCourseFeedback(id, feedbackDetails));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a course feedback")
    public ResponseEntity<Void> deleteCourseFeedback(@PathVariable Long id) {
        courseFeedbackService.deleteCourseFeedback(id);
        return ResponseEntity.ok().build();
    }
}

