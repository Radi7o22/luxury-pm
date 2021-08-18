package softuni.project.onlinestore.db.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import softuni.project.onlinestore.db.model.user.User;

import javax.persistence.*;
import java.time.LocalDateTime;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "\"Order\"")
public class Order {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column(name = "desired_delivery_date")
    private LocalDateTime desiredDeliveryDate;

    @Column(length = 45)
    private String firstName;

    @Column(length = 45)
    private String lastName;

    @Column(length = 100)
    private String address;

    @Column(name = "additional_info")
    private String additionalInfo;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "delivery_service_id")
    private DeliveryService deliveryService;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id")
    private User user;

}
