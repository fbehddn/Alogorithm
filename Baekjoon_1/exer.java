package Baekjoon_1;

import java.util.Scanner;

public class exer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sum = 0;

        while (true) {
            System.out.print("정수를 입력하세요 (엔터 입력시 종료): ");

            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                sum += num;
            } else {
                break;
            }

            scanner.nextLine();
        }

        System.out.println("입력한 수의 합: " + sum);

        scanner.close();
    }
}
