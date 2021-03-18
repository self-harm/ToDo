package io.selfharmed.todo.model.db;

import io.selfharmed.todo.model.DTO.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="users")
public abstract class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String surname;
    private String role;
    private String email;
    private String password;

    @OneToMany(cascade = CascadeType.ALL,
    mappedBy = "user")
    private List<Task> tasks;

    protected abstract UserDTO toUserDTOCustom(Long id, String name, String surname
            , String email, String password);

    protected abstract void setFromUserDTOCustom(UserDTO userDTO);

    public UserDTO toUserDTO(){
        return toUserDTOCustom(id, name, surname, email, password);
    }

    public void setFromUserDTO(UserDTO userDTO){
        name = userDTO.getName();
        surname = userDTO.getSurname();
        email = userDTO.getEmail();
        password = userDTO.getPassword();
    }
}
