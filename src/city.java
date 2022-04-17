public class city {
    //dp + 递归
    static int solution(int X, int N){
        int resultn = recur(X, X + 1, N);

        return resultn  * 2;
    }

    static int recur(int X, int Y, int N) {
        if (N == 0) {
            if (Y == X) {
                return 1;
            } else {
                return 0;
            }
        }
        //处理循环
        int pre = Y - 1;
        if (pre < 0) {
            pre = 9;
        }
        int next = Y + 1;
        if (next > 9) {
            next = 0;
        }
        return recur(X, pre, N-1) + recur(X, next, N-1);
    }
    public static void main(String[] args) {
        int solution = solution(0, 3);
        System.out.println(solution);
    }
}