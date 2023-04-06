package Bronze2.baekjoon_2798;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt(); // 카드 개수
        int b = sc.nextInt(); // 상한값

        int[] num = new int[a];

        for (int i = 0; i < a; i++) {
            num[i] = sc.nextInt();
        }

        int max = -1;
        for (int i = 0; i < a-2; i++) {
            for (int j = i + 1; j < a-1; j++) {
                for (int k = j + 1; k < a; k++) {
                    int sum = num[i] + num[j] + num[k];
                    if(sum<=b && sum>=max){
                        max=sum;
                    }
                }
            }
        }
        System.out.println(max);
    }
}
