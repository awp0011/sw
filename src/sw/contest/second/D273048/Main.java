package sw.contest.second.D273048;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final List<Opt> del1 = new ArrayList<>(2000);
    private static final List<Opt> del2 = new ArrayList<>(2000);
    private static final List<Opt> ins1 = new ArrayList<>(2000);
    private static final List<Opt> ins2 = new ArrayList<>(2000);

    public static void main(String[] args) throws Exception {
        exec(1);
        exec(2);
        System.out.println(isSame() ? 1 : 0);
        br.close();
    }

    private static void exec(int flag) throws Exception {
        List<Opt> del = flag == 1 ? del1 : del2;
        List<Opt> ins = flag == 1 ? ins1 : ins2;
//Collections.binarySearch(del1, new DNA(), Comparator.comparing(Opt::getPos));
        StringTokenizer st;
        char next;
        while (true) {
            st = new StringTokenizer(br.readLine());
            next = st.nextToken().charAt(0);
            if ('D' == next) {

            } else if ('I' == next) {

            } else {
                break;
            }
        }
    }

    private static boolean isSame() {
        return true;
    }

    private static class Opt {
        long pos;
        char c;
        Opt left;
        Opt right;

        long getPos() {
            return pos;
        }
    }

}
