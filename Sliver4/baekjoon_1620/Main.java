package Sliver4.baekjoon_1620;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> pocketMap = new HashMap<>();
        String[] pocketArr = new String[N + 1];

        for (int i = 1; i < N + 1; i++) {
            String temp = br.readLine();
            pocketMap.put(temp, i);
            pocketArr[i] = temp;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < M + 1; i++) {
            String pocket = br.readLine();
            if (checkNumber(pocket)) {
                sb.append(pocketArr[Integer.parseInt(pocket)]);
            } else {
                sb.append(pocketMap.get(pocket));
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean checkNumber(String pocket) {
        try {
            Integer.parseInt(pocket);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
