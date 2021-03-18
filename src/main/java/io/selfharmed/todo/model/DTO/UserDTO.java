package io.selfharmed.todo.model.DTO;

import io.selfharmed.todo.model.db.User;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {
    private Long id;
    private String name;
    private String surname;
    private String email;
    private String password;
}
