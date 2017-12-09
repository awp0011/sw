package sw.pro.SDS_PRO_10_4;
//Prim算法

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class source {
    private static int N, M;
    private static PriorityQueue<Line> queue = new PriorityQueue<>(Comparator.comparingInt(Line::getCost));
    private static Map<Integer, List<Line>> allLines = new HashMap<>(400_000);
    private static boolean[] visited;
    private static int counter = 1;
    private static long total = 0l;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N + 1];
        Arrays.fill(visited, false);
        M = Integer.parseInt(br.readLine());
        int s, e, c;

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            allLines.computeIfAbsent(s, v -> new ArrayList<>()).add(new Line(s, e, c));
            allLines.computeIfAbsent(e, v -> new ArrayList<>()).add(new Line(e, s, c));
        }
        br.close();
        visited[1] = true;
        queue.addAll(allLines.get(1));
        while (counter != N) {
            Line min = queue.poll();
            if (min != null && (visited[min.Start]) && (visited[min.End])) {
                continue;
            }
            //System.out.println("min--> "+min.toString());
            total += min.getCost();
            counter++;
            if (!visited[min.Start]) {
                queue.addAll(allLines.get(min.Start));
                visited[min.Start] = true;
            }
            if (!visited[min.End]) {
                queue.addAll(allLines.get(min.End));
                visited[min.End] = true;
            }

        }
        System.out.println(total);
    }

    private static class Line {
        int Start, End, Cost;

        Line(final int s, final int e, final int c) {
            Start = s;
            End = e;
            Cost = c;
        }

        int getCost() {
            return Cost;
        }
        public String toString(){
            return "S:"+Start+" E:"+End+" C:"+Cost;
        }
    }
}