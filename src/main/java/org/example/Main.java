package org.example;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.example.ComparadorDeTexto.compararTextos;
import static org.example.ComparadorDeTexto.compareTexts;

public class Main {
    public static void main(String[] args) {
        String archivo1 = "src\\main\\java\\org\\example\\texto1.txt";
        String archivo2 = "src\\main\\java\\org\\example\\texto2.txt";

        String[] lineasAchivo1 = ManejadorArchivosGenerico.leerArchivo(archivo1, true);
        String[] lineasAchivo2 = ManejadorArchivosGenerico.leerArchivo(archivo2, true);

        for (int i = 0; i < lineasAchivo1.length; i++) {
            lineasAchivo1[i] = lineasAchivo1[i].toLowerCase().replaceAll("[.,/!()$%#%&?¡¿'´]", "");
        }

        for (int i = 0; i < lineasAchivo2.length; i++) {
            lineasAchivo2[i] = lineasAchivo2[i].toLowerCase().replaceAll("[.,/!()$%#%&?¡¿'´]", "");
        }

        String[] listaLineasArchivo1 = lineasAchivo1[0].split(" ");
        String[] listaLineasArchivo2 = lineasAchivo2[0].split(" ");

        Set<String> set1 = Stream.of(listaLineasArchivo1)
                .map(String::toLowerCase)
                .collect(Collectors.toCollection(TreeSet::new));

        Set<String> set2 = Stream.of(listaLineasArchivo2)
                .map(String::toLowerCase)
                .collect(Collectors.toCollection(TreeSet::new));

        compararTextos(listaLineasArchivo1, listaLineasArchivo2);
        compareTexts(set1, set2);
    }

}