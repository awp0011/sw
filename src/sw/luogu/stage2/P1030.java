package sw.luogu.stage2;

import java.util.Scanner;

public class P1030 {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String LDR = sc.next();//中序遍历
        String LRD = sc.next();//后续遍历
        DLR(LDR, LRD);
    }

    private static void DLR(String ldr, String lrd) {
        char root = lrd.charAt(lrd.length() - 1);
        System.out.print(root);
        if (lrd.length() == 1) return;
        int offset = ldr.indexOf(root);
        if (offset != 0) DLR(ldr.substring(0, offset), lrd.substring(0, offset));
        if (offset + 1 < ldr.length()) DLR(ldr.substring(offset + 1), lrd.substring(offset, lrd.length() - 1));
    }
}
