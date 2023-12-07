import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import javax.swing.JOptionPane;
import java.io.FileNotFoundException;

public class PDFGenerator {

    public static void generatePDFWithOption(String results) {
        int choice = JOptionPane.showConfirmDialog(null, "Do you want to save the PDF file?", "Save", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            String downloadsPath = determineDownloadsPath();

            if (downloadsPath != null) {
                String fileName = downloadsPath + "TestResults.pdf";

                try {
                    PdfWriter writer = new PdfWriter(fileName);
                    PdfDocument pdf = new PdfDocument(writer);
                    Document document = new Document(pdf);

                    // Add the test results to the PDF document
                    Paragraph paragraph = new Paragraph(results);
                    document.add(paragraph);

                    document.close();

                    JOptionPane.showMessageDialog(null, "PDF has been saved to: " + fileName);
                } catch (FileNotFoundException e) {
                    JOptionPane.showMessageDialog(null, "Error creating PDF: " + e.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(null, "Could not find the Downloads folder.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "The PDF file has not been saved.");
        }
    }

    private static String determineDownloadsPath() {
        String userHome = System.getProperty("user.home");
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("win")) {
            return userHome + "\\Downloads\\";
        } else if (os.contains("mac")) {
            return userHome + "/Downloads/";
        } else {
            // Use a default path for other operating systems
            return userHome + "/Downloads/";
        }
    }
}
