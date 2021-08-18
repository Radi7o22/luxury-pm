package softuni.project.onlinestore.db.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.project.onlinestore.db.model.Image;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {

    List<Image> findByItemId(long itemId);

}
