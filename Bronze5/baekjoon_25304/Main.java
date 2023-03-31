package Bronze5.baekjoon_25304;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sumPrice = sc.nextInt();
        int type = sc.nextInt();
        int price,count;

        for (int i = 0; i < type; i++) {
            price = sc.nextInt();
            count = sc.nextInt();
            sumPrice -= price * count;
        }
        if(sumPrice==0) System.out.println("Yes");
        else System.out.println("No");

    }
}
