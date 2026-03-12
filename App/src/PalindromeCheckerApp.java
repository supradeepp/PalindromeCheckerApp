import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    public static boolean twoPointerCheck(String input) {

        int start = 0;
        int end = input.length() - 1;

        while (start < end) {

            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }

            start++;
            end--;
        }

        return true;
    }

    public static boolean stackCheck(String input) {

        Stack<Character> stack = new Stack<>();

        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        String reversed = "";

        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }

        return input.equals(reversed);
    }

    public static boolean dequeCheck(String input) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            deque.addLast(c);
        }

        while (deque.size() > 1) {

            char first = deque.removeFirst();
            char last = deque.removeLast();

            if (first != last) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {

        String input = "madam";

        long start1 = System.nanoTime();
        boolean result1 = twoPointerCheck(input);
        long end1 = System.nanoTime();

        long start2 = System.nanoTime();
        boolean result2 = stackCheck(input);
        long end2 = System.nanoTime();

        long start3 = System.nanoTime();
        boolean result3 = dequeCheck(input);
        long end3 = System.nanoTime();

        System.out.println("Two Pointer Result: " + result1);
        System.out.println("Execution Time: " + (end1 - start1) + " ns");

        System.out.println("Stack Result: " + result2);
        System.out.println("Execution Time: " + (end2 - start2) + " ns");

        System.out.println("Deque Result: " + result3);
        System.out.println("Execution Time: " + (end3 - start3) + " ns");
    }
}