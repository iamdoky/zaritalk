package callbus.zaritalk.dataaccesslayer.repository;

import callbus.zaritalk.dataaccesslayer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
