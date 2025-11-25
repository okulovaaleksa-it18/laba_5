import java.io.*;
import java.util.*;

public class WordsChars {
    
    public static Set<Character> getCharsFromEvenWords(String fileName) {
        Set<Character> charsSet = new HashSet<>(); // множество символов

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            int wordCounter = 0; // счетчик слов

            while ((line = br.readLine()) != null) {
                // Разбиваем строку на слова
                String[] words = line.split("\\s+");

                for (String word : words) {
                    wordCounter++;
                    // проверка что слово четное
                    if (wordCounter % 2 == 0) {
                        for (char c : word.toCharArray()) {
                            charsSet.add(c);
                        }
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Ошибка при чтении файла: " + e.getMessage());
        }

        return charsSet;
    }

    //вывод множества 
    public static void printChars(Set<Character> charsSet) {
        System.out.println("Символы из слов с чётными номерами:");
        for (char c : charsSet) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}

