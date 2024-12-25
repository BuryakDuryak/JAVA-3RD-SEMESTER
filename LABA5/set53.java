import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;

public class set53 {
    public static void UniqueConsonants(String filePath) {
        Map<Character, Integer> consonantCounts = new HashMap<>();
        Set<Character> allConsonants = new HashSet<>();
        try (Scanner scanner = new Scanner(new FileReader(filePath))) {
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase();
                for (char c : word.toCharArray()) {
                    if ("бвгджзклмнпрстфхцчшщ".contains(String.valueOf(c))) {
                        allConsonants.add(c);
                        consonantCounts.put(c, consonantCounts.getOrDefault(c, 0) + 1);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка: Файл " + filePath + " не найден!");
        } catch (Exception e) {
            System.err.println("Произошла ошибка при чтении файла: " + e.getMessage());
        }

        Set<Character> uniqueConsonants = new HashSet<>();
        for (char consonant : allConsonants) {
            if (consonantCounts.get(consonant) == 1){
                uniqueConsonants.add(consonant);
            }
        }

        System.out.println("Согласные буквы, встречающиеся ровно в одном слове:");
        for (char c : uniqueConsonants) {
            System.out.print(c + " ");
        }
        System.out.println();
    }
}


