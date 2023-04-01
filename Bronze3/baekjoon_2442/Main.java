package Bronze3.baekjoon_2442;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        for (int i = 0; i < n; i++) {
            for(int j = n-i-1; j>0; j--) System.out.print(" ");
            for(int k = 0; k<2*i+1; k++) System.out.print("*");
            System.out.println();
        }
    }
}
