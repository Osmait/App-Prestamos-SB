package com.Prestamos.PrestamosSB.infraestruture.Dto;

import com.Prestamos.PrestamosSB.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.Size;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class UserDto {

    @NotNull(message = "Name is require")
    @Size(min = 1,max = 50)
    private String name;
    @NotNull(message = "LastName is require")
    @Size(min = 1,max = 50)
    private String lastName;
    @Email(message = "the field not is a email")
    @NotNull(message = "Email is require")
    @Size(min = 1,max = 50)
    private String email;
    @NotNull(message = "password is require")
    @Size(min = 6, max = 20, message = "Password length  min 6")
    private String password;



    public User getUserFromDto(){
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);

        return  user;
    }
}
