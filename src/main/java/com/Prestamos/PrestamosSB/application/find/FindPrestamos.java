package com.Prestamos.PrestamosSB.application.find;

import com.Prestamos.PrestamosSB.domain.Prestamo;
import com.Prestamos.PrestamosSB.domain.PrestamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FindPrestamos {

    @Autowired
    private  PrestamoRepository prestamoRepository;

    public List<Prestamo> FindPrestamos(){
        List<Prestamo> prestamoList = new ArrayList<>();
        prestamoRepository.findAll().iterator().forEachRemaining(prestamoList::add);
        return  prestamoList;
    }
}
