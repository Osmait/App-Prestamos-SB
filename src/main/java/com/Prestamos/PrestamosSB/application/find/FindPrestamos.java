package com.Prestamos.PrestamosSB.application.find;

import com.Prestamos.PrestamosSB.domain.Prestamo;
import com.Prestamos.PrestamosSB.domain.PrestamoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FindPrestamos {


    private final   PrestamoRepository prestamoRepository;

    public List<Prestamo> FindAllPrestamos(){
        List<Prestamo> prestamoList = new ArrayList<>();
        prestamoRepository.findAll().iterator().forEachRemaining(prestamoList::add);
        return  prestamoList;
    }
}
