import java.io.*;

public class ProductMailClass {
    public static void main(String[] args) throws IOException {
        String myPackage = "P1102";

        String templatePath = "E:\\IdeaProjects\\sw\\src\\javaTemplate.tmp";
        String packageName = "package sw.luogu.stage5." + myPackage + ";";
        String basePath = "E:\\IdeaProjects\\sw\\src\\sw\\luogu\\stage5\\" + myPackage + "\\";
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
