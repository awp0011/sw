package sw.pro.SDS_PRO_5_4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class source {
    private static Node[] letters = new Node[26];

    public static void main(String[] args) throws Exception {
        for (int i = 0; i < 26; i++) {
            letters[i] = new Node();
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] str = br.readLine().toCharArray();
        //由小到大排序
        for (char c : str) letters[getIndex(c)].counter++;
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(Node::getCnt));
        Arrays.stream(letters).filter(node -> node.counter > 0).forEach(queue::add);

        //构造 Huffman Tree
        Node root = new Node();
        while (!queue.isEmpty()) {
            if (queue.size() == 1) {
                root = queue.poll();
            } else {
                Node p = new Node();
                p.left = queue.poll();
                p.right = queue.poll();
                p.counter = p.left.counter + p.right.counter;
                queue.add(p);
            }
        }
        //进行Huffman Coding
        makeCoding(root);
        int answer = 0;
        for (Node n : letters) {
            answer += n.length * n.counter;
        }
        System.out.println(answer);
        br.close();
    }

    private static void makeCoding(Node current) {
        if (current.left != null) {
            current.left.length = current.length + 1;
            makeCoding(current.left);
        }
        if (current.right != null) {
            current.right.length = current.length + 1;
            makeCoding(current.right);
        }
    }

    private static int getIndex(char c) {
        //(int) 'A' = 65;
        return (int) c - 65;
    }

    private static class Node {
        int counter = 0;
        int length = 0;
        Node left;
        Node right;

        int getCnt() {
            return counter;
        }
    }
}