package sw.pro.sunday;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;

public class source {
    private static char[] S, T;
    private static int[] occ;
    private static int m, n;
    private static int[] stack;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        S = br.readLine().toCharArray();
        T = br.readLine().toCharArray();
        br.close();
        m = S.length;
        stack = new int[m + 1];
        n = T.length;
        int end = 0;
        for (int i = 0; i < m; i++) {
            if (S[i] == T[0]) {
                stack[end] = i;
                end++;
            }
        }
        initOCC(T);
        int isClose = 0;
        while (true) {
            isClose = matchSubStr(isClose);
            if (isClose == -1) break;
            Arrays.fill(S, isClose, isClose + n, '.');
            int prevStart = Arrays.binarySearch(stack, 0, end, isClose) - 1;
            isClose = prevStart < 0 ? isClose + n : stack[prevStart];
        }
        for (char c : S) {
            if (c != '.') bw.append(c);
        }
        bw.newLine();
        bw.flush();
        bw.close();
    }

    private static int getPrevStart(int current) {
        return Arrays.binarySearch(stack, current);

    }

    private static int matchSubStr(int start) {
        int jump , offset ;
        for (int i = start; i <= m - n; i += jump) {
            int j = 0;
            offset = 0;
            while (j < n) {
                if (T[j] == S[i + j]) {
                    j++;
                } else if (S[i + j] == '.') {
                    offset++;
                    j++;
                } else {
                    break;
                }
            }
            if (j + offset == n + offset) return i;
            jump = i + n < m ? n - occ[S[i + n]] : 1;
        }
        return -1;
    }

    private static void initOCC(char[] needle) {
        occ = new int[128];
        Arrays.fill(occ, -1);
        for (int i = 0; i < needle.length; i++) {
            occ[needle[i]] = i;
        }
    }
}
