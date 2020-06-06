package sw.luogu.stage5.P5744;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = parseInt(br.readLine());
        Stu[] students = new Stu[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            students[i] = new Stu(st.nextToken(), parseInt(st.nextToken()), parseInt(st.nextToken()));
            System.out.println(students[i].name + " " + students[i].age + " " + students[i].score);
        }
    }

    private static class Stu {
        String name;
        int age;
        int score;

        Stu(String n, int a, int s) {
            name = n;
            age = a + 1;
            score = s * 12 / 10;

            if (score > 600) score = 600;
        }
    }
}
