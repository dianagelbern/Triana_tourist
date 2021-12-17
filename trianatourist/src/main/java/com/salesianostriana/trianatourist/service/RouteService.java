package com.salesianostriana.trianatourist.service;

import com.salesianostriana.trianatourist.dto.route.CreateRouteDto;
import com.salesianostriana.trianatourist.dto.route.GetRouteDto;
import com.salesianostriana.trianatourist.dto.route.RouteDtoConverter;
import com.salesianostriana.trianatourist.error.excepciones.ListEntityNotFoundException;
import com.salesianostriana.trianatourist.error.excepciones.SingleEntityNotFoundException;
import com.salesianostriana.trianatourist.model.Route;
import com.salesianostriana.trianatourist.repository.RouteRepository;
import com.salesianostriana.trianatourist.service.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RouteService extends BaseService<Route, Long, RouteRepository> {

    @Autowired
    private RouteRepository repository;

    @Override
    public List<Route> findAll() {
        List<Route> res = super.findAll();
        if (res.isEmpty()){
            throw new ListEntityNotFoundException(GetRouteDto.class);
        }else {
            return res;
        }
    }

    @Override
    public Optional<Route> findById(Long id) {
        if(repository.findById(id).isEmpty()){
            throw new SingleEntityNotFoundException(id.toString(), Route.class);

        }else {
            return repository.findById(id);
        }
    }

    public Route save(CreateRouteDto create, RouteDtoConverter converter) {
        return repository.save((Route) converter.createRouteDtoToRoute(create));
    }

    public Route edit(CreateRouteDto create, Route r) {
        r.setName(create.getName());
        r.setSteps(create.getSteps());
        return repository.save(r);
    }

    @Override
    public void delete(Route r) {
        super.delete(r);
    }

    @Override
    public List<Route> saveAll(List<Route> list) {
        return super.saveAll(list);
    }
}
