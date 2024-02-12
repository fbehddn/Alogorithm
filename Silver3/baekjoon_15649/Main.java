package Silver3.baekjoon_15649;

import java.util.Scanner;

public class Main {
    static int[] arr;
    static boolean[] visited;
    static int N; //정수 1 ~ N 까지
    static int M; //자릿수
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }

        nAndm(N);
    }

    private static void nAndm(int k) {

        if (!visited[k]) {
            visited[k] = true;
        }

        for (int i = 0; i < k; i++) {

        }
    }
}
