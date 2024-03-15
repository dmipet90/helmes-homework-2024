package ee.dmipet90.helmeshomework.api.repository;

import ee.dmipet90.helmeshomework.api.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);
}
