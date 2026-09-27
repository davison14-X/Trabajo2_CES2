package com.Entrega2.Ces2.Controlador;

import com.Entrega2.Ces2.Modelo.*;
import com.Entrega2.Ces2.Repositories.ArtistaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

import java.util.*;
import java.util.stream.Collectors;

@Controller
public class ArtistaController {

    @GetMapping("peticion1")
    public String peticion1(Model model) {
        List<IArtista> artistas = ArtistaRepository.getArtistas();

        String salida = artistas.stream()
                .map(IArtista::getNombre)
                .collect(Collectors.joining(", "));

        model.addAttribute("salida", salida);
        return "peticion1";
    }

    @GetMapping("peticion2")
    public String peticion2(Model model) {
        List<IArtista> artistas = ArtistaRepository.getArtistas();

        DoubleSummaryStatistics estadisticas = artistas.stream()
                .flatMap(a -> a.getObras().stream())
                .collect(Collectors.summarizingDouble(Obra::getAnio));

        model.addAttribute("conteo", estadisticas.getCount());
        model.addAttribute("sumatotal", estadisticas.getSum());
        model.addAttribute("promedio", estadisticas.getAverage());
        model.addAttribute("min", estadisticas.getMin());
        model.addAttribute("max", estadisticas.getMax());
        return "peticion2";
    }

    // Punto 3 - lista de autores de todas las obras (ejemplo: peticion18 clase2)
    @GetMapping("peticion3")
    public String peticion3(Model model) {
        List<IArtista> artistas = ArtistaRepository.getArtistas();

        List<String> autores = artistas.stream()
                .flatMap(a -> a.getObras().stream())
                .map(Obra::getAutor)
                .toList();

        model.addAttribute("autores", autores);
        return "peticion3";
    }

    // Punto 4 - anyMatch y noneMatch (ejemplo: peticion19 y peticion20 clase2)
    @GetMapping("peticion4")
    public String peticion4(Model model) {
        List<IArtista> artistas = ArtistaRepository.getArtistas();

        List<Obra> todasLasObras = artistas.stream()
                .flatMap(a -> a.getObras().stream())
                .toList();

        Boolean hayObraAntesDe1900 = todasLasObras.stream()
                .anyMatch(o -> o.getAnio() < 1900);

        Boolean hayObraDespuesDe1950 = todasLasObras.stream()
                .anyMatch(o -> o.getAnio() > 1950);

        Boolean ningunaDe2000 = todasLasObras.stream()
                .noneMatch(o -> o.getAnio() >= 2000);

        model.addAttribute("hayObraAntesDe1900", hayObraAntesDe1900);
        model.addAttribute("hayObraDespuesDe1950", hayObraDespuesDe1950);
        model.addAttribute("ningunaDe2000", ningunaDe2000);
        return "peticion4";
    }

    // Punto 5 - obra con mayor anio (ejemplo: peticion13 clase1)
    @GetMapping("peticion5")
    public String peticion5(Model model) {
        List<IArtista> artistas = ArtistaRepository.getArtistas();

        Optional<Obra> obraMasReciente = artistas.stream()
                .flatMap(a -> a.getObras().stream())
                .max(Comparator.comparingInt(Obra::getAnio));

        String salida = String.format("Obra más reciente: %s de %s (%d)",
                obraMasReciente.map(Obra::getNombre).orElse("Ninguna"),
                obraMasReciente.map(Obra::getAutor).orElse(""),
                obraMasReciente.map(Obra::getAnio).orElse(0)
        );

        model.addAttribute("salida", salida);
        return "peticion5";
    }
}
