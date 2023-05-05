package com.Prestamos.PrestamosSB.infraestruture.utils;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.Map;

@Component
public class ValidateBody {

    public  Map<String, String>ValidFilds(BindingResult result){

        Map<String,String> errors = new HashMap<>();
        for (FieldError error: result.getFieldErrors()){

            errors.put(error.getField(),error.getDefaultMessage());

        }
        return errors;
    }
}
