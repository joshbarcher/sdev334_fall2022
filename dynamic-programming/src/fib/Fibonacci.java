package fib;

public class Fibonacci
{
    private int[] fibNums;

    //this returns the nth fibonacci number
    public int fib(int n)
    {
        fibNums = new int[n + 1];
        return recFib(n);
    }

    //this returns the nth fibonacci number
    private int recFib(int n)
    {
        //base cases
        if (n == 0 || n == 1)
        {
            return n;
        }
        else
        {
            return findFib(n - 1) + findFib(n - 2);
        }
    }

    //this will return a saved fib number, or if the number
    //has not been found yet, it will calculate the number
    private int findFib(int n)
    {
        //haven't found this number yet?
        if (fibNums[n] == 0)
        {
            //calculate and store the fib number
            fibNums[n] = recFib(n);
        }
        //we have the number at this point
        return fibNums[n];
    }
}
