package Sliver4.baekjoon_1940;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int sIndex = 0;
        int eIndex = arr.length - 1;
        int count = 0;

        int sum = 0;

        while (sIndex < eIndex) {
            sum = arr[sIndex] + arr[eIndex];

            if (sum == m) {
                count++;
                sIndex++;
                eIndex--;
                sum = arr[sIndex] + arr[eIndex];
            } else if (sum < m) {
                sum -= arr[sIndex];
                sIndex++;
                sum += arr[sIndex];
            } else if (sum > m) {
                sum -= arr[eIndex];
                eIndex--;
                sum += arr[eIndex];
            }
        }
        System.out.println(count);
    }
}
