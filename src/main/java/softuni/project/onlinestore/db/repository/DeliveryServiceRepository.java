package softuni.project.onlinestore.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.project.onlinestore.db.model.DeliveryService;

@Repository
public interface DeliveryServiceRepository extends JpaRepository<DeliveryService, Long> {
}
