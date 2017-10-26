package sw.pro.SDS_PRO_4_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Dijkstra {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(br.readLine());
        int answer = 0;
        Graph graph = new Graph(N);
        int xi, yi, zi;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            xi = Integer.parseInt(st.nextToken());
            yi = Integer.parseInt(st.nextToken());
            zi = Integer.parseInt(st.nextToken());
            graph.addPath(new Path(xi, yi, zi));
        }
        Path[] distance = new Path[N + 1];
        PriorityQueue<Path> queue = new PriorityQueue<Path>(idComparator);
        
        bfs(queue, graph, distance, 1);
        if (distance[T].length == Integer.MAX_VALUE) {
            System.out.println("NO");
        } else {
            answer = distance[T].length;
            // System.out.println("1>T:" + answer);
            bfs(queue, graph, distance, T);
            if (distance[1].length == Integer.MAX_VALUE) {
                System.out.println("NO");
            } else {
                answer += distance[1].length;
                System.out.println("YES");
                System.out.println(answer);
            }
        }
        
    }
    
    static void bfs(PriorityQueue<Path> queue, Graph g, Path[] distance, int start) {
        queue.clear();
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] == null) {
                distance[i] = new Path(0, i, Integer.MAX_VALUE);
            } else {
                distance[i].length = Integer.MAX_VALUE;
                distance[i].isUsed = false;
            }
        }
        
        for (Path island : g.map.get(start)) {
            distance[island.to].length = island.length;
            queue.offer(distance[island.to]);
        }
        distance[start].isUsed = true;
        
        while (queue.size() != 0) {
            Path p = queue.poll();
            // System.out.print("-->" + p.to);
            if (p.isUsed) {
                // System.out.print("(continue)");
                continue;
            } else if (p.length == Integer.MAX_VALUE) {
                // System.out.print("(break)");
                break;
            } else {
                // System.out.print("(next)");
                p.isUsed = true;
                search(queue, distance, p.to, g);
            }
            
        }
        // System.out.println("");
    }
    
    static void search(PriorityQueue<Path> queue, Path[] distance, final int start, Graph g) {
        for (Path island : g.map.get(start)) {
            if (distance[island.to].length > distance[start].length + island.length) {
                distance[island.to].length = distance[start].length + island.length;
            }
            if (!distance[island.to].isUsed) {
                queue.offer(distance[island.to]);
            }
        }
    }
    
    static class Graph {
        List<LinkedList<Path>> map;
        
        Graph(int n) {
            map = new ArrayList<LinkedList<Path>>(n + 1);
            for (int i = 0; i <= n; i++) {
                map.add(new LinkedList<Path>());
            }
        }
        
        void addPath(Path p) {
            Optional<Path> maybe = map.get(p.from).stream()
                    .filter(island -> island.from == p.from && island.to == p.to).findFirst();
            if (maybe.isPresent()) {
                Path existed = maybe.get();
                if (existed.length > p.length) {
                    existed.length = p.length;
                }
            } else {
                map.get(p.from).add(p);
            }
            
        }
        
    }
    
    static class Path {
        Path(final int s, final int e, final int l) {
            from = s;
            to = e;
            length = l;
        }
        
        int        from, to, length;
        boolean    isUsed;
    }
    
    // 匿名Comparator实现
    public static Comparator<Path> idComparator = new Comparator<Path>() {
        
        @Override
        public int compare(Path c1, Path c2) {
            return (int) (c1.length - c2.length);
        }
    };
}
