package Sliver4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> result = new ArrayList<>();
        int N = sc.nextInt();
        int[] n = new int[N];

        for (int i = 0; i < N; i++) {
            n[i] = sc.nextInt();
        }

        int M = sc.nextInt();
        int[] m = new int[M];
        for (int i = 0; i < M; i++) {
            m[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(n[j] == m[i]) {
                    result.add(1);
                }
            }
            if(result.size() == i) result.add(0);
        }
        for (Integer integer : result) {
            System.out.println(integer);
        }
    }
    /**
     * 2 5 7 8 9
     * 1 3 5 7 9
     */
}
