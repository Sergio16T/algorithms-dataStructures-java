package Java_Algo;
import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

    private HashMap<Character, Character> mappings;

    public ValidParentheses() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put('(', ')');
        this.mappings.put('{', '}');
        this.mappings.put('[', ']');
    }

    public Boolean isValid(String s) {
        if (s == "") {
            return true;
        }

        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (this.mappings.containsKey(ch)) {
                stack.push(this.mappings.get(ch));
            } else if (ch != stack.pop()) {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses valid = new ValidParentheses();
        String string = "({})";
        String string2 = "()[]{}";
        String string3 = "[(({]";
        System.out.println(valid.isValid(string));
        System.out.println(valid.isValid(string2));
        System.out.println(valid.isValid(string3));

    }
}



// solution with opposite map key value pairs
class Solution {

    // Hash table that takes care of the mappings.
    private HashMap<Character, Character> mappings;

    // Initialize hash map with mappings. This simply makes the code easier to read.
    public Solution() {
        this.mappings = new HashMap<Character, Character>();
        this.mappings.put(')', '(');
        this.mappings.put('}', '{');
        this.mappings.put(']', '[');
    }

    public boolean isValid(String s) {

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i); // could also use s[i];

        // If the current character is a closing bracket.
        if (this.mappings.containsKey(c)) {

            // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
            char topElement = stack.empty() ? '#' : stack.pop();

            // If the mapping for this bracket doesn't match the stack's top element, return false.
            if (topElement != this.mappings.get(c)) {
            return false;
            }
        } else {
            // If it was an opening bracket, push to the stack.
            stack.push(c);
        }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
}