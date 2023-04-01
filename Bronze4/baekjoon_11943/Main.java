package Bronze4.baekjoon_11943;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a=scan.nextInt(), b=scan.nextInt();
        int c=scan.nextInt(), d=scan.nextInt();

        System.out.println(Math.min(a+d,b+c));
    }
}
