package sw.pro.SDS_PRO_6_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class source {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, LinkedList<Balloon>> balloons = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        Balloon[] balloonArray = new Balloon[N + 1];
        BalloonComparator bc = new BalloonComparator();
        PriorityQueue<Balloon> queue = new PriorityQueue<>(N, bc);
        Integer height;
        LinkedList<Balloon> sameHeight;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            // balloons[i] = new Balloon(Integer.parseInt(st.nextToken()), i);
            height = Integer.valueOf(st.nextToken());
            sameHeight = balloons.get(height);
            if (sameHeight == null) {
                sameHeight = new LinkedList<>();
            }
            Balloon ball = new Balloon(height, i);
            balloonArray[i] = ball;
            queue.add(ball);
            sameHeight.add(ball);
            balloons.put(height, sameHeight);
        }
        // shoot(N);
        int end = N;
        int arrow_cnt = 0;
        Balloon nextBalloon = new Balloon(0, 0);
        while (!queue.isEmpty()) {
            Balloon target = queue.poll();
            if (!target.isBorken) {
                arrow_cnt++;
                target.isBorken = true;
                nextBalloon.height = target.height - 1;
                nextBalloon.index = target.index + 1;
                // shoot next
                while (nextBalloon.height > 0 && nextBalloon.index <= end) {
                    LinkedList<Balloon> nextList = balloons.get(nextBalloon.height);
                    if (nextList != null) {
                        for (Balloon b : nextList) {
                            if (b.isBorken || b.index < nextBalloon.index) continue;
                            nextBalloon.height--;
                            b.isBorken = true;
                            break;
                        }
                        if (nextBalloon.index == end) {
                            while (end > 0 && balloonArray[end].isBorken) {
                                end--;
                            }
                        }
                    }
                    nextBalloon.index++;
                }
            }
        }
        System.out.println(arrow_cnt);

    }

    static class Balloon {
        int height;
        int index;
        boolean isBorken = false;

        Balloon(int h, int i) {
            height = h;
            index = i;
        }

        boolean equals(Balloon other) {
            return other.height == height && other.index == index;
        }
    }

    static class BalloonComparator implements Comparator<Balloon> {
        @Override
        public int compare(Balloon p0, Balloon p1) {
            return p1.height - p0.height;
        }
    }
}