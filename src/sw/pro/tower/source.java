package sw.pro.tower;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class source {
    //static int[] towers = new int[500_005];
    private static Tower first = new Tower(0, 0);
    private static Tower lastest = new Tower(500_005, 0);

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Tower current = new Tower(1, Integer.parseInt(st.nextToken()));
        join(first, current, lastest);
        for (int i = 2; i <= N; i++) {
            Tower aNew = new Tower(i, Integer.parseInt(st.nextToken()));
            join(lastest.left, aNew, lastest);
            aNew.findReceiver();
        }


        StringBuilder sb = new StringBuilder(2 * N);
        current = first.right;
        do {
            sb.append(current.getReceiver().getPosition()).append(" ");
            current = current.right;
        } while (current.getPosition() != 500_005);
        System.out.println(sb.toString());
    }

    private static class Tower {
        public Tower left;
        public Tower right;
        private Tower receiver;
        private int position;
        private int height;


        Tower(final int p, final int h) {
            position = p;
            height = h;
            receiver = first;
        }

         int getPosition() {
            return position;
        }

         int getHeight() {
            return height;
        }

         Tower getReceiver() {
            return receiver;
        }

         void findReceiver() {
            if (null != left) {
                Tower nextLeft = left;
                while (nextLeft.getPosition() != 0) {

                    if (nextLeft.getHeight() > height) {
                        receiver = nextLeft;
                        break;
                    }else if(nextLeft.getReceiver().getHeight()>height){
                        receiver = nextLeft.getReceiver();
                        break;
                    }
                    nextLeft = nextLeft.left;
                }
            }
        }
    }

    private static void join(Tower left, Tower aNew, Tower right) {
        left.right = aNew;
        aNew.left = left;
        aNew.right = right;
        right.left = aNew;
    }
}
