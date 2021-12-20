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


        Category conventos = Category.builder()
                .name("Conventos").build();

        Category rascacielos = Category.builder()
                .name("Rascacielos").build();
        Category arquitectonicos = Category.builder()
                .name("Arquitectónicos").build();
        categoryService.save(conventos);
        categoryService.save(rascacielos);
        categoryService.save(arquitectonicos);

        Category iglesias = Category.builder().name("Iglesias").build();

        categoryService.save(iglesias);

        List<Poi> pois = List.of(

                Poi.builder()
                        .name("Convento de las Mínimas")
                        .location("37.563936,-116.85123")
                        .descripcion("La actual iglesia, de los siglos XVII-XVIII, muestra una sola nave, bóveda de cañón con lunetos y arcos fajones trilobulados, y una bóveda semiesférica, sobre pechinas decoradas con un lucernario ochavado. En cabecera, una labor de hierro forjado, que incluye la propia estructura del púlpito, ornamenta el frente de su presbiterio elevado, antecediendo al retablo mayor de la iglesia, integrado por dos cuerpos y tres calles. A los pies, el coro se eleva sobre bóveda de arista. Junto a la sobria portada de piedra gris que aparece enmarcada en juegos de ladrillo visto y mampostería enlucida, se eleva, sobre un zócalo pétreo, su imponente torre de formas ochavadas.")
                        .date(LocalDate.of(1551, 2, 20))
                        .category(conventos)
                        .coverPhoto("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f9/Torre_convento_Archidona.jpg/280px-Torre_convento_Archidona.jpg")
                        .photo2("https://upload.wikimedia.org/wikipedia/commons/thumb/0/08/Convento_de_las_M%C3%ADnimas_%2828821857601%29.jpg/1200px-Convento_de_las_M%C3%ADnimas_%2828821857601%29.jpg")
                        .photo3("https://www.visitarsevilla.com/wp-content/uploads/2020/12/Minimas-Triana-retablo.jpg").build(),

                Poi.builder()
                        .name("Torre Sevilla")
                        .location("36.95015, 89.01767")
                        .descripcion("dentro del complejo Puerto Triana, primer rascacielos de la ciudad y el más alto de Andalucía con 180,5 metros")
                        .date(LocalDate.of(2016, 10, 13))
                        .coverPhoto("https://www.cctorresevilla.com/wp-content/uploads/sites/10/2021/10/AperturaSlider.jpg")
                        .photo2("https://www.cctorresevilla.com/wp-content/uploads/sites/10/2019/02/Home.jpg")
                        .photo3("https://www.ejeprime.com/files//fotos/varias%20y%20recursos/torre-sevilla-728.jpg")
                        .category(rascacielos).build(),
                Poi.builder()
                        .name("Puente de Isabel II")
                        .location("25.99578, -51.06482")
                        .descripcion("El Puente de Isabel II, conocido popularmente como Puente de Triana, es un puente situado en Sevilla. Une el centro de la ciudad con el barrio de Triana, cruzando el río Guadalquivir. Sustituyó en el siglo XIX a un viejo puente de barcas que existía en su lugar, constituyendo el puente de hierro más antiguo conservado en España")
                        .date(LocalDate.of(1852, 3, 19))
                        .coverPhoto("https://upload.wikimedia.org/wikipedia/commons/a/a0/Puente_de_triana_2013An010.jpg")
                        .photo2("https://cdn2.civitatis.com/espana/sevilla/guia/puente-triana.jpg")
                        .photo3("https://upload.wikimedia.org/wikipedia/commons/thumb/8/8d/Puente_de_triana_2017001.jpg/273px-Puente_de_triana_2017001.jpg")
                        .category(arquitectonicos).build(),
                Poi.builder()
                        .name("Iglesia de Santa Ana (Sevilla)")
                        .location("-39.34653, 56.20303")
                        .descripcion("La Real Parroquia de Santa Ana de Sevilla, es una iglesia parroquial de estilo gótico-mudéjar, declarada Bien de Interés Cultural, cuya construcción se inició a finales del siglo XIII. Se encuentra situada en el barrio de Triana. Es conocida popularmente como la Catedral de Triana.")
                        .date(LocalDate.of(1266, 7, 10))
                        .coverPhoto("https://i.bssl.es/porconocer/2020/04/SantaAna-exterior.jpg")
                        .photo2("https://www.visitarsevilla.com/wp-content/uploads/2014/02/Santa-Ana-Triana.jpg")
                        .photo3("https://i0.wp.com/zimmer-man.com/wp-content/uploads/2016/01/iglesia-santa-ana.jpg?fit=400%2C300")
                        .category(iglesias).build()
        );

        poiService.saveAll(pois);

        List<Route> ruta = List.of(
                Route.builder()
                        .name("Ruta religiosa")
                        .steps(pois).build()
        );

        routeService.saveAll(ruta);



    }
}
