package com.Entrega1.Ces2.Controlador;

import com.Entrega1.Ces2.Modelo.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ArtistaController {

    @GetMapping("/")
    public String index(Model model) {

        List<IArtista> artistas = new ArrayList<>();

        artistas.add(new Pintor(new Obra("Girasoles", "Vincent van Gogh", 1888)));
        artistas.add(new Pintor(new Obra("La noche estrellada", "Vincent van Gogh", 1889)));
        artistas.add(new Pintor(new Obra("El grito", "Edvard Munch", 1893)));

        artistas.add(new Escultor(new Obra("El pensador", "Auguste Rodin", 1902)));
        artistas.add(new Escultor(new Obra("La piedad", "Miguel Ángel", 1499)));
        artistas.add(new Escultor(new Obra("David", "Miguel Ángel", 1504)));

        artistas.add(new Musico(new Obra("Quinta sinfonía", "Ludwig van Beethoven", 1808)));
        artistas.add(new Musico(new Obra("Para Elisa", "Ludwig van Beethoven", 1810)));
        artistas.add(new Musico(new Obra("Réquiem", "Wolfgang Amadeus Mozart", 1791)));

        model.addAttribute("artistas", artistas);
        return "index";
    }
}
