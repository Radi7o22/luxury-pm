package softuni.project.onlinestore.db.model.user;

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
@Table(name = "\"User\"")
public class User {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private long id;

    @Column(length = 45)
    private String username;

    @Column(length = 45)
    private String password;

    @Column(length = 45)
    private String email;

    @Column(length = 45)
    private String phone;

    @Column(length = 100)
    private String address;

    @Column(length = 45)
    private String firstName;

    @Column(length = 45)
    private String lastName;

}
