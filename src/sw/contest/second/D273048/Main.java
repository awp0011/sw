package sw.contest.second.D273048;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

import static java.lang.Long.parseLong;
import static java.lang.Math.abs;
import static java.util.Collections.binarySearch;
import static java.util.Comparator.comparing;

public class Main {
    public static void main(String[] args) throws Exception {
        ArrayList<Opt> delList_1 = new ArrayList<>(2200);
        ArrayList<Opt> delList_2 = new ArrayList<>(2200);
        ArrayList<Opt> insList_1 = new ArrayList<>(2200);
        ArrayList<Opt> insList_2 = new ArrayList<>(2200);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int cnt = 22;
        while (cnt > 0) {
            exec(delList_1, insList_1, br);
            exec(delList_2, insList_2, br);
            System.out.println(isSame(delList_1, delList_2, insList_1, insList_2) ? 0 : 1);
            delList_1.clear();
            delList_2.clear();
            insList_1.clear();
            insList_2.clear();
            cnt--;
        }
    }

    private static void exec(List<Opt> delList, List<Opt> insList, BufferedReader br) throws Exception {
        StringTokenizer st;
        char next;
        while (true) {
            st = new StringTokenizer(br.readLine());
            if (st.countTokens() == 0) break;
            next = st.nextToken().charAt(0);
            if ('D' == next) {
                Opt delOpt = new Opt();
                delOpt.pos = parseLong(st.nextToken());
                if (delIns(delOpt, insList)) continue;
                int pos = binarySearch(delList, delOpt, comparing(Opt::getPos));
                if (pos < 0) pos = abs(pos + 1);
                delOpt.pos += pos;
                delList.add(pos, delOpt);

            } else if ('I' == next) {
                Opt insOpt = new Opt();
                insOpt.pos = parseLong(st.nextToken());
                insOpt.c = st.nextToken().charAt(0);
                int pos = binarySearch(insList, insOpt, comparing(Opt::getPos));
                if (pos < 0) pos = abs(pos + 1);
                insList.add(pos, insOpt);

                for (int i = pos + 1; i < insList.size(); i++) {
                    insList.get(i).pos += 1;
                }
            } else {
                break;
            }
        }
    }

    private static boolean delIns(Opt del, List<Opt> insList) {
        int index = binarySearch(insList, del, comparing(Opt::getPos));
        if (index < 0) return false;
        else insList.remove(index);
        return true;
    }

    private static boolean isSame(List<Opt> delList1, List<Opt> delList2, List<Opt> insList1, List<Opt> insList2) {
        if (delList1.size() != delList2.size() || insList1.size() != insList2.size()) return false;
        for (int i = 0; i < delList1.size(); i++) {
            if (delList1.get(i) == null || delList2.get(i) == null) return false;
            if (delList1.get(i).pos != delList2.get(i).pos) return false;
        }
        for (int i = 0; i < insList1.size(); i++) {
            if (insList2.get(i) == null || insList1.get(i) == null) return false;
            if (insList1.get(i).pos != insList2.get(i).pos) return false;
            else if (insList1.get(i).c != insList2.get(i).c) return false;
        }
        return true;
    }

    private static class Opt {
        long pos = 0;
        char c = '0';

        long getPos() {
            return pos;
        }
    }
}