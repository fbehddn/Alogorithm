package Bronze3.baekjoon_2444;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            for (int j = T-1; j > i; j--) {
                System.out.print(" ");
            }
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 0; i < T-1; i++) {
            for (int j = 0 ; j < i+1; j++) {
                System.out.print(" ");
            }
            for (int j = 2 * T - 3; j > 2 * i; j--) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
