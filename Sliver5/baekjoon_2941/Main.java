package Sliver5.baekjoon_2941;

import java.util.Scanner;

public class Main {
    static String[] arr = new String[]{"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};

    // dz= , z= 판별 알고리즘 구현 해야함
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        for (String s : arr) {
                str = str.replace(s, "!");

        }
        System.out.println(str.length() );
    }
}
