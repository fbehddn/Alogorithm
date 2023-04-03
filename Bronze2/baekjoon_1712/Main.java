package Bronze2.baekjoon_1712;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int fixCost = sc.nextInt();
        int flexCost = sc.nextInt();
        int stock = sc.nextInt();

        if(flexCost>=stock) {
            System.out.println("-1");
        }

        else {
            System.out.println((fixCost/(stock-flexCost)) + 1);
        }
    }
}
