package recoveryorder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class RecoveryOrder {
    public static void main(String[] args) {
        File src = new File("E:\\bag\\IoTest0913\\src\\test\\test.txt");
        File out = new File("E:\\bag\\IoTest0913\\src\\test\\sort_test.txt");
        System.out.println(sorTest(src, out));
    }

    private static boolean sorTest(File src, File out) {
        try(BufferedReader fileReader = new BufferedReader(new FileReader(src));
            FileWriter fileWriter = new FileWriter(out)) {
            List<String> readString = new ArrayList<>();
            String temp;
            int n = 0;
            while ((temp = fileReader.readLine())!=null){
                readString.add(n++, temp);
            }
            readString.sort((r1,r2)->Integer.parseInt(r1.substring(0,1))-Integer.parseInt(r2.substring(0,1)));
            for (String str : readString){
                fileWriter.write(str+"\n");
            }
            return true;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
