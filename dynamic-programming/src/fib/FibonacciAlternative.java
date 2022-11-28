package fib;

public class FibonacciAlternative
{
    public int fib(int n)
    {
        if (n <= 1) //base cases
        {
            return n;
        }

        int first = 0;  //fib(0) = 0
        int second = 1; //fib(1) = 1
        int sum = 0;

        for (int i = 2; i <= n; i++)
        {
            //get the next number
            sum = second + first;

            //adjust our temporary variables
            first = second;
            second = sum;
        }

        return sum;
    }
}
