package Bronze2.baekjoon_2908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N1 = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        int N2 = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());

        System.out.println(N1 > N2 ? N1 : N2);
    }
}
