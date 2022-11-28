package test;

import fib.Fibonacci;
import fib.FibonacciAlternative;

public class Main
{
    public static void main(String[] args)
    {
        FibonacciAlternative fibonacci = new FibonacciAlternative();

        System.out.println("fib(0): " + fibonacci.fib(0));
        System.out.println("fib(1): " + fibonacci.fib(1));
        System.out.println("fib(5): " + fibonacci.fib(5));
        System.out.println("fib(7): " + fibonacci.fib(7));
        System.out.println("fib(8): " + fibonacci.fib(8));
        System.out.println("fib(10): " + fibonacci.fib(10));
        System.out.println("fib(20): " + fibonacci.fib(20));
        System.out.println("fib(40): " + fibonacci.fib(40));
        System.out.println("fib(80): " + fibonacci.fib(80));
    }
}