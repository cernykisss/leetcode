import java.util.Stack;

public class SimpleCalculator {

//    (1+(4+5+2)-3)+(6+8)
    public int calculateWithBracket(String s) {
        Stack<Integer> ops = new Stack<>();
        int res = 0, op = 1, num = 0;
        ops.push(1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) num = num * 10 + c - '0';
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                res += op * num;
                num = 0;
                if (c == '+') op = ops.peek();
                else if (c == '-') op = -ops.peek();
                else if (c == '(') ops.push(op);
                else if (c == ')') ops.pop();
            }
        }
        return res;
    }

//    3 + 2 * 2
    public int calculateWithMultiplier(String s) {
        Stack<Integer> stack = new Stack<>();
        char preChar = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) num = num * 10 + c - '0';
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (preChar == '+') stack.push(num);
                else if (preChar == '-') stack.push(-num);
                else if (preChar == '*') stack.push(stack.pop() * num);
                else if (preChar == '/') stack.push(stack.pop() / num);
                preChar = c;
                num = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    public String addString(String s1, String s2) {
        StringBuilder sb = new StringBuilder();
        int i = s1.length() - 1, j = s2.length() - 1, carry = 0;
        while (i > -1 || j > -1) {
            int n1 = i > -1? s1.charAt(i) - '0': 0;
            int n2 = j > -1? s2.charAt(j) - '0': 0;
            int sum = n1 + n2 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
            i--;
            j--;
        }
        if (carry == 1) sb.append("1");
        return sb.reverse().toString();
    }

    public String multiplyString(String s1, String s2) {
        if (s1.equals("0") || s2.equals("0")) return "0";
        int len1 = s1.length(), len2 = s2.length();
        int[] proArr = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            int x = s1.charAt(i) - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int y = s2.charAt(j) - '0';
                proArr[i + j + 1] += x * y;
            }
        }
        for (int i = proArr.length - 1; i > 0; i--) {
            proArr[i - 1] += proArr[i] / 10;
            proArr[i] %= 10;
        }
        int begin = proArr[0] == 0? 1: 0;
        StringBuilder sb = new StringBuilder();
        for (int i = begin; i < proArr.length; i++) {
            sb.append(proArr[i]);
        }
        return sb.toString();
    }
}
