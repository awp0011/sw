package sw.adv.select.gift;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class source {
    private static int total, cnt, N, maxKind;
    private static int[] prices = new int[105];
    private static Deque<Integer> kinds = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            total = Integer.parseInt(st.nextToken());
            cnt = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            for (int i = 1; i <= N; i++) {
                prices[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(prices, 1, N + 1);
            maxKind = 0;
            selectGift();
            System.out.println("#" + t + " " + maxKind);
        }
    }

    private static int selectGift() {

        if (prices[0] > total || prices[N - 1] * cnt < total) return 0;
        int avg = total / cnt;
        int middle = -1;
        while (middle < 0) {
            middle = Arrays.binarySearch(prices, 1, N + 1, avg);
            avg--;
        }
        int left = middle == 1 ? 1 : middle - 1;
        int right = middle == N ? N : middle + 1;
        kinds.offer(prices[middle]);
        int sum = prices[middle];

        while (!(sum == total && kinds.size() == cnt)) {
            if (kinds.size() == cnt) {
                left++;
                sum -= kinds.pollLast();
                cnt--;
                if (sum > total) {
                    sum -= kinds.pollFirst();
                    right--;

                    sum += prices[left];
                    kinds.offerLast(prices[left]);
                    if (left != 1) left--;
                    if (sum > total) {
                        break;
                    }
                } else {
                    sum -= kinds.pollLast();
                    if (left != middle) left++;

                    sum += prices[right];
                    kinds.offerFirst(prices[right]);
                    if (right != N) right++;
                }
            } else {
                if (sum < total) {
                    sum += prices[right];
                    kinds.offerFirst(prices[right]);
                    if (right != N) right++;
                    cnt++;
                } else if (sum >= total) {
                    sum -= kinds.pollFirst();
                    right--;

                    sum += prices[left];
                    kinds.offerLast(prices[left]);
                    if (left != 1) left--;
                }
            }

        }
        if (sum == total) {
            int max = 0;
            Integer current = Integer.MAX_VALUE;
            while (!kinds.isEmpty()) {
                if (!current.equals(kinds.peek())) {
                    max++;
                }
                current = kinds.poll();
            }
            return max;
        } else {
            kinds.clear();
            return 0;
        }
    }

}
