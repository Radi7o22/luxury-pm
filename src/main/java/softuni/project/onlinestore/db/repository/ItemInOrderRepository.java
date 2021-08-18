package softuni.project.onlinestore.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.project.onlinestore.db.model.ItemInOrder;

public interface ItemInOrderRepository extends JpaRepository<ItemInOrder, Long> {
}
