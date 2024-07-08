package Bronze5.baekjoon_3003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr = {1, 1, 2, 2, 2, 8};
    static int[] que = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 6; i++) {
            que[i] = Integer.parseInt(st.nextToken());
            sb.append(arr[i] - que[i]);
            sb.append(" ");
        }
        System.out.print(sb);
    }
}
