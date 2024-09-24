package repositories;

import entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Long, User> {
    Optional<User> findByEmail(String email);
}
