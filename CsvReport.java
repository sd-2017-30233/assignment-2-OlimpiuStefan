package Model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * Created by Olimpiu on 4/23/2017.
 */
public class CsvReport implements Report {
    private static final String FILE_NAME = "report.csv";
    public void generate(ArrayList<String> titles) throws FileNotFoundException
    {
        PrintWriter pw = new PrintWriter(new File(FILE_NAME));
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<titles.size();i++)
        {
            sb.append("Titlu");
            sb.append(',');
            sb.append(titles.get(i));
            sb.append('\n');
        }
        pw.write(sb.toString());
        pw.close();
        System.out.println("done!");
    }
}
