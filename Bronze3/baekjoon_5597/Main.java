package Bronze3.baekjoon_5597;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] students = new int[30];

        for(int i = 0; i < 28; i++) {
            int num = sc.nextInt();
            students[num-1] = 1;
        }
        for(int i = 0; i < 30; i++) {
            if(students[i] !=1) System.out.println(i + 1);
        }
    }
}
