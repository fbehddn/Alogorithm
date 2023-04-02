package Bronze2.baekjoon_10996;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        br.close();

        if(n==1) System.out.print("*");

        else{
            for (int i = 0; i < n * 2; i++) {
                for (int j = 0; j < n; j++) {
                    if(i%2==1 && j%2==1) System.out.print("*");
                    else if(i%2!=1 && j%2!=1) System.out.print("*");
                    else System.out.print(" ");
                }
                System.out.println();
            }
        }

    }
}
