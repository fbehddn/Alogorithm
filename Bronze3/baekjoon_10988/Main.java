package Bronze3.baekjoon_10988;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int idx = 0;

        while (idx< str.length() / 2) {
            if (str.charAt(idx) != str.charAt(str.length() - 1 - idx)) {
                System.out.println(0);
                return;
            } else {
                idx++;
            }
        }
        System.out.println(1);
    }
}
