package sw.contest.second.D273048;


import java.io.*;
import java.util.*;

public class LongLongStrings2 {
    PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

    public void go() {
        LinkedList<Operation> ops1 = new LinkedList<>();
        while (true) {
            char op = in.next().charAt(0);
            if (op == 'E') {
                break;
            } else if (op == 'I') {
                long i = in.nextLong();
                char c = in.next().charAt(0);
                Iterator<Operation> it = ops1.iterator();
                int off = 0;
                boolean removed = false;
                while (it.hasNext()) {
                    Operation o = it.next();
                    if (o.i > i) {
                        o.i++;
                    } else if (o.i == i) {
                        o.i++;
                    }
                }
                if (!removed) {
                    Operation newOp = new Operation(false, i + off, c);
                    ops1.add(newOp);
                }
            } else {
                long i = in.nextLong();
                Iterator<Operation> it = ops1.iterator();
                int off = 0;
                boolean removed = false;
                while (it.hasNext()) {
                    Operation o = it.next();
                    if (o.i > i) {
                        o.i--;
                    } else if (o.i == i) {
                        if (!o.isDelete) {
                            removed = true;
                            it.remove();
                        }
                    }
                }
                if (!removed) {
                    Operation newOp = new Operation(true, i + off, ';');
                    ops1.add(newOp);
                }
            }
        }

        LinkedList<Operation> ops2 = new LinkedList<>();
        while (true) {
            char op = in.next().charAt(0);
            if (op == 'E') {
                break;
            } else if (op == 'I') {
                long i = in.nextLong();
                char c = in.next().charAt(0);
                Iterator<Operation> it = ops2.iterator();
                int off = 0;
                boolean removed = false;
                while (it.hasNext()) {
                    Operation o = it.next();
                    if (o.i > i) {
                        o.i++;
                    } else if (o.i == i) {
                        o.i++;
                    }
                }
                if (!removed) {
                    Operation newOp = new Operation(false, i + off, c);
                    ops2.add(newOp);
                }
            } else {
                long i = in.nextLong();
                Iterator<Operation> it = ops2.iterator();
                int off = 0;
                boolean removed = false;
                while (it.hasNext()) {
                    Operation o = it.next();
                    if (o.i > i) {
                        o.i--;
                    } else if (o.i == i) {
                        if (!o.isDelete) {
                            removed = true;
                            it.remove();
                        }
                    }
                }
                if (!removed) {
                    Operation newOp = new Operation(true, i + off, ';');
                    ops2.add(newOp);
                }
            }
        }

        Collections.sort(ops1);
        Collections.sort(ops2);

        Iterator<Operation> it = ops1.iterator();
        long last = 0;
        while (it.hasNext()) {
            Operation curr = it.next();
            if (!curr.isDelete) {
                last = curr.i;
            } else if (last == curr.i) {
                it.remove();
            }
        }
        it = ops2.iterator();
        last = 0;
        while (it.hasNext()) {
            Operation curr = it.next();
            if (!curr.isDelete) {
                last = curr.i;
            } else if (last == curr.i) {
                it.remove();
            }
        }


        // out.println(ops1);
        // out.println(ops2);

        if (ops1.equals(ops2)) {
            out.println(0);
        } else {
            out.println(1);
        }

        out.flush();
        in.close();
    }

    public static void main(String[] args) {
        new LongLongStrings2().go();
    }

    private class Operation implements Comparable<Operation> {
        boolean isDelete;
        char c;
        long i;

        public Operation(boolean del, long i, char c) {
            isDelete = del;
            this.i = i;
            this.c = c;
        }

        public int compareTo(Operation other) {
            if (i == other.i) {
                return Boolean.compare(isDelete, other.isDelete);
            }
            return Long.compare(i, other.i);
        }

        public boolean equals(Object obj) {
            if (obj instanceof Operation) {
                Operation other = (Operation) obj;
                return isDelete == other.isDelete && c == other.c && i == other.i;
            }
            return false;
        }

        public String toString() {
            if (isDelete) {
                return String.format("D %d", i);
            } else {
                return String.format("I %d %c", i, c);
            }
        }
    }
}