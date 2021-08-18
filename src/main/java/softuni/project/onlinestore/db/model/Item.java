package softuni.project.onlinestore.db.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Item {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column(length = 45)
    private String name;

    private float price;

    @Column(length = 45)
    private String color;

    private float width;

    private float length;

    private float thickness;

    private float height;

    @Type(type = "text")
    private String description;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategory;

    @OneToMany(mappedBy = "item", orphanRemoval = true)
    private List<Image> images;
}
