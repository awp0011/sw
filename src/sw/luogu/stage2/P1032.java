package sw.luogu.stage2;

import java.io.FileInputStream;
import java.util.Scanner;

public class P1032 {
    private static int length, found, index = 0, offset = 0;
    private static final String[][] rules = new String[6][2];
    private static StringBuffer middle = new StringBuffer();
    private static String end;

    public static void main(String[] args) throws Exception {
        System.setIn(new FileInputStream("C:\\Users\\peng0\\Documents\\Downloads\\testdata (3).in"));
        Scanner sc = new Scanner(System.in);
        String begin = sc.next();
        end = sc.next();
        int pos = 0;
        while (pos < begin.length() && pos < end.length()) {
            if (begin.charAt(pos) != end.charAt(pos)) break;
            pos++;
        }
        if (pos > 0 && begin.length() > pos) {
            begin = begin.substring(pos);
            end = end.substring(pos);
        }
        length = end.length();
        while (sc.hasNext()) {
            rules[index][offset] = sc.next();
            index += offset;
            offset++;
            offset %= 2;
        }
        found = 0;
        find(begin, 0);
        if (found == 0) System.out.println("NO ANSWER!");
    }

    private static void find(String cur, int step) {
        if (found == 1 || step > 10) return;
        if (cur.equals(end)) {
            System.out.println(step);
            found = 1;
        }
        for (int i = 0; i < index; i++) {
            if (cur.length() > length && rules[i][0].length() < rules[i][1].length()) continue;
            if (cur.length() < length && rules[i][0].length() > rules[i][1].length()) continue;
            int start = cur.indexOf(rules[i][0]);
            if (start >= 0) {
                middle.setLength(0);
                int j = 0;
                for (; j < start; j++) middle.append(cur.charAt(j));
                middle.append(rules[i][1]);
                j += rules[i][0].length();
                for (; j < cur.length(); j++) middle.append(cur.charAt(j));
                find(middle.toString(), step + 1);
            }
        }
    }
}
