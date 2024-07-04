package Silver1.baekjoon_1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    //[i][0] = red
    //[i][1] = green
    //[i][2] = blue
    private static int[][] Cost;
    private static int[][] DP;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        DP = new int[N][3];
        Cost = new int[N][3];

        //각 지점별 Cost 배열 초기화
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Cost[i][0] = Integer.parseInt(st.nextToken());
            Cost[i][1] = Integer.parseInt(st.nextToken());
            Cost[i][2] = Integer.parseInt(st.nextToken());
        }
        DP[0][0] = Cost[0][0];
        DP[0][1] = Cost[0][1];
        DP[0][2] = Cost[0][2];

        System.out.println(Math.min(dp(N - 1, 0), Math.min(dp(N - 1, 1), dp(N - 1, 2))));
    }

    private static int dp(int n, int color) {
        if (DP[n][color] == 0) {
            if (color == 0) {
                DP[n][color] = Math.min(dp(n - 1, 1), dp(n - 1, 2)) + Cost[n][color];
            } else if (color == 1) {
                DP[n][color] = Math.min(dp(n - 1, 0), dp(n - 1, 2)) + Cost[n][color];
            } else {
                DP[n][color] = Math.min(dp(n - 1, 0), dp(n - 1, 1)) + Cost[n][color];
            }
        }
        return DP[n][color];
    }
}
