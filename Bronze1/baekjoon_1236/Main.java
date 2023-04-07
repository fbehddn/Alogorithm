package Bronze1.baekjoon_1236;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        char[][] arr = new char[N][M];
        int count = 0;
        int noN = 0;
        int noM = 0;
        for (int i = 0; i < N; i++) {
            String str = sc.next();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 'X') count++;
            }
            if (count == 0) noN++;
            count = 0;
        }

        for (int j = 0; j < M; j++) {
            for (int i= 0; i < N; i++) {
                if(arr[i][j] == 'X') count++;
            }
            if(count == 0) noM++;
            count=0;
        }
        System.out.println((noN>=noM)?noN:noM);
    }
}
