package callbus.zaritalk.dataaccesslayer.repository;

import callbus.zaritalk.dataaccesslayer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
