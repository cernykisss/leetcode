public class quanpailie {

    StringBuilder res;
    int count = 0, n;
    char[] num, loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String printNumbers(int n) {
        this.n = n;
        res = new StringBuilder();
        num = new char[n];
        dfs(0);
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    public void dfs(int x) {
        if (x == n) {
            res.append(String.valueOf(num) + ',');
            return;
        }
        for (char i: loop) {
            num[x] = i;
            dfs(x + 1);
        }
    }
}
