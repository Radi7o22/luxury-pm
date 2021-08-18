package softuni.project.onlinestore.db.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SignRequest {

    private String username;
    private String password;

}

