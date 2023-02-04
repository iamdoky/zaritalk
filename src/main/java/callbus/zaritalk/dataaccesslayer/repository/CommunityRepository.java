package callbus.zaritalk.dataaccesslayer.repository;

import callbus.zaritalk.dataaccesslayer.entity.Community;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunityRepository extends JpaRepository<Community, Long> {
}
