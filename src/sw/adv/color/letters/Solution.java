package sw.adv.color.letters;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
    private final static Word[] words = new Word[203];
    private final static CharLetter[] charLetters = new CharLetter[26];
    private final static char ZERO = 'a';
    private final static int SECOND = 'e' - ZERO;
    private final static int THIRD = 'i' - ZERO;
    private final static int FOURTH = 'o' - ZERO;
    private final static int FIFTH = 'u' - ZERO;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {

            int N = Integer.parseInt(br.readLine());
            for (int i = 0; i < 26; i++) {
                charLetters[i] = new CharLetter(i);
            }
            charLetters[0] = null;
            charLetters[SECOND] = null;
            charLetters[THIRD] = null;
            charLetters[FOURTH] = null;
            charLetters[FIFTH] = null;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                words[i] = new Word(st.nextToken());
                for (CharLetter cl : charLetters) {
                    if (cl != null) cl.add(words[i]);
                }
            }
            int min_cnt = 0;
            while (N > 0) {
                int index = getMaxIndex();
                N -= charLetters[index].getCnt();
                charLetters[index].color();
                for (CharLetter cl : charLetters) {
                    if (cl != null && cl.getCnt() > 0) cl.clearColor();
                }
                min_cnt++;
            }

            System.out.println("#" + t + " " + min_cnt);
        }
    }

    private static int getMaxIndex() {
        int index = 1, cnt = 0;
        for (CharLetter cl : charLetters) {
            if (cl != null && cl.getCnt() > cnt) {
                index = cl.getId();
                cnt = cl.getCnt();
            }
        }
        return index;
    }

    private static class CharLetter {
        private final int id;
        final Queue<Word> head;

        CharLetter(int i) {
            id = i;
            head = new LinkedList<>();
        }

        int getId() {
            return id;
        }

        void add(Word w) {
            if (w.isContained(id)) {
                head.add(w);
            }
        }

        int getCnt() {
            return head.size();
        }

        void color() {
            while (!head.isEmpty()) head.poll().color();
        }

        void clearColor() {
            int cnt = head.size();
            while (cnt != 0 && head.peek() != null) {
                Word w = head.poll();
                if (!w.hasColor()) {
                    head.add(w);
                }
                cnt--;
            }
        }

    }

    private static class Word {
        private final boolean[] letters;
        private boolean isColor;

        Word(String w) {
            letters = new boolean[26];
            for (char c : w.toCharArray()) {
                letters[c - ZERO] = true;
            }
        }

        void color() {
            isColor = true;
        }

        boolean hasColor() {
            return isColor;
        }

        boolean isContained(int l) {
            return letters[l];
        }
    }
}
