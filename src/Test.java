
import java.util.*;

public class Test {
    public static void main(String[] args) {
        System.out.println(isPalindrome("da,d."));
        System.out.println(isPalindrome("Straw? No, too stupid a fad. I put soot on warts."));
    }

    private static boolean isPalindrome(String phrase) {
        phrase = phrase.toLowerCase();
        char[] chars = phrase.toCharArray();
        Queue<Character> charQueue = new LinkedList<>();
        Stack<Character> charStack = new Stack<>();
        for (char character : chars) {
            if (Character.isLetter(character)) {
                charQueue.offer(character);
                charStack.push(character);
            }
        }

        boolean palindrome = true;
        while (!charStack.isEmpty() && !charQueue.isEmpty() && palindrome) {
            if (charQueue.poll() != charStack.pop()) {
                palindrome = false;
            }
        }
        return palindrome;
    }



}
