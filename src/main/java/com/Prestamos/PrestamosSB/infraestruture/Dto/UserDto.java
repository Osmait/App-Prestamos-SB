package com.Prestamos.PrestamosSB.infraestruture.Dto;

import com.Prestamos.PrestamosSB.domain.User;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

@Component
public class UserDto {

    @NotNull(message = "Name is require")
    @Size(min = 1,max = 50)
    private String name;
    @NotNull(message = "Last Name  is require")
    @Size(min = 1,max = 50)
    private String lastName;
    @Email(message = "the field not is a email")
    @NotNull(message = "Email is require")
    @Size(min = 1,max = 50)
    private String email;
    @NotNull(message = "password is require")
    @Size(min = 6, max = 20, message = "Password length  min 6")
    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public User getUserFromDto(){
        User user = new User();
        user.setName(name);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(password);

        return  user;
    }
}
