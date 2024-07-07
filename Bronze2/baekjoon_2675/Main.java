package Bronze2.baekjoon_2675;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb;
        int T = Integer.parseInt(st.nextToken());

        for(int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            sb = new StringBuilder();
            for(int j = 0; j < str.length(); j++) {
                for (int k = 0; k < n; k++) {
                    sb.append(str.charAt(j));
                }
            }
            System.out.println(sb);
        }
    }
}
