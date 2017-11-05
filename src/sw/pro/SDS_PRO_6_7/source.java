package sw.pro.SDS_PRO_6_7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

class source {
    private static SortedSet<Goods> finalArray = new TreeSet<>(Comparator.comparing(Goods::getWeight));

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Goods[] origins = new Goods[N + 1];
        for (int i = 1; i <= N; i++) {
            Goods goods = new Goods(i, Integer.parseInt(br.readLine()));
            finalArray.add(goods);
            origins[i] = goods;
        }
        br.close();
        int index = 1;
        for (Goods g : finalArray) {
            g.toBe = index;
            index++;

        }

        Goods[] targets = new Goods[N + 1];
        System.arraycopy(finalArray.toArray(new Goods[0]), 0, targets, 1, N);

        Goods first_sorted = null;
        for (Goods g : finalArray) {
            if (!g.couldMove()) {
                first_sorted = g;
                break;
            }

        }
        long cost = 0, cost1=Long.MAX_VALUE, cost2=0;

        for (Goods g : finalArray) {
            if (g != null && g.couldMove()) {
                if (first_sorted != null) {
                    cost1 = (first_sorted.weight + g.weight) << 1;
                }
                while (g.couldMove()) {
                    Goods target = targets[g.asIS];
                    cost2 += g.weight + target.weight;
                    origins[target.asIS] = origins[g.asIS];
                    origins[g.asIS] = target;
                    g.asIS = target.asIS;
                    target.asIS = target.toBe;
                    if (first_sorted != null) {
                        cost1 += first_sorted.weight + target.weight;
                    }
                }
                cost += Math.min(cost1, cost2);
                cost2 = 0;
            }
        }

        System.out.println(cost);

    }

    static class Goods {
        int asIS;
        int toBe;
        int weight;

        Goods(int pos, int w) {
            this.asIS = pos;
            this.weight = w;
        }

        int getWeight() {
            return weight;
        }

        boolean couldMove() {
            return asIS != toBe;
        }
    }

}
