package sw.contest.second.D273048;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Long.parseLong;
import static java.lang.Math.max;

public class Main {
    private static final char empty = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println(execute(br).equals(execute(br)) ? "0" : "1");
        } while (br.ready());


        br.close();
    }

    private static Range execute(BufferedReader br) throws Exception {
        Range first = new Range(empty);
        join(first, new Range(1, 100_000_000_000L));
        join(first.next, new Range(empty));


        StringTokenizer st ;
        while (true) {
            st = new StringTokenizer(br.readLine());
            char opt = st.nextToken().charAt(0);
            if (opt == 'E') break;
            long pos = parseLong(st.nextToken()) - 1;
            char c = opt == 'I' ? st.nextToken().charAt(0) : empty;
            Range nextOpt = first.next;
            long len = max(1, nextOpt.getLength());
            while (len <= pos) {
                pos -= len;
                nextOpt = nextOpt.next;
                len = max(1, nextOpt.getLength());
            }
            if (opt == 'I') insert(nextOpt, pos, c);
            else delete(nextOpt, pos);

        }

        return first;
    }
    private static void delete(Range n, long index) {
        Range prev = n.prev;
        Range next = n.next;

        if (n.s == -1) {
            join(prev, next);
            if (prev.c == empty && next.c == empty && prev.e + 1 == next.s) {
                prev.e = next.e;
                prev.next = next.next;
                next.next.prev = prev;
            }
        } else {
            long s1 = n.s;
            long e1 = n.s + index - 1;
            long s2 = n.s + index + 1;
            long e2 = n.e;

            Range part1 = s1 <= e1 ? new Range(s1, e1) : null;
            Range part2 = s2 <= e2 ? new Range(s2, e2) : null;

            if (part1 != null && part2 != null) {
                join(prev, part1);
                join(part1, part2);
                join(part2, next);
            } else if (part1 != null) {
                join(prev, part1);
                join(part1, next);
            } else if (part2 != null) {
                join(prev, part2);
                join(part2, next);
            } else {
                join(prev, next);
            }
        }
    }

    private static void insert(Range n, long index, char ch) {
        Range prev = n.prev;
        Range next = n.next;
        Range ins = new Range(ch);

        if (n.s == -1) {
            join(prev, ins);
            join(ins, n);
        } else {
            long s1 = n.s;
            long e1 = n.s + index - 1;
            long s2 = n.s + index;
            long e2 = n.e;

            Range part1 = s1 <= e1 ? new Range(s1, e1) : null;
            Range part2 = s2 <= e2 ? new Range(s2, e2) : null;

            if (part1 != null && part2 != null) {
                join(prev, part1);
                join(part1, ins);
                join(ins, part2);
                join(part2, next);
            } else if (part1 != null) {
                join(prev, part1);
                join(part1, ins);
                join(ins, next);
            } else if (part2 != null) {
                join(prev, ins);
                join(ins, part2);
                join(part2, next);
            } else {
                join(prev, ins);
                join(ins, next);
            }
        }
    }

    private static void join(Range l, Range r) {
        l.next = r;
        r.prev = l;
    }

    static class Range {
        long s = -1;
        long e = -1;
        char c = empty;
        Range prev;
        Range next;

        Range(long start, long end) {
            this.s = start;
            this.e = end;
        }

        Range(char ch) {
            this.c = ch;
        }

        long getLength() {
            return e - s + 1;
        }

        boolean equals(Range o) {
            Range m = this;
            while (m != null) {
                if (o == null) return false;
                if (m.c != o.c || m.s != o.s || m.e != o.e) return false;
                m = m.next;
                o = o.next;
            }
            return o == null;
        }
    }
}