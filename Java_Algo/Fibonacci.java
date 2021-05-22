package Java_Algo;

import java.util.HashMap;
import java.util.function.Function;

public class Fibonacci {
    private HashMap<Integer, Integer> map = new HashMap<>();

    public static Integer recursive(Integer n) {
        if (n < 2) {
            return n;
        }
        return recursive(n - 1) + recursive(n - 2);
    }

    // Memoization with Higher Order Function
    public Function<Integer, Integer> memoization() {
        return (Integer n) -> {
            if (map.containsKey(n)) {
                return map.get(n);
            } else if (n < 2) {
                map.put(n, n);
            } else {
                Integer num = this.memoization().apply(n - 1) + this.memoization().apply(n -2);
                map.put(n, num);
            }
            return map.get(n);
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

        // Access via HOF example
        // Integer result = this.memoization().apply(n);
        // System.out.println("Access method of this class via this: " + result);

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
        Integer result4 = fibo.getMemoizedResult(6);
        // Example with method that returns a functional interface from which we can invoke apply to apply arguments.
        Integer resultHOF = fibo.memoization().apply(4);
        Integer resultHOF2 = fibo.memoization().apply(6);

        System.out.println(result);
        System.out.println(memoizedResult);
        System.out.println(result3);
        System.out.println(result4);
        System.out.println(resultHOF);
        System.out.println(resultHOF2);
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