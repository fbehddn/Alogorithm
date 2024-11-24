package Bronze5.baekjoon_25314;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String ans = "";
        int n = sc.nextInt() / 4;

        for(int i=0; i<n; i++) {
            ans += "long ";
        }
        ans += "int";

        System.out.println(ans);
    }
}
