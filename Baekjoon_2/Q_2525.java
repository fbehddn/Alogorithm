package Baekjoon_2;

import java.util.Scanner;

public class Q_2525 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour,min,addMin;

        hour=sc.nextInt();
        min=sc.nextInt();
        addMin=sc.nextInt();

        min+=addMin;

        while(min>=60){
            int r1= min/60;
            hour+=r1;
            if(hour>=24){
                    int r3=hour%24;
                    hour=0;
                    hour+=r3;
                    int r2= hour/24;
                    min%=60;
            }
            min%=60;
        }
        System.out.print(hour+" "+min);
    }
}
