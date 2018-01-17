package sw.pro.sunday;
//Sunday 算法
public class Test {
    public static void main(String[] args)  {
        //String haystack = "at the thought of";
        //String needle = "though";


        String haystack = "gagewgwe";
        String needle = "wefgwef";
        System.out.println(strStr(haystack,needle));
    }

    private static int strStr(String haystack, String needle) {
        int m = haystack.length(), n = needle.length();
        int[] occ = getOCC(needle);
        int jump ;
        for (int i = 0; i <= m - n; i += jump) {
            int j = 0;
            while (j < n && haystack.charAt(i + j) == needle.charAt(j))
                j++;
            if (j == n)
                return i;
            jump = i + n < m ? n - occ[haystack.charAt(i + n)] : 1;
        }
        return -1;
    }

    private static int[] getOCC(String p) {
        int[] occ = new int[128];
        for (int i = 0; i < occ.length; i++)
            occ[i] = -1;
        for (int i = 0; i < p.length(); i++)
            occ[p.charAt(i)] = i;
        return occ;
    }


}
