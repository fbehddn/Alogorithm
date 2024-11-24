package Bronze5.baekjoon_27433;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        if (N == 0) System.out.println(1);
        else System.out.println(fact(N));
    }

    private static long fact(int n) {
        if (n <= 1) return n;

        return n * (fact(n - 1));
    }
}
