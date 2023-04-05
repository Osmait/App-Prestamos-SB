package com.Prestamos.PrestamosSB.application.create;



import com.cloudinary.Cloudinary;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;



public class Upload {


    public static Map uploadImage(File img) {
        Map<String, String> config = new HashMap<>();
        config.put("cloud_name", "divez9sgt");
        config.put("api_key", "534463164334522");
        config.put("api_secret", "lbWU3NzsQFuDWnLnrHMQD59H3LM");
        Cloudinary cloudinary = new Cloudinary(config);
        String idImag ="Client-" + Math.random();

        Map<String, String> prueba = new HashMap<>();
        prueba.put("public_id", idImag);

        try {

            return cloudinary.uploader().upload(img, prueba);
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
        }
       return prueba;
    }
}
