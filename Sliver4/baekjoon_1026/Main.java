package Sliver4.baekjoon_1026;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 0은 가장 큰 숫자의 인덱스로 이동, 이후 큰 숫자 = 작은숫자 매칭
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arrA = new int[N];
        int[] arrB = new int[N];
        int result = 0;

        for (int i = 0; i < N; i++) {
            arrA[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            arrB[i] = sc.nextInt();
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB);

        for (int n = 0; n < N; n++) {
            result += arrA[n] * arrB[N - n - 1];
        }
        System.out.println(result);
    }
}
