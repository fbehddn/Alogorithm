package Bronze2.baekjoon_1100;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count =0;
        String s = "";
        for(int i=0; i<8; i++){
            s=br.readLine();
            for (int j = 0; j < 8; j++) {
                if(s.charAt(j)=='F' && (i+j)%2==0) count++;
            }
        }
        System.out.println(count);
    }
}
