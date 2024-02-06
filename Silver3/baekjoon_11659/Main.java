package Silver3.baekjoon_11659;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] num = new int[N];
        for (int i = 0; i < N; i++) {
            num[i] = sc.nextInt();
        }
        int[][] range = new int[M][2];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < 2; j++) {
                range[i][j] = sc.nextInt();
            }
        }

        int[] result = new int[M];

        int idx = 0;

        for (int[] ints : range) {
            int start = ints[0] - 1;
            int end = ints[1] - 1;

            for (int i = start; i <= end; i++) {
                result[idx] += num[i];
            }
            idx++;
        }

        for (int i : result) {
            System.out.println(i);
        }
    }
}
