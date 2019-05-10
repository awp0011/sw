package sw.contest.vjudge.poj2940;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    private static final ArrayList<Node> negative = new ArrayList<>();
    private static final ArrayList<Node> positive = new ArrayList<>();
    private static final PriorityQueue<Line> queue = new PriorityQueue(Comparator.comparingInt(Line::getLength));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N;
        do {
            N = Integer.parseInt(br.readLine());
            int counter0 = N;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                int n = Integer.parseInt(st.nextToken());
                if (n > 0) positive.add(new Node(i, n));
                else negative.add(new Node(i, -n));
            }
            for (Node p : positive) {
                for (Node n : negative) {
                    queue.add(new Line(p, n));
                }
            }
            long ans = 0;
            while (counter0 != 0 && queue.peek()!=null) {
                Line l = queue.poll();
            }
            negative.clear();
            positive.clear();
            queue.clear();
        } while (N != 0);
    }

    private static class Node {
        int index;
        int value;

        Node(int i, int v) {
            index = i;
            value = v;
        }

        boolean isAvilale() {
            return value != 0;
        }
    }

    private static class Line {
        Node from, to;
        int length;

        Line(Node n1, Node n2) {
            from = n1;
            to = n2;
            length = Math.abs(from.index - to.index);
        }

        int getLength() {
            return length;
        }

        int getValue() {
            if (from.value == 0 || to.value == 0) return 0;
            int diff = Math.min(from.value, to.value);
            from.value -= diff;
            to.value -= diff;
            return diff * length;
        }
    }
}
