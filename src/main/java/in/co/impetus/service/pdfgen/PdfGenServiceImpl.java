/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.service.pdfgen;

import in.co.impetus.db.dao.PdfGenDAO;
import in.co.impetus.db.model.BookSearch;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// TODO: Auto-generated Javadoc
/**
 * The Class PdfGenServiceImpl.
 */
@Service("pdfGenService")
public class PdfGenServiceImpl implements PdfGenService {

  
    /** The pdf gen dao. */
    @Autowired
    private PdfGenDAO pdfGenDAO;

    /**
     * Sets the pdf gen dao.
     * 
     * @param pdfGenDAO
     *            the new pdf gen dao
     */
    public void setPdfGenDAO(PdfGenDAO pdfGenDAO) {
        this.pdfGenDAO = pdfGenDAO;
    }

     /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.pdfgen.PdfGenService#getReports(java.lang.String,
     * java.lang.String, java.util.Date, java.util.Date)
     */
    @Override
    public List<Object[]> getReports(String author, String category, Date from,
            Date to) {

        List<Object[]> report = pdfGenDAO
                .getReports(author, category, from, to);

        return report;
    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.service.pdfgen.PdfGenService#getDistinctAuth()
     */
    @Override
    public List<BookSearch> getDistinctAuth() {
        // TODO Auto-generated method stub
        return pdfGenDAO.getDistinctAuth();
    }

    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.service.pdfgen.PdfGenService#getDistinctCat()
     */
    @Override
    public List<BookSearch> getDistinctCat() {
        // TODO Auto-generated method stub
        return pdfGenDAO.getDistinctCat();
    }

}
