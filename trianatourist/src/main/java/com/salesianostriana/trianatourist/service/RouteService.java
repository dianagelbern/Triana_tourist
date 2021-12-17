package com.salesianostriana.trianatourist.service;

import com.salesianostriana.trianatourist.model.Route;
import com.salesianostriana.trianatourist.repository.RouteRepository;
import com.salesianostriana.trianatourist.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class RouteService extends BaseService<Route, Long, RouteRepository> {
}
