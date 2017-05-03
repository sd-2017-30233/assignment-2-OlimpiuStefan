package Model;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Olimpiu on 4/23/2017.
 */
public class PdfReport implements Report {
    private static final String FILE_NAME = "report.pdf";
    public void generate(ArrayList<String> titles) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(new File(FILE_NAME)));
            document.open();
            Paragraph p = new Paragraph();
            p.add("BOOKS OUT OF STOCK");
            p.setAlignment(Element.ALIGN_CENTER);
            document.add(p);
            for (int i=0;i<titles.size();i++) {
                Paragraph p2 = new Paragraph();
                p2.add(titles.get(i));
                document.add(p2);
            }
            document.close();
            System.out.println("Done");

        } catch (FileNotFoundException | DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
