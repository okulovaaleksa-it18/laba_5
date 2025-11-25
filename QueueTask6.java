import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueTask6 {
    
    public static <T> void printQueueReversed(Queue<T> queue) {
        Stack<T> stack = new Stack<>();
        for (T element : queue) {
            stack.push(element);
        }

        System.out.println("Элементы очереди в обратном порядке:");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
    public static Queue<Integer> createSampleQueue() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        return queue;
    }
}
