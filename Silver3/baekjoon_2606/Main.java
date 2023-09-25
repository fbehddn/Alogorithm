package Silver3.baekjoon_2606;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int node, line;
    static boolean[] check; //이미 감염된 컴퓨터인지 체크
    static int[][] arr; //간선(line) 입력받고 1 저장
    static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //컴퓨터(노드)와 감염된 간선(라인) 입력받기
        node = Integer.parseInt(br.readLine());
        line = Integer.parseInt(br.readLine());

        arr = new int[node+1][node+1];
        check = new boolean[node+1];

        for (int i = 0; i < line; i++) {
            StringTokenizer str = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(str.nextToken());
            int b = Integer.parseInt(str.nextToken());

            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        dfs(1);
        System.out.println(count-1);
    }

    private static void dfs(int start) {
        check[start] = true;
        count++;

        for (int i = 0; i <= node; i++) {
            if (arr[start][i] == 1 && !check[i]) {
                dfs(i);
            }
        }
    }
}

/**
 * arr[1][2] = 1 , arr[2][1] = 1
 * arr[2][3] = 1 , arr[3][2] = 1
 * arr[1][5] = 1, arr[5][1] = 1
 * arr[5][2] = 1, arr[2][5] = 1
 * arr[5][6] = 1, arr[6][5] = 1
 * arr[4][7] = 1, arr[7][4] = 1
 *
 * check[1] = true, count++ => 1
 * arr[1][2] =  1 && check[2]
 * i = 2
 * check[2] = true, count ++ => 2
 */
