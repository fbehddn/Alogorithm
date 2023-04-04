package Bronze1.baekjoon_4344;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int[] arr;

        int testcase = in.nextInt();

        for(int i = 0 ; i < testcase ; i++) {

            int N = in.nextInt();
            arr = new int[N];

            double sum = 0;

            for(int j = 0 ; j < N ; j++) {
                int val = in.nextInt();
                arr[j] = val;
                sum += val;
            }

            double mean = (sum / N) ;
            double count = 0;

            for(int j = 0 ; j < N ; j++) {
                if(arr[j] > mean) {
                    count++;
                }
            }

            System.out.printf("%.3f%%\n",(count/N)*100);


        }
        in.close();
    }

}