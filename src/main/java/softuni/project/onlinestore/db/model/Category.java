package softuni.project.onlinestore.db.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column(length = 45)
    private String name;

    @Type(type = "text")
    private String description;

    @ManyToMany
    @JoinTable(
            name = "category_subcategory",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "subcategory_id")
    )
    private Set<Subcategory> subcategories;

}
