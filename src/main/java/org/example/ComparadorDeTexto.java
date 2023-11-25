package org.example;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import org.example.ManejadorArchivosGenerico;

public class ComparadorDeTexto /*implements ICompradorDeTexto*/{

    public static void compareTexts(String text1Path, String text2Path, String commonWordsPath, String differentWordsPath) {
        Set<String> words1 = new HashSet<>();
        Set<String> words2 = new HashSet<>();

        try (String[] reader1 = ManejadorArchivosGenerico.leerArchivo(text1Path, false),
            String[] reader2 = ManejadorArchivosGenerico.leerArchivo(text2Path, false); {

            String line1;
            while ((line1 = reader1.readLine()) != null) {
                String[] lineWords = line1.split("\\s+");
                for (String word : lineWords) {
                    words1.add(word.toLowerCase());
                }
            }

            String line2;
            while ((line2 = reader2.readLine()) != null) {
                String[] lineWords = line2.split("\\s+");
                for (String word : lineWords) {
                    words2.add(word.toLowerCase());
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Set<String> commonWords = new TreeSet<>(words1);
        commonWords.retainAll(words2);

        Set<String> differentWords = new TreeSet<>(words1);
        differentWords.addAll(words2);
        differentWords.removeAll(commonWords);

        writeWordsToFile(commonWordsPath, commonWords);
        writeWordsToFile(differentWordsPath, differentWords);
    }

    public static void writeWordsToFile(String path, Set<String> words) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (String word : words) {
                writer.write(word);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
