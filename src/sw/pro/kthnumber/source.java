package sw.pro.kthnumber;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class source {

    private static int[] numbers = new int[5000005];
    private static int max = Integer.MIN_VALUE;
    private static int min = Integer.MAX_VALUE;
    private static int middle = 0;

    /*
    Arrays.sort()方法，如果数组长度大于等于286且连续性好的话，就用归并排序，
    如果大于等于286且连续性不好的话就用双轴快速排序。
    如果长度小于286且大于等于47的话就用双轴快速排序，
    如果长度小于47的话就用插入排序。真是有够绕的~
    * */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
            max = max < numbers[i] ? numbers[i] : max;
            min = min > numbers[i] ? numbers[i] : min;
        }
        if(N<10000){
            Arrays.sort(numbers,0,N);
        }else{
            quickSort(0, N, K - 1);
        }

        //if(pos_middle)
        //Arrays.sort(numbers);
        //System.out.println(Arrays.toString(numbers));
        System.out.print(numbers[K - 1]);
    }

    private static void quickSort(int start, int end, int target) {
        int pos_middle = end;
        int left = start;
        int right = pos_middle;
        middle = (max + min) >> 1;
        numbers[right] = middle;

       do{
            //System.out.println(Arrays.toString(numbers));
            pos_middle = sort(left, right, pos_middle);
            //System.out.print(Arrays.toString(numbers));
            //System.out.println("   middle:" + middle + "   POS:" + pos_middle);
            //System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            if (target > pos_middle) {
                left = pos_middle;
                min = middle;
                middle = (max + min) >> 1;
                numbers[left] = middle;
            } else {
                right = pos_middle;
                max = middle;
                middle = (max + min) >> 1;
                numbers[right] = middle;
            }

        } while (right - left != 2);

    }

    private static int sort(int left, int right, int pos) {
        int pos_middle = pos;
        while (left < right) {
            if (right == pos_middle) {
                if (numbers[left] > numbers[pos_middle]) {
                    swap(numbers, left, pos_middle);
                    pos_middle = left;
                    right--;
                } else {
                    left++;
                }

            } else {
                if (numbers[right] < numbers[pos_middle]) {
                    swap(numbers, right, pos_middle);
                    left++;
                    pos_middle = right;
                } else {
                    right--;
                }

            }
        }
        return pos_middle;
    }

    private static void swap(final int[] numbers, final int a, final int b) {
        int temp = numbers[a];
        numbers[a] = numbers[b];
        numbers[b] = temp;
    }
}
