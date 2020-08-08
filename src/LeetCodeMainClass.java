import java.io.*;

public class LeetCodeMainClass {
    public static void main(String[] args) throws IOException {
        String myPackage = "two.sum";

        String templatePath = "C:\\workspace\\idea\\sw\\src\\javaTemplate.tmp";
        String packageName = "package sw.leetcode." + myPackage + ";";
        String basePath = "C:\\workspace\\idea\\sw\\src\\sw\\leetcode\\" + myPackage + "\\";
        String filename = "Main.java";
        File f1 = new File(basePath);
        if (!f1.exists()) f1.mkdirs();
        f1 = new File(basePath + filename);
        if (!f1.exists()) f1.createNewFile();
        PrintWriter pw = new PrintWriter(new FileOutputStream(f1.getAbsoluteFile()));
        pw.println(packageName);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(templatePath)));
        while (br.ready()) {
            pw.println(br.readLine());
        }
        pw.flush();
        pw.close();

    }
}
