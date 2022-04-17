public class Base36 {

    public static void main(String[] args) {
        String s = add36Strings("1b", "2x");
        System.out.println(s);
    }

    private static char getChar(int num) {
        if (num >= 0 && num <= 9) return (char) ('0' + num);
        else return (char) ('a' + num - 10);
    }

    private static int getNum(char c) {
        if (c >= '0' && c <= '9') return c - '0';
        else return c - 'a' + 10;
    }

    private static String add36Strings(String s1, String s2) {
        int i = s1.length() - 1, j = s2.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int n1 = i >= 0? getNum(s1.charAt(i)): 0;
            int n2 = j >= 0? getNum(s2.charAt(j)): 0;
            int temp = n1 + n2 + carry;
            sb.append(getChar(temp % 36));
            carry = temp / 36;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }
}