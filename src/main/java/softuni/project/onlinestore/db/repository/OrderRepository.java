package softuni.project.onlinestore.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.project.onlinestore.db.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
}
