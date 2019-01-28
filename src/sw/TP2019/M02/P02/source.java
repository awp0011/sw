package sw.TP2019.M02.P02;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class source {
    public static void main(String[] args) throws Exception{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());
        int prev=0;
        int ans=0,sum=0;
        for (int i = 0; i < N ; i++) {
            int cur = Integer.parseInt(in.readLine());
            if(cur!=prev){
                ans = sum>ans?sum:ans;
                sum=1;
            }else{
                sum++;
            }
            prev = cur;
        }
        System.out.println(ans);
    }
}
