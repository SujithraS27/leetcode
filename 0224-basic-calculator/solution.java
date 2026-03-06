class Solution {
    public int calculate(String s) {
        int res = 0;
        int num = 0;
        int sign = 1; // current sign
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+') {
                res += sign * num;
                num = 0;
                sign = 1;
            } else if (c == '-') {
                res += sign * num;
                num = 0;
                sign = -1;
            } else if (c == '(') {
                // Push current result and sign
                stack.push(res);
                stack.push(sign);
                res = 0;
                sign = 1;
            } else if (c == ')') {
                res += sign * num;
                num = 0;
                res *= stack.pop(); // previous sign
                res += stack.pop(); // previous result
            }
            // ignore spaces
        }

        res += sign * num; // add last number
        return res;
    }
}
