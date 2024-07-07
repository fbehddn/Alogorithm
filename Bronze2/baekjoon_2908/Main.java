package Bronze2.baekjoon_2908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N1 = Integer.parseInt(st.nextToken()); //432
        int N2 = Integer.parseInt(st.nextToken());

        String str = "";
        String str2 = "";

        for (int i = 0; i < 3; i++) {
            str += N1 % 10;
            N1 /= 10;

            str2 += N2 % 10;
            N2 /= 10;
        }

        if(Integer.parseInt(str) > Integer.parseInt(str2)){
            System.out.println(Integer.parseInt(str));
        } else System.out.println(Integer.parseInt(str2));
    }
}
