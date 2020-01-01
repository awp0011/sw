package sw.luogu.match;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P5266 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<String, Integer> g = new HashMap<>();
        int cnt = 0, t, s;
        String name;
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            t = Integer.parseInt(st.nextToken());
            switch (t) {
                case 1:
                    name = st.nextToken();
                    if (!g.containsKey(name)) cnt++;
                    s = Integer.parseInt(st.nextToken());
                    g.put(name, s);
                    ans.append("OK").append('\n');
                    break;
                case 2:
                    name = st.nextToken();
                    ans.append(g.containsKey(name) ? g.get(name) : "Not found").append('\n');
                    break;
                case 3:
                    name = st.nextToken();
                    if (g.containsKey(name)) cnt--;
                    ans.append(g.containsKey(name) ? "Deleted successfully" : "Not found").append('\n');
                    g.remove(name);
                    break;
                default:
                    ans.append(cnt).append('\n');
            }
        }

        System.out.println(ans.toString());
    }
}
