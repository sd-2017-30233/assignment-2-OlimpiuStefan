package Model;

/**
 * Created by Olimpiu on 4/23/2017.
 */
public class ReportFactory {
    public Report getReport(String reportType) {
        if (reportType == null) {
            return null;
        }
        if (reportType.equalsIgnoreCase("PDF")) {
            return new PdfReport();

        } else if (reportType.equalsIgnoreCase("CSV")) {
            return new CsvReport();
        }
        return null;
    }
}
