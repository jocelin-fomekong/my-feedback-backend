package af.cmr.iuc.feedback.services;

import af.cmr.iuc.feedback.entities.Professor;
import af.cmr.iuc.feedback.entities.User;
import af.cmr.iuc.feedback.enums.UserType;
import af.cmr.iuc.feedback.exception.ResourceNotFoundException;
import af.cmr.iuc.feedback.repository.ProfessorRepository;
import af.cmr.iuc.feedback.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfessorService {
    private final UserRepository userRepository;
    private final ProfessorRepository professorRepository;

    @Transactional
    public Professor createProfessor(Professor professor) {
        User user = new User();
        user.setFirstName(professor.getFirstName());
        user.setLastName(professor.getLastName());
        user.setEmail(professor.getEmail());
        user.setUserType(UserType.PROFESSOR);
        user = userRepository.save(user);

        professor.setId(user.getId());
        return professorRepository.save(professor);
    }

    public Professor getProfessorById(Long id) {
        return professorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Professor not found with id: " + id));
    }

    public List<Professor> getAllProfessors() {
        return professorRepository.findAll();
    }

    public Professor updateProfessor(Long id, Professor professorDetails) {
        Professor professor = getProfessorById(id);
        professor.setFirstName(professorDetails.getFirstName());
        professor.setLastName(professorDetails.getLastName());
        professor.setEmail(professorDetails.getEmail());
        professor.setDepartment(professorDetails.getDepartment());
        return professorRepository.save(professor);
    }

    public void deleteProfessor(Long id) {
        Professor professor = getProfessorById(id);
        professorRepository.delete(professor);
    }

    public Professor getProfessorByEmail(String email) {
        Professor professor = professorRepository.findByEmail(email);
        if (professor == null) {
            throw new ResourceNotFoundException("Professor not found with email: " + email);
        }
        return professor;
    }

    public List<Professor> getProfessorsByDepartment(String department) {
        List<Professor> professors = professorRepository.findByDepartment(department);
        if (professors.isEmpty()) {
            throw new ResourceNotFoundException("No professors found in department: " + department);
        }
        return professors;
    }
}
