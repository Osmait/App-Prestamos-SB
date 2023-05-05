package com.Prestamos.PrestamosSB.infraestruture.controllers;

import com.Prestamos.PrestamosSB.application.create.ClientCreator;
import com.Prestamos.PrestamosSB.application.create.Upload;
import com.Prestamos.PrestamosSB.application.find.FindClient;
import com.Prestamos.PrestamosSB.domain.Client;

import com.Prestamos.PrestamosSB.infraestruture.Dto.ClientDto;
import com.Prestamos.PrestamosSB.infraestruture.controllers.exceptionController.exceptions.BadRequest;
import com.Prestamos.PrestamosSB.infraestruture.utils.ValidateBody;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@CrossOrigin
public class ClientController {

    private final ClientCreator clientCreator;
    private final FindClient findClient;
    private  final Upload uploadImg;
    private  final ValidateBody validateBody;


    @GetMapping("/client")
    public ResponseEntity<List<Client>>getClient() throws Exception {

        List<Client> clientList = findClient.findAllClientByUserId();

        return new ResponseEntity<>(clientList, HttpStatus.OK);

    }

    @PostMapping("/client")
    public ResponseEntity<Map<String, String>> createClient(@Validated @RequestBody ClientDto clientRequest,  BindingResult result) throws Exception {
        if (result.hasErrors()){
         throw new BadRequest(validateBody.ValidFilds(result).toString());
        }

        Client client = clientRequest.getClientFromDto();

        clientCreator.create(client);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/client/upload/{id}")
    public ResponseEntity<Map<String, String>> uploadImageClient( @RequestParam("file") MultipartFile imagen,@PathVariable Long id ) throws Exception {

        File file = File.createTempFile("temp", null);
        imagen.transferTo(file);
        String imgString =  uploadImg.uploadImage(file).get("secure_url").toString();
         Client client =  findClient.findClientById(id);
         client.setImg(imgString);
         clientCreator.create(client);
         return new ResponseEntity<>(HttpStatus.CREATED);
    }



    @DeleteMapping("/client/{id}")
    public ResponseEntity<HttpStatus>deleteClient(@PathVariable Long id){
        findClient.findAndDeleteById(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
