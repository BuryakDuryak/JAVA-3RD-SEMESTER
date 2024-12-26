import java.util.ArrayList;
import java.util.List;

public class list33 {

    public static <T extends Comparable<T>> List<T> mergeSortedLists(List<T> list1, List<T> list2) {
        if (list1 == null) {
            return list2; 
        }
        if (list2 == null) {
            return list1; 
        }

        List<T> mergedList = new ArrayList<>();
        int i = 0; 
        int j = 0; 

        while (i < list1.size() && j < list2.size()) {
            if (list1.get(i).compareTo(list2.get(j)) <= 0) {
                mergedList.add(list1.get(i));
                i++;
            } else {
                mergedList.add(list2.get(j));
                j++;
            }
        }

        while (i < list1.size()) {
            mergedList.add(list1.get(i));
            i++;
        }

        while (j < list2.size()) {
            mergedList.add(list2.get(j));
            j++;
        }

        return mergedList;
    }
}
