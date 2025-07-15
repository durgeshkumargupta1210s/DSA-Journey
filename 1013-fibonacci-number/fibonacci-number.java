class Solution {
    public int fib(int n) {
        return fibonacci(n);
        
    }
    public static int fibonacci(int n){
        if(n==0 || n==1){
            return n;
        }
       int  num1=fibonacci(n-1);
       int  num2=fibonacci(n-2);
        return num1+num2;
    }
}