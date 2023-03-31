package Bronze4.baekjoon_10156;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K,N,M;
        K=sc.nextInt();
        N=sc.nextInt();
        M=sc.nextInt();

        int charge=K*N-M;
        if(charge<=0) System.out.println(0);
        else System.out.println(charge);
    }
}
