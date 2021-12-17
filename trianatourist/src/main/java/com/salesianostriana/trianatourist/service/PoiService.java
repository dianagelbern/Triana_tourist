package com.salesianostriana.trianatourist.service;

import com.salesianostriana.trianatourist.model.Poi;
import com.salesianostriana.trianatourist.repository.PoiRepository;
import com.salesianostriana.trianatourist.service.base.BaseService;
import org.springframework.stereotype.Service;

@Service
public class PoiService extends BaseService<Poi, Long, PoiRepository> {
}
