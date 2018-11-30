package sw.contest.second.D273048;

import java.util.Scanner;

public class LongLongStrings {
    public static final char NULL = '\0';
    public static final long oo = (long)1e11;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Node a = doIt(scan), b = doIt(scan);
        scan.close();

        System.out.println(a.equals(b) ? "0" : "1");
    }

    public static Node doIt(Scanner scan) {
        Node head = new Node(NULL);
        head.next = new Node(1L, oo);
        head.next.prev = head;
        head.next.next = new Node(NULL);
        head.next.next.prev = head.next;

        while(true) {
            char c = scan.next().charAt(0);
            if(c == 'E')
                break;

            long index = scan.nextLong() - 1L;
            char ch = c == 'I' ? scan.next().charAt(0) : NULL;
            Node n = head.next;
            while(true) {
                long len = Math.max(1L, n.end - n.start + 1L);
                if(len <= index) {
                    index -= len;
                    n = n.next;
                    continue;
                }

                if(ch == NULL)
                    delete(n, index);
                else
                    insert(n, index, ch);

                break;
            }
        }

        return head;
    }

    public static void delete(Node n, long index) {
        Node prev = n.prev;
        Node next = n.next;

        if(n.start == -1L) {
            prev.next = next;
            next.prev = prev;

            //re-unify segments if appropriate
            if(prev.ch == NULL && next.ch == NULL && prev.end + 1 == next.start) {
                prev.end = next.end;
                prev.next = next.next;
                next.next.prev = prev;
            }
        } else {
            long start1 = n.start;
            long end1 = n.start + index - 1L;
            long start2 = n.start + index + 1L;
            long end2 = n.end;

            Node first = start1 <= end1 ? new Node(start1, end1) : null;
            Node last = start2 <= end2 ? new Node(start2, end2) : null;

            if(first != null && last != null) {
                prev.next = first;
                first.prev = prev;
                first.next = last;
                last.prev = first;
                last.next = next;
                next.prev = last;
            } else if(first != null) {
                prev.next = first;
                first.prev = prev;
                first.next = next;
                next.prev = first;
            } else if(last != null) {
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

    public static void insert(Node n, long index, char ch) {
        Node prev = n.prev;
        Node next = n.next;
        Node ins = new Node(ch);

        if(n.start == -1L) {
            prev.next = ins;
            ins.prev = prev;
            ins.next = n;
            n.prev = ins;
        } else {
            long start1 = n.start;
            long end1 = n.start + index - 1L;
            long start2 = n.start + index;
            long end2 = n.end;

            Node first = start1 <= end1 ? new Node(start1, end1) : null;
            Node last = start2 <= end2 ? new Node(start2, end2) : null;

            if(first != null && last != null) {
                prev.next = first;
                first.prev = prev;
                first.next = ins;
                ins.prev = first;
                ins.next = last;
                last.prev = ins;
                last.next = next;
                next.prev = last;
            } else if(first != null) {
                prev.next = first;
                first.prev = prev;
                first.next = ins;
                ins.prev = first;
                ins.next = next;
                next.prev = ins;
            } else if(last != null) {
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

    public static class Node {
        public long start, end;
        public char ch;
        public Node prev, next;

        public Node(long start, long end) {
            this.start = start;
            this.end = end;
            this.ch = NULL;
        }

        public Node(char ch) {
            this.start = -1L;
            this.end = -1L;
            this.ch = ch;
        }

        @Override
        public boolean equals(Object obj) {
            if(!(obj instanceof Node))
                return false;

            Node a = this;
            Node b = (Node)obj;

            while(a != null) {
                if(b == null)
                    return false;

                if(a.ch != b.ch || a.start != b.start || a.end != b.end)
                    return false;

                a = a.next;
                b = b.next;
            }

            return b == null;
        }
    }
}