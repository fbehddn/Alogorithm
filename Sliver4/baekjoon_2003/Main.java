package Sliver4.baekjoon_2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }

        int sum = 0;
        int count = 0;

        int start = 0;
        int end = 0;

        //M=6
        //1 3 5 2 6
        while (true) {
            if (sum >= M) {
                sum -= arr[start++];
            } else if (end >= N) {
                break;
            } else {
                sum += arr[end++];
            }
            if (sum == M) {
                count++;
            }
        }
        System.out.println(count);
    }
}
