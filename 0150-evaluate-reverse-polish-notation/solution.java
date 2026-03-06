class Solution {
    public int evalRPN(String[] tokens) {
                Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {

            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                // Pop two operands from stack
                int b = stack.pop(); // second operand
                int a = stack.pop(); // first operand
                int result = 0;

                switch (token) {
                    case "+":
                        result = a + b;
                        break;
                    case "-":
                        result = a - b;
                        break;
                    case "*":
                        result = a * b;
                        break;
                    case "/":
                        result = a / b; // integer division, truncates toward zero
                        break;
                }

                stack.push(result); // push the result back
            } else {
                // Token is a number
                stack.push(Integer.parseInt(token));
            }
        }

        // The final result is the only element left in the stack
        return stack.pop();
        
        
    }
}
