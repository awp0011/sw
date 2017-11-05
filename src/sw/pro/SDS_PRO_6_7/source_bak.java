package sw.pro.SDS_PRO_6_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class source_bak {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        GoodsWeightComparator ic = new GoodsWeightComparator();
        PriorityQueue<Goods> pq = new PriorityQueue<>(ic);
        List<Goods> couldMoves = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            pq.add(new Goods(i, Integer.parseInt(br.readLine())));
        }
        int tobePos = N;
        Goods minGoods_couldMove = null, minGood_notMove = null, aGood;

        while (!pq.isEmpty()) {
            aGood = pq.poll();
            aGood.toBe = tobePos;
            tobePos--;
            if (aGood.couldMove()) {
                minGoods_couldMove = aGood;
                couldMoves.add(aGood);
            } else {
                minGood_notMove = aGood;
            }
        }
        long mst = 0, minCost = 0;
        for (Goods g : couldMoves) {
            if (!g.equals(minGoods_couldMove)) {
                mst += g.weight + minGoods_couldMove.weight;
            }
        }
        if (minGood_notMove != null) {
            for (Goods g : couldMoves) {
                minCost += g.weight + minGood_notMove.weight;
            }
            minCost += minGoods_couldMove.weight + minGood_notMove.weight;
            mst = mst > minCost ? minCost : mst;
        }
        System.out.println(mst);
    }

    static class Goods {
        int asIS;
        int toBe;
        int weight;


        public Goods(int pos, int w) {
            this.asIS = pos;
            this.weight = w;
        }

        boolean couldMove() {
            return asIS != toBe;
        }

        boolean equals(Goods other) {
            return other.asIS == asIS;
        }
    }

    static class GoodsWeightComparator implements Comparator<Goods> {
        @Override
        public int compare(Goods o1, Goods o2) {
            return o2.weight - o1.weight;
        }
    }

}
