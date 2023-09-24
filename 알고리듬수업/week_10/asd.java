package 알고리듬수업.week_10;

import java.util.Scanner;

public class asd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int code;
        int num = sc.nextInt();

        code = ((num%10000) * 3897 + (num/100000) * (num/100000)) % 10000;
        System.out.println(code);
    }
}
