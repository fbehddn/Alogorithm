package Sliver4.baekjoon_14425;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static HashMap<Integer, String > map = new HashMap<>();
    static String[] strArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        strArr = new String[M];
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            map.put(cnt++, br.readLine());
        }
        for (int i = 0; i < M; i++) {
            strArr[i] = br.readLine();
        }

        int result = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if(map.get(j).equals(strArr[i])) {
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
