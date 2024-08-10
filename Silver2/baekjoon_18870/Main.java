package Silver2.baekjoon_18870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static int[] origin;
    static int[] sorted;
    static HashMap<Integer, Integer> rankingMap = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        origin = new int[N];
        sorted = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
            sorted[i] = origin[i];
        }

        Arrays.sort(sorted);

        int rank = 0;
        for (int i : sorted) {
            if (!rankingMap.containsKey(i)) {
                rankingMap.put(i, rank++);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i : origin) {
            int ranking = rankingMap.get(i);
            sb.append(ranking).append(' ');
        }
        System.out.println(sb);
    }
}
