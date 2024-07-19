package af.cmr.iuc.feedback.repository;

import af.cmr.iuc.feedback.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    Course findByCourseCode(String courseCode);
    List<Course> findByDepartment(String department);
    List<Course> findByProfessorId(Long professorId);
}

