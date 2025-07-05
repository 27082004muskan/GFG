class Solution {
    public int countMinReversals(String s) {
        int n = s.length();
        if (n % 2 != 0) return -1;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch == '{') {
                stack.push(ch);
            } else {
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        int open = 0, close = 0;
        while (!stack.isEmpty()) {
            char top = stack.pop();
            if (top == '{') open++;
            else close++;
        }

        // You wanted Math.ceil, so here it is:
        if ((open + close) % 2 != 0) return -1; // Safety check
        int ans = (int)(Math.ceil(open / 2.0) + Math.ceil(close / 2.0));

        return ans;
    }
}
