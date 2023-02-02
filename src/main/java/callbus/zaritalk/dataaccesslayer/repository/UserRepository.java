package callbus.zaritalk.dataaccesslayer.repository;

import callbus.zaritalk.dataaccesslayer.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {
}
