import java.util.Stack;

class StockSpanner {

    // Stack storing pairs: {price, span}
    private Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;

        // Pop all prices less than or equal to current price
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1]; // add previous span
        }

        // Push current price and its span onto the stack
        stack.push(new int[]{price, span});

        return span;
    }
}

/**
 * Example usage:
 * StockSpanner obj = new StockSpanner();
 * System.out.println(obj.next(100)); // 1
 * System.out.println(obj.next(80));  // 1
 * System.out.println(obj.next(60));  // 1
 * System.out.println(obj.next(70));  // 2
 * System.out.println(obj.next(60));  // 1
 * System.out.println(obj.next(75));  // 4
 * System.out.println(obj.next(85));  // 6
 */
