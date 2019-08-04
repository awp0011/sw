package sw.pro.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class BinaryIndexedTree {
    private long[] bitArr;

    public BinaryIndexedTree(long[] list) {
        // O(n) initialization
        this.bitArr = new long[list.length + 5];


        for (int i = 1; i <= this.bitArr.length; i++) {
            this.bitArr[i] = list[i - 1];
            int j = i + (i & -i);
            if (j < this.bitArr.length) {
                this.bitArr[j] += list[i - 1];
            }
        }
    }

    /**
     * Add `delta` to elements in `idx` of original array
     *
     * @param idx   index of the element in original array that is going to be updated
     * @param delta number that will be added to the original element.
     */
    public void update(int idx, long delta) {
        idx += 1;
        while (idx < this.bitArr.length) {
            this.bitArr[idx] += delta;
            idx = idx + (idx & -idx);
        }
    }

    /**
     * Get the sum of elements in the original array up to index `idx`
     *
     * @param idx index of the last element that should be summed.
     * @return sum of elements from index 0 to `idx`.
     */
    public int prefixSum(int idx) {
        idx += 1;
        int result = 0;
        while (idx > 0) {
            result += this.bitArr[idx];
            idx = idx - (idx & -idx);
        }

        return result;
    }

    /**
     * Get the range sum of elements from original array from index `from_idx` to `to_idx`
     *
     * @param from_idx start index of element in original array
     * @param to_idx   end index of element in original array
     * @return range sum of elements from index `from_idx` to `to_idx`
     */
    public int rangeSum(int from_idx, int to_idx) {
        return prefixSum(to_idx) - prefixSum(from_idx - 1);
    }

    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = parseInt(br.readLine());
        int Q = parseInt(br.readLine());

        long[] arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }
        BinaryIndexedTree bit = new BinaryIndexedTree(arr);
        for (int i = 0; i < Q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = parseInt(st.nextToken());

            if (c == 0) {
                int x = parseInt(st.nextToken());
                long y = Long.parseLong(st.nextToken());
                long diff = y - arr[x];
                bit.update(x, diff);
                arr[x] = y;

            } else {
                sb.append(bit.rangeSum(parseInt(st.nextToken()), parseInt(st.nextToken()))).append('\n');
            }
        }
        System.out.println(sb.toString());
    }
}

