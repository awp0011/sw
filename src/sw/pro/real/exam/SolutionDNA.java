package sw.pro.real.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class SolutionDNA {
    private static final DNA[] dna = new DNA[3000];
    private static final HashMap<Character, ArrayList<DNA>> sections = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < N; i++) {
                if (dna[i] == null) dna[i] = new DNA(i, br.readLine());
                else dna[i].init(br.readLine());
                sections.computeIfAbsent(dna[i].begin, c -> new ArrayList<>()).add(dna[i]);
            }
            int max = 0;
            for (ArrayList<DNA> al : sections.values()) {
                max = Math.max(al.size(), max);
            }
            int ans = 1;
            end:
            for (int i = 0; i < N; i++) {
                for (DNA next : sections.get(dna[i].begin)) {
                    if (next.index < dna[i].index) continue;
                    if (next.SEQ.length() <= dna[i].SEQ.length()) continue;
                    if (next.SEQ.startsWith(dna[i].SEQ)) {
                        next.Gen = Math.max(next.Gen, dna[i].Gen + 1);
                        ans = Math.max(next.Gen, ans);
                        if (ans == max) break end;
                    }
                }
            }
            System.out.println("#" + t + " " + ans);
            sections.values().forEach(ArrayList::clear);
        }
    }

    private static class DNA {
        final int index;
        Character begin;
        String SEQ;
        int Gen;

        DNA(int i, String s) {
            index = i;
            init(s);
        }

        void init(String s) {
            SEQ = s;
            begin = s.charAt(0);
            Gen = 1;
        }
    }
}
