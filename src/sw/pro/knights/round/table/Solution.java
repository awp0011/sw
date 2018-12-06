package sw.pro.knights.round.table;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.Math.*;

public class Solution {
    private static int cntOfKnight;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(br.readLine());
        PriorityQueue<KnightSet> queue = new PriorityQueue<>(Comparator.comparingInt(KnightSet::getNext));
        for (int tc = 1; tc < T; tc++) {

            cntOfKnight = 0;
            int N = parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            KnightSet first = new KnightSet(parseInt(st.nextToken()), parseInt(st.nextToken()));
            KnightSet knight = connect(first, parseInt(st.nextToken()), parseInt(st.nextToken()));
            knight = connect(knight, parseInt(st.nextToken()), parseInt(st.nextToken()));
            queue.add(knight.left);
            knight = connect(knight, parseInt(st.nextToken()), parseInt(st.nextToken()));
            for (int i = 4; i < N; i++) {
                knight = join(knight, parseInt(st.nextToken()), parseInt(st.nextToken()));
                queue.add(knight.left);

            }
            knight.right = first;
            first.left = knight;
            queue.add(first);
            queue.add(knight);

            while (queue.peek() != null && cntOfKnight > 4) {
                KnightSet ks = queue.poll();
                if(ks.isUsed) queue.add(merge(ks));
            }

            //To-do calculate maxWins
            int maxWins = 0;


            System.out.println("#" + tc + " " + maxWins);
        }
    }

    private static KnightSet connect(KnightSet knight, int w, int l) {
        KnightSet other = new KnightSet(w, l);
        knight.right = other;
        other.left = knight;
        return other;
    }

    private static KnightSet join(KnightSet knight, int w, int l) {
        boolean isWon = (w - l) > 0;
        if (knight.isWon == isWon) {
            knight.wins += w;
            knight.loses += l;
            knight.diff = knight.wins - knight.loses;
            return knight;
        } else {
            return connect(knight, w, l);
        }

    }

    private static KnightSet merge(KnightSet middle) {
        middle.wins += middle.left.wins + middle.right.wins;
        middle.loses += middle.left.loses + middle.right.loses;
        middle.diff = middle.wins - middle.loses;
        middle.isWon = middle.diff > 0;
        middle.left.isUsed = false;
        middle.left.left.right = middle;
        middle.right.isUsed = false;
        middle.right.right.left = middle;
        cntOfKnight -= 2;
        return middle;
    }

    private static class KnightSet {
        int wins;
        int loses;
        int diff;
        boolean isWon;
        KnightSet left;
        KnightSet right;
        boolean isUsed;

        KnightSet(int w, int l) {
            wins = w;
            loses = l;
            diff = wins - loses;
            isWon = diff > 0;
            isUsed = true;
            cntOfKnight++;
        }

        int getNext() {
            return abs(left.diff + right.diff + diff);
        }
    }
}
