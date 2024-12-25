import java.util.LinkedList;
import java.util.Queue;

public class queue63 {
    public static <T> boolean hasConsecutiveEquals(Queue<T> queue) {
        if (queue == null || queue.size() < 2) {
            return false; // Недостаточно элементов для сравнения
        }
        System.out.println(queue);

        Queue<T> tempQueue = new LinkedList<>(queue);
        T firstElement = tempQueue.poll();
        T previousElement = firstElement;

        for (int i = 1; i < queue.size(); i++) {
            T currentElement = tempQueue.poll();
            if (currentElement.equals(previousElement)) {
                return true; // Нашли два соседних равных элемента
            }
            previousElement = currentElement;
        }
        // Сравниваем последний элемент с первым для кольцевого условия
        return previousElement.equals(firstElement);
    }
}