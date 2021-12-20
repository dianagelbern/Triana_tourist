package com.salesianostriana.trianatourist.service;

import com.salesianostriana.trianatourist.dto.category.CategoryDtoConverter;
import com.salesianostriana.trianatourist.dto.poi.CreatePoiDto;
import com.salesianostriana.trianatourist.dto.poi.GetPoiDto;
import com.salesianostriana.trianatourist.dto.poi.PoiDtoConverter;
import com.salesianostriana.trianatourist.dto.route.GetRouteDto;
import com.salesianostriana.trianatourist.error.excepciones.ListEntityNotFoundException;
import com.salesianostriana.trianatourist.error.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.trianatourist.model.Category;
import com.salesianostriana.trianatourist.model.Poi;
import com.salesianostriana.trianatourist.model.Route;
import com.salesianostriana.trianatourist.repository.PoiRepository;
import com.salesianostriana.trianatourist.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Service
public class PoiService extends BaseService<Poi, Long, PoiRepository> {

    @Autowired
    private PoiRepository repository;

    public List<Poi> findAll() {
        List<Poi> res = super.findAll();
        if (res.isEmpty()) {
            throw new ListEntityNotFoundException(GetPoiDto.class);
        } else {
            return res;
        }
    }

    public Optional<Poi> findById(Long id) {
        if (repository.findById(id).isEmpty()) {
            throw new SingleEntityNotFoundException(id.toString(), Poi.class);

        } else {
            return repository.findById(id);
        }
    }

    public Poi save(CreatePoiDto create, PoiDtoConverter converter, CategoryService category) {

        Poi p = converter.createPoiDtoToPoi(create);
        Optional<Category> c = category.findById(create.getCategory());
        p.setCategory(c.get());
        return repository.save(p);
    }

    public Poi edit(CreatePoiDto create, PoiDtoConverter converter, Long id, CategoryService category) {

            Optional<Poi> po = findById(id);

            if (po.isEmpty()){
                throw new SingleEntityNotFoundException(id.toString(), Poi.class);
            } else{
                Poi poi = converter.editPoiDto(create, id);
                Optional<Category> c = category.findById(create.getCategory());
                poi.setCategory(c.get());
                save(poi);
                return repository.save(poi);
            }

    }



    public void delete(Poi p, RouteService rs) {
        List<Route> lista = new ArrayList<>(p.getRoutes());
        for (Iterator<Route> i = lista.iterator(); i.hasNext();){
            Route r = i.next();
            r.removeSteps(p);
            rs.save(r);
            save(p);
        }
        super.delete(p);
    }

    @Override
    public List<Poi> saveAll(List<Poi> list) {
        return super.saveAll(list);
    }



}
