package Sliver5.baekjoon_2018;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int sIndex = 1;
        int eIndex = 1;
        int count = 1;
        int sum = 1;

        while (eIndex != num) {
            /**
             * sum > num : sum = sum - sIndex , sIndex ++
             * sum == num : count++, eIndex ++
             * sum < num : sum = sum + eIndex
             */

            if(sum == num) {
                eIndex ++;
                sum += eIndex;
                count++;
            } else if (sum > num) {
                sum -= sIndex;
                sIndex++;
            } else if (sum < num) {
                eIndex++;
                sum += eIndex;
            }
        }
        System.out.println(count);
    }
}
