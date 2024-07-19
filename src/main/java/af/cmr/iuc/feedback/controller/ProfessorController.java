package af.cmr.iuc.feedback.controller;

import af.cmr.iuc.feedback.entities.Professor;
import af.cmr.iuc.feedback.services.ProfessorService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/professors")
@Tag(name = "Professor", description = "Professor management APIs")
@RequiredArgsConstructor
public class ProfessorController {
    private final ProfessorService professorService;

    @PostMapping
    @Operation(summary = "Create a new professor")
    public ResponseEntity<Professor> createProfessor(@RequestBody Professor professor) {
        return ResponseEntity.ok(professorService.createProfessor(professor));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get a professor by ID")
    public ResponseEntity<Professor> getProfessorById(@PathVariable Long id) {
        return ResponseEntity.ok(professorService.getProfessorById(id));
    }

    @GetMapping
    @Operation(summary = "Get all professors")
    public ResponseEntity<List<Professor>> getAllProfessors() {
        return ResponseEntity.ok(professorService.getAllProfessors());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update a professor")
    public ResponseEntity<Professor> updateProfessor(@PathVariable Long id, @RequestBody Professor professorDetails) {
        return ResponseEntity.ok(professorService.updateProfessor(id, professorDetails));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a professor")
    public ResponseEntity<Void> deleteProfessor(@PathVariable Long id) {
        professorService.deleteProfessor(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/email/{email}")
    @Operation(summary = "Get a professor by email")
    public ResponseEntity<Professor> getProfessorByEmail(@PathVariable String email) {
        return ResponseEntity.ok(professorService.getProfessorByEmail(email));
    }

    @GetMapping("/department/{department}")
    @Operation(summary = "Get professors by department")
    public ResponseEntity<List<Professor>> getProfessorsByDepartment(@PathVariable String department) {
        return ResponseEntity.ok(professorService.getProfessorsByDepartment(department));
    }
}
