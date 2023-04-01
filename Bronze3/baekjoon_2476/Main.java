package Bronze3.baekjoon_2476;

import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] sum = new int[num];
        for(int i=0;i<num;i++)
        {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();

            if(x == y && x == z && y == z)
                sum[i] = 10000 + x*1000;
            else if(x == y || x == z)
                sum[i] = 1000 + x*100;
            else if(y == z)
                sum[i] = 1000 + y*100;
            else {
                int max = Math.max(x, Math.max(y, z));
                sum[i] = max*100;
            }
        }
        sc.close();
        Arrays.sort(sum);
        System.out.print(sum[sum.length - 1]+ " ");
    }
}
