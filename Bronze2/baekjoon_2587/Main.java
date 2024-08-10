package Bronze2.baekjoon_2587;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] arr = new int[5];
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int sum = 0;

        for (int i = 0; i < 5; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        Arrays.sort(arr);
        System.out.println(sum / 5);
        System.out.println(arr[2]);
    }
}
