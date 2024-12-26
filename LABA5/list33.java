import java.util.ArrayList;
import java.util.List;

public class list33 {

    public static <T extends Comparable<T>> List<T> mergeSortedLists(List<T> list1, List<T> list2) {
        if (list1 == null) {
            return list2; // Если первый список null, то возвращаем второй
        }
        if (list2 == null) {
            return list1; // Если второй список null, то возвращаем первый
        }

        List<T> mergedList = new ArrayList<>();
        int i = 0; // Индекс для list1
        int j = 0; // Индекс для list2

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).compareTo(list2.get(j)) <= 0) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        // Добавляем оставшиеся элементы из list1 (если есть)
        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }

        // Добавляем оставшиеся элементы из list2 (если есть)
        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;
    }
}