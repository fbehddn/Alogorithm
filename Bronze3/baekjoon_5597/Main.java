package Bronze3.baekjoon_5597;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        int[] arr = new int[30];

        for(int i = 0; i < 30; i++) {
            arr[i] = i + 1;
        }

        for (int i = 0; i < 28; i++) {
            list.add(sc.nextInt());
        }
        for (int i : arr) {
            if(!list.contains(i)) {
                result.add(i);
            }
        }
        for (Integer i : result) {
            System.out.println(i);
        }
    }
}
