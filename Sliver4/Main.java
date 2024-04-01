package Sliver4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        while (M-- > 0) {
            int tar = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(arr, tar, 0, N - 1)).append("\n");
        }

        System.out.println(sb);
    }

    private static int binarySearch(int[] arr, int target, int low, int high) {
        while (low <= high) {
            int mid = (low + high) / 2;

            if (target == arr[mid]) {
                return 1;
            } else if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return 0;
    }
}
