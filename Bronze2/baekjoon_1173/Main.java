package Bronze2.baekjoon_1173;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //운동해야하는시간
        int m = Integer.parseInt(st.nextToken()); //초기맥박, 크거나 같아야함
        int M = Integer.parseInt(st.nextToken()); //최대맥박, 작거나 같아야함
        int T = Integer.parseInt(st.nextToken()); //증가하는 맥박 (운동)
        int R = Integer.parseInt(st.nextToken()); //감소하는 맥박 (감소)

        int time=0;
        int count=0;
        int pulse=m;

        while (count<N) {
            if(pulse+T<=M){
                count++;
                time++;
                pulse+=T;
            } else {
                if(pulse-R<m){
                    time++;
                    pulse=m;
                }else{
                    time++;
                    pulse-=R;
                }
            }
        }
        System.out.println(time);
        //70 c 95 c 120 c 145 130 115 c 140 125 110 c 135
    }
}
