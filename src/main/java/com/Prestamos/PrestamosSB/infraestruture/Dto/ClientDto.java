package com.Prestamos.PrestamosSB.infraestruture.Dto;

import com.Prestamos.PrestamosSB.domain.Client.Client;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;



@Data
public class ClientDto {

    @NotNull(message = "Name is require")
    @Size(min = 1,max = 50, message = "Name is require")
    private String name;

    @NotNull(message = "LastName is require")
    @Size(min = 1,max = 50,message = "LastName is require")
    private String lastName;

    @Email(message = "Not is a Email")
    private String email;

    @Size(min = 6, max = 20)
    private String phoneNumber;


    public Client getClientFromDto(){

        Client client = new Client();
        client.setName(name);
        client.setLastName(lastName);
        client.setEmail(email);
        client.setPhoneNumber(phoneNumber);

        return client;
    }


}
