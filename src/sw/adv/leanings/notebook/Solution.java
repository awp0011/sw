package sw.adv.leanings.notebook;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    private static int[][] lending;

    static {
        lending = new int[1005][2];
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<Notebook> equipments = new PriorityQueue<>(Comparator.comparing(o -> o.using));
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                lending[j][0] = Integer.parseInt(st.nextToken());
                lending[j][1] = Integer.parseInt(st.nextToken());
            }
            //Arrays.sort(lending, 0, N, (e1, e2) -> e1[0] - e2[0]);
            Arrays.sort(lending, 0, N, Comparator.comparingInt(e->e[0]));

            //Arrays.stream(lending).filter(s->s[0]>0).forEach(e-> System.out.println(Arrays.toString(e)));

            equipments.add(new Notebook(lending[0][0] + lending[0][1]));
            for (int j = 1; j < N; j++) {
                Notebook notebook = equipments.poll();
                assert notebook != null;
                if (notebook.isAvailable(lending[j][0])) {
                    notebook.lend(lending[j][0] + lending[j][1]);
                } else {
                    equipments.add(new Notebook(lending[j][0] + lending[j][1]));
                }
                equipments.add(notebook);
            }

            System.out.println("#" + i + " "+ equipments.size());
            equipments.clear();
        }

    }

    private static class Notebook {
        int using;

        Notebook(int init) {
            using = init;
        }

        boolean isAvailable(int start) {
            return start >= using;
        }

        void lend(int days) {
            using = days;
        }
    }
}
