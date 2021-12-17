package com.salesianostriana.trianatourist;

import com.salesianostriana.trianatourist.model.Category;
import com.salesianostriana.trianatourist.model.Poi;
import com.salesianostriana.trianatourist.model.Route;
import com.salesianostriana.trianatourist.service.CategoryService;
import com.salesianostriana.trianatourist.service.PoiService;
import com.salesianostriana.trianatourist.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class InitData {

    private final PoiService poiService;
    private final CategoryService categoryService;
    private final RouteService routeService;

    @PostConstruct
    public void prueba(){

        List<Category> cat = List.of(
                Category.builder()
                        .name("Categoria 1").build(),
                Category.builder()
                        .name("Cattegoria 2").build()
        );

        categoryService.saveAll(cat);

        Category c1 = Category.builder().name("Categoria 3").build();

        categoryService.save(c1);

        List<Poi> pois = List.of(

                Poi.builder()
                        .name("Sitio guapardo")
                        .location("Triana")
                        .descripcion("Un sitio bastante perron")
                        .date(LocalDate.of(1990, 2, 20))
                        .coverPhoto("http//unafoto.jpg").build(),

                Poi.builder()
                        .name("Sitio guapardo 2")
                        .location("Toledo")
                        .descripcion("Un sitio interesante")
                        .date(LocalDate.of(1997, 2, 20))
                        .coverPhoto("http//unafoto.jpg")
                        .photo2("http/jfgnjgfd.com")
                        .photo3("hrrp://kjfdfjn.com")
                        .category(c1).build()



        );

        poiService.saveAll(pois);

        List<Route> ruta = List.of(
                Route.builder()
                        .name("aaa")
                        .steps(pois).build()
        );

        routeService.saveAll(ruta);



    }
}
