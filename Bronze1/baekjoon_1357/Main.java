package Bronze1.baekjoon_1357;

import java.util.Scanner;

public class Main {
    private static int Rev(int n) {
        int temp = 0;
        while(n > 0) {
            //123
            temp = temp * 10 + n %10;
            n/=10;
        }
        return temp;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int result = Rev(Rev(n) + Rev(m));

        System.out.println(result);
    }

}


