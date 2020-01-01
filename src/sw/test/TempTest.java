package sw.test;


import java.util.HashMap;

class Main {

    public static void main(String[] args) {
        HashMap<String, Integer> g = new HashMap<>();
        System.out.println(g.remove("111"));
        g.put("111",111);
        System.out.println(g.remove("111"));
    }
}