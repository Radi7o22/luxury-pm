package softuni.project.onlinestore.db.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Image {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column
    private String path;

    @Column(name = "is_main")
    private boolean isMain;

    @ManyToOne
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

}
