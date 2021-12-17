package com.salesianostriana.trianatourist.service;

import com.salesianostriana.trianatourist.dto.*;
import com.salesianostriana.trianatourist.error.excepciones.ListEntityNotFoundException;
import com.salesianostriana.trianatourist.error.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.trianatourist.model.Category;
import com.salesianostriana.trianatourist.model.Poi;
import com.salesianostriana.trianatourist.repository.PoiRepository;
import com.salesianostriana.trianatourist.service.base.BaseService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PoiService extends BaseService<Poi, Long, PoiRepository> {

    private PoiRepository repository;

    @Override
    public List<Poi> findAll() {
        List<Poi> res = super.findAll();
        if (res.isEmpty()){
            throw new ListEntityNotFoundException(GetPoiDto.class);
        }else {
            return res;
        }
    }

    @Override
    public Optional<Poi> findById(Long id) {
        if(repository.findById(id).isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(), Poi.class);

        }else {
            return repository.findById(id);
        }
    }

    public Poi save(CreatePoiDto create, PoiDtoConverter converter) {
        return repository.save((Poi) converter.createPoiDtoToPoi(create));
    }

    public Poi edit(CreatePoiDto create, Poi p) {
        p.setName(create.getName());
        return repository.save(p);
    }

    @Override
    public void delete(Poi p) {
        super.delete(p);
    }

}
