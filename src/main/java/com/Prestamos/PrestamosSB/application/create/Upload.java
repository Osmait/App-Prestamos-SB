package com.Prestamos.PrestamosSB.application.create;



import com.cloudinary.Cloudinary;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



@Component
public class Upload {

    private final Map<String, String> config = new HashMap<>();
    public  Map uploadImage(File img) throws Exception {

        config.put("cloud_name", "divez9sgt");
        config.put("api_key", "534463164334522");
        config.put("api_secret", "lbWU3NzsQFuDWnLnrHMQD59H3LM");
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
