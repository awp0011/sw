package sw.pro;


import java.util.*;

public class Test {

    private static HashMap<Integer, LinkedList<Integer>> meetings = new HashMap<>();

    public static void main(String[] args) throws Exception {
        Random rand = new Random();
        for (int i = 1; i < 3000; ) {
            int key = rand.nextInt(1000);
            LinkedList<Integer> set = meetings.getOrDefault(key, new LinkedList<>());
            int cnt = rand.nextInt(100);
            set.push(cnt);
            meetings.put(key, set);
            i += cnt;
        }
        //meetings.keySet();
        TreeSet<Integer> keys = new TreeSet<>();
        keys.addAll(meetings.keySet());
        for (int end : keys) {
            System.out.print(end + " ");
            LinkedList<Integer> set = meetings.get(end);
            while (!set.isEmpty()) {
                System.out.print(set.poll() + " ");
            }
            System.out.println();
        }
    }


}

