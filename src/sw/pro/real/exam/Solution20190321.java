package sw.pro.real.exam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static java.lang.Integer.parseInt;

public class Solution20190321 {
    private static final Node[] map = new Node[100_003];
    //为了进行字典顺序的拓扑排序，使用优先级队列进行排序，出队顺序即为  拓扑排序(字典顺序)
    //Comparator.comparingInt(Node::getIndex) 优先级队列的比较器，语法糖
    private static final PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(Node::getIndex));
    private static final ArrayList<Integer> tpRet = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = parseInt(st.nextToken());
            int M = parseInt(st.nextToken());
            int K = parseInt(st.nextToken());
            for (int i = 1; i <= N; i++) {
                if (map[i] == null) map[i] = new Node(i);
                else map[i].init();
            }
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int A = parseInt(st.nextToken());
                int B = parseInt(st.nextToken());
                int D = parseInt(st.nextToken());
                if (D == 1) {
                    map[B].inDegree += map[A].AVO.add(B) ? 1 : 0;//去重，add方法返回true，插入成功，入度+1
                }

            }
            for (int i = 1; i <= N; i++) {
                if (map[i].inDegree == 0) {
                    pq.offer(map[i]);
                }
            }

            while (!pq.isEmpty()) {
                tpRet.add(pq.peek().getIndex());
                for (int i : pq.poll().AVO) {
                    if (--map[i].inDegree == 0) {//入度==0，进入优先队列
                        pq.offer(map[i]);
                    }
                }
            }
            System.out.println("#" + t + " " + (tpRet.size() == N ? tpRet.get(K - 1) : -1));
            tpRet.clear();
        }
        br.close();
    }

    private static class Node {
        final int index;
        final HashSet<Integer> AVO;
        int inDegree;

        Node(final int i) {
            AVO = new HashSet<>();
            index = i;
        }

        void init() {
            AVO.clear();
            inDegree = 0;
        }

        int getIndex() {
            return index;
        }
    }
}
