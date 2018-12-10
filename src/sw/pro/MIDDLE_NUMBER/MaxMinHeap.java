package sw.pro.MIDDLE_NUMBER;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.PriorityQueue;


public class MaxMinHeap {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        //存放大于等于中位数的数
        PriorityQueue<Integer> min = new PriorityQueue<>((N >> 1) + 1);
        //存放小于等于中位数的数
        PriorityQueue<Integer> max = new PriorityQueue<>((N >> 1) + 1, Comparator.reverseOrder());
        int median = Integer.parseInt(br.readLine());
        bw.write(median + "");
        bw.newLine();
        for (int i = 1; i < N; i++) {
            int next = Integer.parseInt(br.readLine());
            if (next < median) max.add(next);
            else min.add(next);
            if (Math.abs(max.size() - min.size()) == 2) {
                if (max.size() > min.size()) {
                    min.add(median);
                    if (max.peek() != null) median = max.poll();
                } else {
                    max.add(median);
                    if (min.peek() != null) median = min.poll();
                }
            }
            if (i % 2 == 0) {
                bw.write(median + "");
                bw.newLine();
            }
            if (i % 1000 == 0) bw.flush();
        }

        bw.flush();
        bw.close();
        br.close();

    }
}
/*
 *
 * 1、创建两个堆（一个小根堆、一个大根堆），堆大小至少为给定数据个数的一半，(size+1)/2，即向上取整；
 * 2、假定变量mid用来保存中位数，取定第一个元素，赋值给mid，即作为初始的中位数；
 * 3、依次遍历后面的每一个数据，如果比mid小，则插入大根堆；否则插入小根堆；
 * 4、如果大根堆和小根堆上的数据个数相差为2，则将mid插入到元素个数较少的堆中，然后从元素个数较多的堆中删除根节点，并将跟节点赋值给mid；
 * 5、重复步骤3和4，直到所有的数据遍历结束；
 * 此时，mid保存了一个数，再加上两个堆中保存的数，就构成了给定数据的集合。
 * 如果两个堆中元素个数相等，则mid即为最终的中位数；否则，元素较多的堆的根节点元素与mid的和求平均值，即为最终的中位数。
 *
 * */