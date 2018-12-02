package sw.contest.second.D273048;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Long.*;

public class MainV2 {
    private static final char NONE = 0;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Opt first = execute(br), second = execute(br);
        br.close();
        System.out.println(first.equals(second) ? "0" : "1");
    }

    private static Opt execute(BufferedReader br) throws Exception {
        Opt head = new Opt(NONE);
        head.next = new Opt(1L,100_000_000_000L);
        head.next.prev = head;
        head.next.next = new Opt(NONE);
        head.next.next.prev = head.next;
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (true) {
            char optChar = st.nextToken().charAt(0);
            if (optChar == 'E') break;

            long pos = parseLong(st.nextToken()) - 1L;
            char c = optChar == 'I' ? st.nextToken().charAt(0) : NONE;
            Opt nextOpt = head.next;
            while (true) {
                long len = Math.max(1L, nextOpt.end - nextOpt.start + 1L);
                if (len <= pos) {
                    pos -= len;
                    nextOpt = nextOpt.next;
                    continue;
                }

                if (c == NONE)
                    delete(nextOpt, pos);
                else
                    insert(nextOpt, pos, c);

                break;
            }
            st = new StringTokenizer(br.readLine());
        }

        return head;
    }

    private static void delete(Opt n, long index) {
        Opt prev = n.prev;
        Opt next = n.next;

        if (n.start == -1L) {
            prev.next = next;
            next.prev = prev;

            if (prev.ch == NONE && next.ch == NONE && prev.end + 1 == next.start) {
                prev.end = next.end;
                prev.next = next.next;
                next.next.prev = prev;
            }
        } else {
            long start1 = n.start;
            long end1 = n.start + index - 1L;
            long start2 = n.start + index + 1L;
            long end2 = n.end;

            Opt first = start1 <= end1 ? new Opt(start1, end1) : null;
            Opt last = start2 <= end2 ? new Opt(start2, end2) : null;

            if (first != null && last != null) {
                prev.next = first;
                first.prev = prev;
                first.next = last;
                last.prev = first;
                last.next = next;
                next.prev = last;
            } else if (first != null) {
                prev.next = first;
                first.prev = prev;
                first.next = next;
                next.prev = first;
            } else if (last != null) {
                prev.next = last;
                last.prev = prev;
                last.next = next;
                next.prev = last;
            } else {
                prev.next = next;
                next.prev = prev;
            }
        }
    }

    private static void insert(Opt n, long index, char ch) {
        Opt prev = n.prev;
        Opt next = n.next;
        Opt ins = new Opt(ch);

        if (n.start == -1L) {
            prev.next = ins;
            ins.prev = prev;
            ins.next = n;
            n.prev = ins;
        } else {
            long start1 = n.start;
            long end1 = n.start + index - 1L;
            long start2 = n.start + index;
            long end2 = n.end;

            Opt first = start1 <= end1 ? new Opt(start1, end1) : null;
            Opt last = start2 <= end2 ? new Opt(start2, end2) : null;

            if (first != null && last != null) {
                prev.next = first;
                first.prev = prev;
                first.next = ins;
                ins.prev = first;
                ins.next = last;
                last.prev = ins;
                last.next = next;
                next.prev = last;
            } else if (first != null) {
                prev.next = first;
                first.prev = prev;
                first.next = ins;
                ins.prev = first;
                ins.next = next;
                next.prev = ins;
            } else if (last != null) {
                prev.next = ins;
                ins.prev = prev;
                ins.next = last;
                last.prev = ins;
                last.next = next;
                next.prev = last;
            } else {
                prev.next = ins;
                ins.prev = prev;
                ins.next = next;
                next.prev = ins;
            }
        }
    }

    static class Opt {
        final long start;
        long end;
        char ch;
        Opt prev;
        Opt next;

        Opt(long start, long end) {
            this.start = start;
            this.end = end;
        }

        Opt(char ch) {
            this.start = -1L;
            this.end = -1L;
            this.ch = ch;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Opt))
                return false;

            Opt a = this;
            Opt b = (Opt) obj;

            while (a != null) {
                if (b == null)
                    return false;

                if (a.ch != b.ch || a.start != b.start || a.end != b.end)
                    return false;

                a = a.next;
                b = b.next;
            }

            return b == null;
        }
    }
}
