package org.example;

import static org.example.ComparadorDeTexto.compareTexts;

public class Main {
    public static void main(String[] args) {
        String text1Path = "C:\\Users\\gonza\\OneDrive\\Escritorio\\Algoritmos y Estructuras de datos\\Comparador_de_Textos\\src\\main\\java\\org\\example\\texto1.txt";
        String text2Path = "C:\\Users\\gonza\\OneDrive\\Escritorio\\Algoritmos y Estructuras de datos\\Comparador_de_Textos\\src\\main\\java\\org\\example\\texto2.txt";
        String commonWordsPath = "common_words.txt";
        String differentWordsPath = "different_words.txt";

        compareTexts(text1Path, text2Path, commonWordsPath, differentWordsPath);
    }
}