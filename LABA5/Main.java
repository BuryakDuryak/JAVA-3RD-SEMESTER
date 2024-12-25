import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static java.lang.System.out;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        out.println("Введите номер задания: ");
        int n = in.nextInt();
        in.nextLine();
        switch(n) {
            case 11:
                Decimal decimal1 = new Decimal(1, 2);
                Decimal decimal2 = new Decimal(-1, -2);

                out.println(decimal1 + " equals " + decimal2 + " : " + decimal1.equals(decimal2)); // true

                DecimalCache decimalCache1 = new DecimalCache(decimal1);
                out.println(decimalCache1.getDoubleValue());
                out.println(decimalCache1.getDoubleValue());
                out.println(decimalCache1.getDoubleValue());
                out.println(decimalCache1.getDoubleValue());

                decimalCache1.setNumeratorDenominator(3,5);
                out.println(decimalCache1.getDoubleValue());
                out.println(decimalCache1.getDoubleValue());
                out.println(decimalCache1.getDoubleValue());

                out.println(decimal1 + " equals " + decimal2 + " : " + decimal1.equals(decimal2)); // false

                break;
            case 21:
                MeowForAll cats = new MeowForAll();
                Cat barsik = new Cat("Барсик");
                Cat murzik = new Cat("Мурзик");

                MeowManager barsikManager = new MeowManager(barsik, cats);
                MeowManager murzikManager = new MeowManager(murzik, cats);

                MeowManager.meowsCare(barsikManager); // Мяукает 5 раз

                out.println(barsik + ", количество мяуканий: " + barsikManager.getMeowCount());
                out.println(murzik + ", количество мяуканий: " + murzikManager.getMeowCount());

                MeowForAll.makeAllCatsMeow(cats);

                out.println(barsik + ", количество мяуканий: " + barsikManager.getMeowCount());
                out.println(murzik + ", количество мяуканий: " + murzikManager.getMeowCount());

                break;
            case 48:
                String filePath = "input.txt";

                Map<Integer, List<String>> participants = new HashMap<>();

                try (Scanner scanner = new Scanner(new FileReader(filePath))) {
                    int n48 = Integer.parseInt(scanner.nextLine());

                    for (int i = 0; i < n48; i++) {
                        String line = scanner.nextLine();
                        String[] parts = line.split(" ");
                        String lastName = parts[0];
                        String firstName = parts[1];
                        int scores = 0;
                        for (int j = 2; j < 6; j++) {
                            scores += Integer.parseInt(parts[j]);
                        }
                        String fullName = lastName + " " + firstName;
                        participants.computeIfAbsent(scores, k -> new ArrayList<>()).add(fullName);
                    }

                } catch (FileNotFoundException e) {
                    System.err.println("Ошибка: Файл " + filePath + " не найден!");
                    return;
                } catch (NumberFormatException e){
                    System.err.println("Ошибка: Неверный формат числовых данных в файле!");
                    return;
                } catch (Exception e) {
                    System.err.println("Произошла ошибка при чтении файла: " + e.getMessage());
                    return;
                }


                List<Integer> scoresSorted = new ArrayList<>(participants.keySet());
                scoresSorted.sort(Collections.reverseOrder());

                int bestScores;
                List<List<String>> bestStudents = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    bestScores = scoresSorted.get(i);
                    bestStudents.add(participants.get(bestScores));
                }

                out.println("Лучшие ученики: ");
                for (List<String> student : bestStudents) {
                    out.println(student);
                }

                break;
            case 53:
                String filename = "problema.txt";

                set53.UniqueConsonants(filename);
                break;
            case 63:
                Queue<Integer> queue1 = new LinkedList<>();
                queue1.add(1);
                queue1.add(2);
                queue1.add(3);
                queue1.add(4);
                queue1.add(1);
                out.println("Есть ли в очереди 1 идущие подряд равные элементы? - " + queue63.hasConsecutiveEquals(queue1)); // true


                Queue<Double> queue2 = new LinkedList<>();
                queue2.add(1.1);
                queue2.add(2.5);
                queue2.add(3.5);
                queue2.add(4.0);
                queue2.add(1.1);
                out.println("Есть ли в очереди 2 идущие подряд равные элементы? - " + queue63.hasConsecutiveEquals(queue2)); // false

                Queue<String> queue3 = new LinkedList<>();
                queue3.add("BOB");
                queue3.add("BOB");
                out.println("Есть ли в очереди 3 идущие подряд равные элементы? - " + queue63.hasConsecutiveEquals(queue3)); //true

                Queue<Integer> queue4 = new LinkedList<>();
                out.println("Есть ли в очереди 4 идущие подряд равные элементы? - " + queue63.hasConsecutiveEquals(queue4)); // false (пустая очередь)

                Queue<Integer> queue5 = new LinkedList<>();
                queue5.add(5);
                out.println("Есть ли в очереди 5 идущие подряд равные элементы? - " + queue63.hasConsecutiveEquals(queue5)); // false (один элемент)
                break;
            case 71:
                List<Point> points = Arrays.asList(
                        new Point(1.0, 2.5),
                        new Point(4.0, -6.0),
                        new Point(1.0, 2.5),
                        new Point(7.5, -1.0),
                        new Point(4.0, -6.0),
                        new Point(2.0,-3),
                        new Point(4, 4)
                );

                out.println("Изначальный список точек: ");
                for (Point point : points) {
                    out.println(point);
                };

                Polyline polyline = points.stream()
                        .distinct() // Убираем повторяющиеся элементы
                        .sorted(Comparator.comparingDouble(Point::getX))  // Сортируем по X
                        .map(p -> new Point(p.getX(), Math.abs(p.getY())))  // Делаем Y положительным
                        .distinct()
                        .collect(Collectors.collectingAndThen(Collectors.toList(),
                                list -> new Polyline(list.toArray(new Point[0])))); // Собираем в Polyline

                out.println("Полученная линия: \n" + polyline); // Вывод полученной ломаной
                break;
            case 72:
                String filePath72 = "people.txt"; // Замените на путь к вашему файлу

                try {
                    Map<Integer, List<String>> groupedPeople = Files.lines(Paths.get(filePath72))
                            .map(String::trim)  // Убираем пробелы в начале и в конце строки
                            .filter(line -> !line.isEmpty()) // Фильтруем пустые строки
                            .map(line -> {
                                Pattern pattern = Pattern.compile("([^:]+):(\\d+)");
                                Matcher matcher = pattern.matcher(line);
                                if (matcher.find()) {
                                    return new String[] {matcher.group(1), matcher.group(2)};
                                } else {
                                    return null; // Отфильтруем строки без номеров на следующем шаге
                                }
                            })
                            .filter(Objects::nonNull) // Фильтруем строки без номеров
                            .map(parts -> {
                                String name = parts[0];
                                name = name.toLowerCase();
                                if (name.length() > 0){
                                    name = name.substring(0,1).toUpperCase() + name.substring(1);
                                }
                                int number = Integer.parseInt(parts[1]);
                                return new Object[] {number, name};
                            })
                            .collect(Collectors.groupingBy(
                                    parts -> (Integer) parts[0],
                                    Collectors.mapping(parts -> (String) parts[1], Collectors.toList())
                            ));

                    out.println(groupedPeople);

                } catch (IOException e) {
                    System.err.println("Ошибка при чтении файла: " + e.getMessage());
                }
            default:
                throw new IllegalStateException("Unexpected value: " + n);
        }

    }
}
