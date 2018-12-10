package sw.pro.knights.round.table;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.Math.abs;
import static java.lang.Math.max;

public class Solution {
    private static int cntOfKnight;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(br.readLine());
        PriorityQueue<KnightSet> queue = new PriorityQueue<>((e1, e2) -> {
            if (e1.getPriority() == e2.getPriority()) {
                return e2.getNext() - e1.getNext();
            } else {
                return e1.getPriority() - e2.getPriority();
            }
        });
        for (int tc = 1; tc <= T; tc++) {

            cntOfKnight = 0;
            int N = parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            KnightSet knight = new KnightSet(parseInt(st.nextToken()), parseInt(st.nextToken()));
            KnightSet first = knight;
            for (int i = 1; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                if (i < 4) knight = connect(knight, parseInt(st.nextToken()), parseInt(st.nextToken()));
                else knight = join(knight, parseInt(st.nextToken()), parseInt(st.nextToken()));
                if (knight.left.hasNext()) queue.add(knight.left);

            }
            knight.right = first;
            first.left = knight;
            queue.add(first);
            queue.add(knight);

            KnightSet ks = first;
            while (queue.peek() != null && cntOfKnight > 4) {
                ks = queue.poll();
                if (ks.isUsed) queue.add(merge(ks));
            }

            int maxWins = max(ks.wins + ks.left.left.wins + ks.left.loses + ks.right.loses,
                    ks.loses + ks.left.left.loses + ks.left.wins + ks.right.wins);


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

        if (middle.isWon == middle.left.isWon) {
            middle = mergeLeft(middle);
        } else if (middle.isWon == middle.right.isWon) {
            middle = mergeRight(middle);
        } else {
            middle = mergeLeft(middle);
            middle = mergeRight(middle);
        }

        return middle;
    }

    private static KnightSet mergeLeft(KnightSet middle) {
        middle.wins += middle.left.wins;
        middle.loses += middle.left.loses;
        middle.diff = middle.wins - middle.loses;
        middle.isWon = middle.diff > 0;
        middle.left.isUsed = false;
        middle.left.left.right = middle;
        middle.left = middle.left.left;
        cntOfKnight -= 1;
        return middle;
    }

    private static KnightSet mergeRight(KnightSet middle) {
        middle.wins += middle.right.wins;
        middle.loses += middle.right.loses;
        middle.diff = middle.wins - middle.loses;
        middle.isWon = middle.diff > 0;
        middle.right.isUsed = false;
        middle.right.right.left = middle;
        middle.right = middle.right.right;
        cntOfKnight -= 1;
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

        boolean hasNext() {
            return left != null && right != null;
        }

        int getPriority() {
            if (isWon == left.isWon || isWon == right.isWon) return 0;
            else return 1;
        }

        int getNext() {
            if (isWon == left.isWon) return abs(diff + left.diff);
            else if (isWon == right.isWon) return abs(diff + right.diff);
            return abs(left.diff + right.diff + diff);
        }
    }
}