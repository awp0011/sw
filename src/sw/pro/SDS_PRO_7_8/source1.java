package sw.pro.SDS_PRO_7_8;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class source1 {
    private static int MAX = 200020;
    private static int N;
    private static int[] sx = new int[MAX];
    private static int[] ex = new int[MAX];
    private static int[] y = new int[MAX];
    private static ArrayList<Pair> ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sx[i] = Integer.parseInt(st.nextToken());
            ex[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }
        ans = solve(0, N);
        // BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuffer sb = new StringBuffer(500);
        sb.append(ans.size()).append('\n');
        for (Pair p : ans) {
            sb.append(p.first).append(' ' ).append(p.second).append('\n');
        }
        System.out.println(sb.toString());
    }

    private static ArrayList<Pair> solve(int l, int r) {
        if (l + 1 == r) {//相邻的两个建筑物
            ArrayList<Pair> ret = new ArrayList<>();
            ret.add(new Pair(sx[l], y[l]));//左边建筑物开始坐标，左边建筑物高度
            ret.add(new Pair(ex[l] + 1, 0));//左边建筑物结束坐标+1，高度0
            return ret;
        } else {
            int m = (l + r) >> 1;

            ArrayList<Pair> al = solve(l, m);
            ArrayList<Pair> ar = solve(m, r);
            ArrayList<Pair> ret = new ArrayList<>(100);
            int i = 0, j = 0, ly = 0, ry = 0;
            while (true) {
                if (i == al.size()) {
                    if (j == ar.size()) {
                        break;
                    } else {
                        ret.add(ar.get(j));
                        j++;
                    }
                } else {
                    if (j == ar.size()) {
                        ret.add(al.get(i));
                        i++;
                    } else {
                        if (al.get(i).first < ar.get(j).first) {
                            if (Math.max(ly, ry) != Math.max(al.get(i).second, ry)) {
                                ret.add(new Pair(al.get(i).first, Math.max(al.get(i).second, ry)));
                            }
                            ly = al.get(i).second;
                            i++;
                        } else if (al.get(i).first > ar.get(j).first) {
                            if (Math.max(ly, ry) != Math.max(ly, ar.get(j).second)) {
                                ret.add(new Pair(ar.get(j).first, Math.max(ly, ar.get(j).second)));
                            }
                            ry = ar.get(j).second;
                            j++;
                        } else {
                            int maxY = Math.max(al.get(i).second, ar.get(j).second);
                            if (Math.max(ly, ry) != maxY) {
                                ret.add(new Pair(al.get(i).first, maxY));
                            }
                            ly = al.get(i).second;
                            ry = ar.get(j).second;
                            i++;
                            j++;
                        }
                    }
                }
            }
            return ret;
        }
    }

    private static class Pair {
        int first;
        int second;

        Pair(int f, int s) {
            first = f;
            second = s;
        }
    }

}