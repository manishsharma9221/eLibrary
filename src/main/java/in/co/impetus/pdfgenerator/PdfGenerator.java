/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.pdfgenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

// TODO: Auto-generated Javadoc
/**
 * The Class PdfGen.
 */
public class PdfGenerator {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(PdfGenerator.class);

    /**
     * Generate.
     * 
     * @param report
     *            the report
     * @param document1
     *            the document1
     * @return true, if successful
     */
    public boolean generate(List<Object[]> report, Document document1) {
        try {
            Document document = document1;
            PdfWriter.getInstance(document, new FileOutputStream(new File("D:/"
                    + System.currentTimeMillis() + ".pdf")));
            document.open();

            PdfPTable table = new PdfPTable(8);
            table.addCell("S.No");
            table.addCell("Category");
            table.addCell("Author");
            table.addCell("Title");
            table.addCell("Total Requests");
            table.addCell("Cancelled");
            table.addCell("Returned");
            table.addCell("Delivered");
            int i = 0;
    
            for (Object[] rB : (List<Object[]>) report) {

                if (rB != null) {
                    table.addCell(Integer.toString(++i));
                    table.addCell(rB[0].toString());
                    table.addCell(rB[1].toString());
                    table.addCell(rB[2].toString());
                    table.addCell(rB[3].toString());
                    table.addCell(rB[4].toString());
                    table.addCell(rB[5].toString());
                    table.addCell(rB[6].toString());

                }
            }
        
            Chunk chunk=new Chunk("Reports of Books Rented for a Period");
            chunk.setUnderline(+1f,-2f);
          
        
            document.add(chunk);
            document.add(new Paragraph("\n\n"));
        
            document.add(table);
            document.close();
            LOGGER.info("Pdf Generated Succesfully");
            return true;
        } catch (Exception e) {
            {
                LOGGER.info("Exception Caught in Generating PDF: " + e);
                return false;
            }

        }
    }

}
