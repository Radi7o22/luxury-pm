package softuni.project.onlinestore.db.model.user;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SignUpResponse {

    private int statusCode;
    private String message;

}
