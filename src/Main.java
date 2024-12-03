import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

import static java.lang.System.out;


public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        out.println("Введите номер задания: ");
        int n = in.nextInt();
        in.nextLine();
        switch(n) {
            case 11:
                out.println("1.1 Обобщенная коробка");
                Box<Integer> intBox = new Box<>();

                out.println("Заполните коробку: ");
                int content = in.nextInt();
                intBox.put(content);
                Integer value = processBox(intBox);
                break;
            case 12:
                out.println("1.1 Без Null");
                out.println("Создайте хранилище");
                out.println("Введите нужный тип данных (1 - int, 2 - string): ");
                int nn = in.nextInt();
                in.nextLine();
                switch (nn) {
                    case 1:
                        out.println("Введите содержимое коробки (для пустого значения введите пустую строку): ");
                        String input1 = in.nextLine();
                        try {
                            int inputInt2 = Integer.parseInt(input1);
                        } catch (NumberFormatException e) {
                            System.out.println("Неверный ввод. Пожалуйста, введите целое число.");
                        }

                        out.println("Введите альтернативное содержимое коробки (для пустого значения введите пустую строку): ");
                        String input2 = in.nextLine();
                        try {
                            int inputInt2 = Integer.parseInt(input2);
                        } catch (NumberFormatException e) {
                            System.out.println("Неверный ввод. Пожалуйста, введите целое число.");
                        }

                        Storage<Integer> intStorage = new Storage<>();
                        intStorage = new Storage<>(Integer.parseInt(input1), Integer.parseInt(input2));

                        int result1 = intStorage.getValue();
                        out.println("Результат: " + result1);
                        break;
                    case 2:
                        out.println("Введите содержимое коробки (для пустого значения введите пустую строку): ");
                        String str1 = in.nextLine();
                        if (str1.isEmpty()) str1 = null;

                        out.println("Введите альтернативное содержимое коробки (не может быть пустым): ");
                        String str2 = in.nextLine();
                        if (str2.isEmpty()) throw new IllegalArgumentException("Альтернативное содержимое не может быть пустым");

                        Storage<String> stringStorage= new Storage<>(str1, str2);

                        String result2 = stringStorage.getValue();
                        out.println("Результат: " + result2);
                        break;
                    default:
                        throw new IllegalArgumentException("Неверный ввод");
                }
                break;
            case 22:
                out.println("2.2 Поиск максимума");
                List<Box<? extends Number>> boxes = createBoxCollection();

                double maxValue = findMax(boxes);
                out.println("Наибольшее содержимое из коллекции коробок: " + maxValue);
                break;
            case 31:
                out.println("3.1 Функция");
                System.out.println("Введите строки для нахождения их длины (для завершения введите пустую строку):");
                List<String> inputStrings31 = new ArrayList<>();
                while (true) {
                    String input = in.nextLine();
                    if (input.isEmpty()) {
                        break;
                    }
                    inputStrings31.add(input);
                }
                List<Integer> lengths = transformList(inputStrings31, String::length);
                System.out.println("Длины строк: " + lengths);


                System.out.println("Введите числа для преобразования (для завершения введите пустую строку):");
                List<Integer> inputNumbers31 = new ArrayList<>();
                while (true) {
                    String input = in.nextLine();
                    if (input.isEmpty()) {
                        break;
                    }
                    try {
                        inputNumbers31.add(Integer.parseInt(input));
                    } catch (NumberFormatException e) {
                        System.out.println("Неверный ввод. Пожалуйста, введите целое число.");
                    }
                }
                List<Integer> absolutes = transformList(inputNumbers31, Math::abs);
                System.out.println("Модули чисел: " + absolutes);


                System.out.println("Введите массивы чисел для преобразования (для завершения введите пустую строку):");
                List<int[]> inputArrays31 = new ArrayList<>();
                while (true) {
                    System.out.println("Введите числа через пробел (для завершения введите пустую строку):");
                    String input = in.nextLine();
                    if (input.isEmpty()) {
                        break;
                    }
                    try {
                        String[] parts = input.split(" ");
                        int[] array = new int[parts.length];
                        for (int i = 0; i < parts.length; i++) {
                            array[i] = Integer.parseInt(parts[i]);
                        }
                        inputArrays31.add(array);
                    } catch (NumberFormatException e) {
                        System.out.println("Неверный ввод. Пожалуйста, введите числа через пробел.");
                    }
                }
                List<Integer> maxValues = transformList(inputArrays31, arr -> {
                    int max = Integer.MIN_VALUE;
                    for (int num : arr) {
                        max = Math.max(max, num);
                    }
                    return max;
                });
                System.out.println("Максимальные значения в массивах: " + maxValues);
                break;
            case 32:

                out.println("3.2 Фильтр");
                System.out.println("Введите строки для (строки размером меньше трёх символов будут удалены), для завершения введите пустую строку):");
                List<String> inputStrings32 = new ArrayList<>();
                while (true) {
                    String input = in.nextLine();
                    if (input.isEmpty()) {
                        break;
                    }
                    inputStrings32.add(input);
                }
                List<String> filteredStrings = filterList(inputStrings32, str -> str.length() >= 3);
                System.out.println("Отсортированные строки: " + filteredStrings);

                System.out.println("Введите числа для преобразования (для завершения введите пустую строку):");
                List<Integer> inputNumbers32 = new ArrayList<>();
                while (true) {
                    String input = in.nextLine();
                    if (input.isEmpty()) {
                        break;
                    }
                    try {
                        inputNumbers32.add(Integer.parseInt(input));
                    } catch (NumberFormatException e) {
                        System.out.println("Неверный ввод. Пожалуйста, введите целое число.");
                    }
                }
                List<Integer> filteredNumbers = filterList(inputNumbers32, num -> num <= 0);
                System.out.println("Отфильтрованные числа: " + filteredNumbers);

                List<int[]> inputArrays32 = new ArrayList<>();
                while (true) {
                    System.out.println("Введите числа через пробел (для завершения введите пустую строку):");
                    String input = in.nextLine();
                    if (input.isEmpty()) {
                        break;
                    }
                    try {
                        String[] parts = input.split(" ");
                        int[] array = new int[parts.length];
                        for (int i = 0; i < parts.length; i++) {
                            array[i] = Integer.parseInt(parts[i]);
                        }
                        inputArrays32.add(array);
                    } catch (NumberFormatException e) {
                        System.out.println("Неверный ввод. Пожалуйста, введите числа через пробел.");
                    }
                }
                List<int[]> filteredArrays = filterList(inputArrays32, arr -> {
                    for (int num : arr) {
                        if (num > 0) {
                            return false;
                        }
                    }
                    return true;
                });
                System.out.println("Filtered arrays: " + Arrays.toString(filteredArrays.toArray()));
            default:
                throw new IllegalStateException("Unexpected value: " + n);
        }
    }

    public static <T extends Number> T processBox(Box<T> box) {
        T item = box.get();
        out.println("Содержимое коробки: " + item);
        return item;
    }

    static List<Box<? extends Number>> createBoxCollection() {
        List<Box<? extends Number>> boxes = new ArrayList<>();
        Scanner in = new Scanner(System.in);

        boolean flag = true;
        while (flag) {
            out.println("Введите нужный тип данных (1 - int, 2 - float, 3 - double, 4 - long, 5 - short, 6 - byte): ");
            int nn = in.nextInt();
            switch(nn) {
                case 1:
                    out.println("Введите число для хранения в коробке: ");
                    int c1 = in.nextInt();
                    boxes.add(new Box<>(c1));
                    break;
                case 2:
                    out.println("Введите число для хранения в коробке: ");
                    float c2 = in.nextFloat();
                    boxes.add(new Box<>(c2));
                    break;
                case 3:
                    out.println("Введите число для хранения в коробке: ");
                    double c3 = in.nextDouble();
                    boxes.add(new Box<>(c3));
                    break;
                case 4:
                    out.println("Введите число для хранения в коробке: ");
                    long c4 = in.nextLong();
                    boxes.add(new Box<>(c4));
                    break;
                case 5:
                    out.println("Введите число для хранения в коробке: ");
                    short c5 = in.nextShort();
                    boxes.add(new Box<>(c5));
                    break;
                case 6:
                    out.println("Введите число для хранения в коробке: ");
                    byte c6 = in.nextByte();
                    boxes.add(new Box<>(c6));
                    break;
                default:
                    throw new IllegalArgumentException("Неподдерживаемый тип данных");
            }

            out.println("Хотите ли вы прекратить добавление коробок?(1 - да, 2 - нет) ");
            int flagCheck = in.nextInt();
            if (flagCheck == 1) flag = false;
            else if (flagCheck != 2) throw new IllegalStateException("Недопустимое значение: " + flagCheck);

        }
        return boxes;
    }

    static double findMax(List<Box<? extends Number>> boxes) { //метод для задания 2.2
        if (boxes == null || boxes.isEmpty()) {
            throw new IllegalArgumentException("Должна быть хотя бы одна коробка.");
        }

        double max = Double.NEGATIVE_INFINITY;

        for (Box<? extends Number> box : boxes) {
            if (box != null && box.getContent() != null) {
                max = Math.max(max, box.getContent().doubleValue());
            }
        }
        return max;
    }

    static <T,P> List<P> transformList(List<T> inputList, Function<T,P> transformer) {
        List<P> resultList = new ArrayList<>();
        for (T item : inputList) {
            resultList.add(transformer.apply(item));
        }
        return resultList;
    }

   public static <T> List<T> filterList(List<T> inputList, Predicate<T> filter) {
        List<T> resultList = new ArrayList<>();
        for (T item : inputList) {
            if (filter.test(item)) {
                resultList.add(item);
            }
        }
        return resultList;
    }

}
