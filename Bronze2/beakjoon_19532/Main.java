package Bronze2.beakjoon_19532;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[][] arr = new int[2][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int a, b, c, d, e, f;
        a=Integer.parseInt(str[0]);
        b=Integer.parseInt(str[1]);
        c=Integer.parseInt(str[2]);
        d=Integer.parseInt(str[3]);
        e=Integer.parseInt(str[4]);
        f=Integer.parseInt(str[5]);
        int answerX = 0;
        int answerY = 0;

        for(int i=-999; i<=999; i++){
            for(int j=-999; j<=999; j++){
                if(a*i + b*j == c && d*i + e*j == f){
                    answerX = i;
                    answerY = j;
                }
            }
        }
        System.out.print(answerX + " " + answerY);
    }
}
