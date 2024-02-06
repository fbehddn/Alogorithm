package Silver3.baekjoon_11659;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] num = new int[N+1];
        int[] sum = new int[N+1];
        sum[0] = 0;

        /**
         * 배열값 입력과 동시에 구간합 생성
         */
        for (int i = 1; i <= N; i++) {
            num[i] = sc.nextInt();
            sum[i] = sum[i - 1] + num[i];
        }

        /**
         * 질의 범위 입력받음과 동시에 출력하기
         */

        for (int i = 0; i < M; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            System.out.println(sum[end] - sum[start-1]);
        }
    }
}
