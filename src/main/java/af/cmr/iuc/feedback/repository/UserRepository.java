package af.cmr.iuc.feedback.repository;

import af.cmr.iuc.feedback.entities.User;
import af.cmr.iuc.feedback.enums.UserType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
    List<User> findByUserType(UserType userType);
}
