package Java_Algo;

import java.util.HashMap;
import java.util.function.Function;

public class Fibonacci {

    public static Integer recursive(Integer n) {
        if (n < 2) {
            return n;
        }
        return recursive(n - 1) + recursive(n - 2);
    }

    // Memoization with Higher Order Function
    public Function<Integer, Integer> memoization() {
        HashMap<Integer, Integer> mapping = new HashMap<>();

        return (Integer n) -> {
            if (mapping.containsKey(n)) {
                return mapping.get(n);
            } else if (n < 2) {
                mapping.put(n, n);
            } else {
                Integer num = recursive(n - 1) + recursive(n -2);
                mapping.put(n, num);
            }
            return mapping.get(n);
        };
    }

    // Inner Class Example
    private static class Memoization {
        HashMap<Integer, Integer> mapping = new HashMap<>();

        public Integer recursive(Integer n) {
            if (mapping.containsKey(n)) {
                return mapping.get(n);
            } else if (n < 2) {
                mapping.put(n, n);
            } else {
                Integer num = recursive(n - 1) + recursive(n -2);
                mapping.put(n, num);
            }
            return mapping.get(n);
        }
    }

    public Integer getMemoizedResult(Integer n) {
        // Initalize inner class Memoization to access inner class method `recursive`
        Memoization memo = new Memoization();
        Integer memoizedResult = memo.recursive(n);

        Integer result = this.memoization().apply(n);
        System.out.println("Access method of this class via this: " + result);

        return memoizedResult;
    }

    public static void main(String[] args) {
        // Example with static method
        Integer result = Fibonacci.recursive(4);

        // Example with Inner Class
        Memoization memo = new Memoization();
        Integer memoizedResult = memo.recursive(4);

        // Example initializing Fibonacci and accessing result via public methods of Fibonacci class
        Fibonacci fibo = new Fibonacci();
        Integer result3 = fibo.getMemoizedResult(4);
        // Example with method that returns a functional interface from which we can invoke apply to apply arguments.
        Integer resultHOF = fibo.memoization().apply(4);

        System.out.println(result);
        System.out.println(memoizedResult);
        System.out.println(result3);
        System.out.println(resultHOF);
    }
}

// Sample class using Fibonacci CLass
class useFibo {

    public static void main(String[] args) {
        Integer result = Fibonacci.recursive(6);

        Fibonacci fibo = new Fibonacci();
        Integer memoResult = fibo.getMemoizedResult(6);

        System.out.println(result); // 8
        System.out.println(memoResult); // 8
    }

}