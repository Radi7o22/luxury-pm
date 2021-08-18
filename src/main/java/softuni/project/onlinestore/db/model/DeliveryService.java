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
@Table(name = "Delivery_Service")
public class DeliveryService {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column
    private String name;

}
