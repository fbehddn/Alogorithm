package Sliver4.baekjoon_2164;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] q = new int[2 * n];

        for (int i = 1; i <= n; i++) {
            q[i] = i;
        }

        int pre_ind = 1;
        int last_ind = n;

        while (n-- > 1) {
            pre_ind++;
            q[last_ind+1] = q[pre_ind];
            last_ind++;
            pre_ind++;

        }
        System.out.println(q[pre_ind]);
    }
}
/**
 * 1 2 3 4
 * 1 2 3 4 2
 * 1 2 3 4 2 3
 */
