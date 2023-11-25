package org.example;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ComparadorDeTexto /*implements ICompradorDeTexto*/{

    public static void compararTextos(String[] text1, String[] text2) {
        Set<String> commonWords = new TreeSet<>();

        for (String word1 : text1) {
            for (String word2 : text2) {
                if (word1.hashCode() == word2.hashCode()) {
                    commonWords.add(word1);
                }
            }
        }

        for (String word2 : text2) {
            for (String word1 : text1) {
                if (word2.toLowerCase().hashCode() == word1.toLowerCase().hashCode()) {
                    commonWords.add(word2);
                }
            }
        }

        Set<String> differentWords = new TreeSet<>((List.of(text1)));
        differentWords.addAll(List.of(text2));

        differentWords.removeAll(commonWords);


        ManejadorArchivosGenerico.escribirArchivo2("src\\main\\salidaComunString.txt", commonWords);
        ManejadorArchivosGenerico.escribirArchivo2("src\\main\\salidaDiferenteString.txt", differentWords);
    }

    public static void compareTexts(Set<String> set1, Set<String> set2) {

        Set<String> commonWords = new TreeSet<>(set1);
        commonWords.retainAll(set2);

        Set<String> differentWords = new TreeSet<>(set1);
        differentWords.addAll(set2);
        differentWords.removeAll(commonWords);

        ManejadorArchivosGenerico.escribirArchivo2("src\\main\\salidaComunSet.txt", commonWords);
        ManejadorArchivosGenerico.escribirArchivo2("src\\main\\salidaDiferenteSet.txt", differentWords);
    }

}
