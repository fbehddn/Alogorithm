package Sliver4.baekjoon_11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int preSum = 0;
        int result = 0;

        for (int i : arr) {
            preSum += i;
            result += preSum;
        }

        System.out.println(result);
    }
}

/**
 * P1 = 3
 * P2 = 1
 * P3 = 4
 * P4 = 3
 * P5 = 2
 *
 * ==> P1, P2, P3, P4, P5
 * 3 + 4 + 8 + 11 + 13  = 39 == 최소값 X
 *
 * ==> P2, P5, P1, P4, P3
 * 1 + 3 + 6 + 9 + 13 = 32 == 최소값 O
 *
 * 그냥 작은수부터 정렬해서 더하면 됨
 */
