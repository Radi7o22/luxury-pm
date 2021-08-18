package softuni.project.onlinestore.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.project.onlinestore.db.model.Item;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {

    List<Item> findByCategoryIdAndSubcategoryId(long categoryId, long subcategoryId);

}
