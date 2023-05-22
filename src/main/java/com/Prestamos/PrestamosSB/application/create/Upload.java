package com.Prestamos.PrestamosSB.application.create;



import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



@Component
public class Upload {

    @Value("${env.API_SECRET}")
    private String API_SECRET;

    @Value("${env.CLOUD_NAME}")
    private  String CLOUD_NAME;

    @Value("${env.API_KEY}")
    private String API_KEY;
    private final Map<String, String> config = new HashMap<>();
    public  Map uploadImage(File img) throws Exception {


        config.put("cloud_name", CLOUD_NAME);
        config.put("api_key",API_KEY );
        config.put("api_secret", API_SECRET);
        Cloudinary cloudinary = new Cloudinary(config);
        String idImag ="Client-" + Math.random();

        Map<String, String> imgSent = new HashMap<>();
        imgSent.put("public_id", idImag);

        try {
            return cloudinary.uploader().upload(img, imgSent);
        } catch (IOException exception) {
            throw  new Exception(exception);
        }

    }
}
