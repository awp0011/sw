package sw.contest.second.D273048;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Long.parseLong;
import static java.lang.Math.*;

public class MySolution {
    private static final char empty = '0';

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        do {
            System.out.println(execute(br).equals(execute(br)) ? "0" : "1");
        } while (br.ready());
        br.close();
    }


    private static Range execute(BufferedReader br) throws Exception {
        Range head = new Range(empty);
        Range tail = new Range(empty);
        join(head, new Range(1, 10_000_000_010L));
        join(head.next, tail);
        StringTokenizer st;
        long len;
        while (true) {
            st = new StringTokenizer(br.readLine());
            char operate = st.nextToken().charAt(0);
            if ('E' == operate) break;
            long pos = parseLong(st.nextToken()) - 1;
            Range next = head.next;
            len = max(next.length(), 1);
            while (pos >= len) {
                pos -= len;
                next = next.next;
                len = max(next.length(), 1);
            }
            if ('I' == operate) insert(next, pos, st.nextToken().charAt(0));
            else delete(next, pos);
        }

        return head;
    }

    private static void delete(final Range range, final long pos) {
        Range prve = range.prev;
        Range next = range.next;
        if (range.b == -1) {
            join(prve, next);
            //删除插入的字符后，相邻的若是两个连续的区间，需要合并
            if (prve.c == empty && next.c == empty && prve.e + 1 == next.b) {
                prve.e = next.e;
                join(prve, next.next);
            }
        } else {
            long s1 = range.b;
            long e1 = s1 + pos - 1;
            long s2 = s1 + pos + 1;
            long e2 = range.e;

            Range part1 = s1 <= e1 ? new Range(s1, e1) : null;
            Range part2 = s2 <= e2 ? new Range(s2, e2) : null;

            if (part1 != null && part2 != null) {
                join(prve, part1);
                join(part1, part2);
                join(part2, next);
            } else if (part1 != null) {
                join(prve, part1);
                join(part1, next);
            } else if (part2 != null) {
                join(prve, part2);
                join(part2, next);
            } else {
                join(prve, next);
            }
        }
    }

    private static void insert(final Range range, final long pos, final char c) {
        Range prve = range.prev;
        Range next = range.next;
        Range ins = new Range(c);

        if (range.b == -1) {//在新增的位置上再新增
            join(prve, ins);
            join(ins, range);
        } else {
            long s1 = range.b;
            long e1 = s1 + pos - 1;
            long s2 = s1 + pos ;
            long e2 = range.e;

            Range part1 = s1 <= e1 ? new Range(s1, e1) : null;
            Range part2 = s2 <= e2 ? new Range(s2, e2) : null;


            if (part1 != null && part2 != null) {
                join(prve, part1);
                join(part1, ins);
                join(ins, part2);
                join(part2, next);
            } else if (part1 != null) {
                join(prve, part1);
                join(part1, ins);
                join(ins, next);
            } else if (part2 != null) {
                join(prve, ins);
                join(ins, part2);
                join(part2, next);
            } else {
                join(prve, ins);
                join(ins, next);
            }
        }


    }

    private static void join(final Range l, final Range r) {
        l.next = r;
        r.prev = l;
    }

    static class Range {
        final long b;
        long e;
        final char c;
        Range prev;
        Range next;

        Range(final long begin, final long end) {
            b = begin;
            e = end;
            c = empty;
        }

        Range(char c) {
            b = -1;
            e = -1;
            this.c = c;
        }

        long length() {
            return e - b + 1;
        }

        boolean equals(Range other) {
            Range me = this;
            while (me != null) {
                if (other == null) return false;
                if (me.b != other.b || me.e != other.e || me.c != other.c) return false;
                me = me.next;
                other = other.next;
            }

            return other == null;

        }
    }
}
