package Bronze3.baekjoon_2576;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] a= new int[7];
        int sum=0;
        int min=100;

        for (int i = 0; i < a.length; i++) {
            a[i]=sc.nextInt();
            if((a[i]%2) !=0){
                sum+=a[i];
                if(a[i]<min) min=a[i];
            }
        }
        if(sum==0) System.out.println(-1);
        else{
            System.out.println(sum);
            System.out.println(min);
        }

    }
}
