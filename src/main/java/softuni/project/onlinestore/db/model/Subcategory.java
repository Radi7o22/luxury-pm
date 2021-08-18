package softuni.project.onlinestore.db.model;

import lombok.*;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@EqualsAndHashCode(exclude = "categories")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Subcategory {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column(length = 45)
    private String name;

    @Type(type = "text")
    private String description;

    @ManyToMany(mappedBy = "subcategories")
    private Set<Category> categories;
}
