package Bronze4.backjoon_15680;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = "YONSEI";
        String str2 = "Leading the Way to the Future";

        int N=sc.nextInt();
        if(N==0) System.out.println(str);
        else System.out.println(str2);
    }
}
