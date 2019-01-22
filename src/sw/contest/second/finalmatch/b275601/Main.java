package sw.contest.second.finalmatch.b275601;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static final ArrayList<Integer> uncrossed = new ArrayList<Integer>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                uncrossed.add(Integer.valueOf(st.nextToken()));
            }
            //to-do uncrossed 排序
            //
            int shortest = 0;
            Integer leftSmall = uncrossed.remove(0);
            Integer rightSmall = uncrossed.remove(0);
            Integer op1, op2, op3, op4;
            while (true) {
                if (shortest == 0) {
                    shortest += leftSmall + rightSmall;
                } else if (uncrossed.size() > 1) {//河左岸 剩余人数多于2

                    op1 = leftSmall;
                    op2 = uncrossed.remove(uncrossed.size() - 1);
                    op3 = uncrossed.remove(uncrossed.size() - 1);
                    op4 = rightSmall;

                    Integer temp1 = 2 * op1 + op2 + op3;
                    Integer temp2 = Math.max(op2, op3) + op4;

                    if (temp1 > temp2) {
                        shortest += temp2;
                        if (uncrossed.size() > 1) shortest += uncrossed.remove(uncrossed.size() - 1);

                        Integer temp = leftSmall;
                        leftSmall = rightSmall;
                        rightSmall = temp;


                    } else {
                        shortest += temp1;
                    }
                } else if (uncrossed.size() == 1) {//河左岸 剩余2个人
                    shortest += Math.max(uncrossed.get(0), leftSmall);
                    uncrossed.clear();
                } else {//河左岸 剩余1个人
                    shortest += Math.max(rightSmall, leftSmall);
                    break;
                }
            }
            System.out.println(shortest);
        }


    }
}