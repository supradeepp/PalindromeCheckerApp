import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

interface PalindromeStrategy {
    boolean checkPalindrome(String input);
}

class StackStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String input) {

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
}

class DequeStrategy implements PalindromeStrategy {

    public boolean checkPalindrome(String input) {

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
}

public class  PalindromeCheckerApp{

    public static void main(String[] args) {

        String input = "madam";

        PalindromeStrategy strategy;

        // choose algorithm
        strategy = new StackStrategy();
        // strategy = new DequeStrategy();

        boolean result = strategy.checkPalindrome(input);

        if (result) {
            System.out.println(input + " is a Palindrome");
        } else {
            System.out.println(input + " is not a Palindrome");
        }
    }
}