package Bronze3.baekjoon_10810;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        for (int s = 0; s < M; s++) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            int k = sc.nextInt();

            for (int w = i; w <= j; w++) {
                arr[w-1] = k;
            }
        }
        for (int i : arr) {
            System.out.print(i+" ");
        }
    }
}
