/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.service.xmlparser;

import in.co.impetus.db.dao.AdminFunctionDao;
import in.co.impetus.db.model.Plans;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// TODO: Auto-generated Javadoc
/**
 * The Class XmlParserServiceImpl.
 */
@Service("xmlParserService")
public class XmlParserServiceImpl implements XmlParserService {
    
    /** The admin function dao. */
    @Autowired
    private AdminFunctionDao adminFunctionDao;
    
    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(XmlParserServiceImpl.class);
    /*
     * (non-Javadoc)
     * 
     * @see in.co.impetus.service.adminfunction.AdminFunctionService#
     * addOrUpdateSubscription(java.lang.String,
     * org.springframework.web.multipart.MultipartFile)
     */
    @Override
    @Transactional
    public String addOrUpdateSubscription(String path,
            MultipartFile subscriptionXMLFile) {

        String res = "";
       if(subscriptionXMLFile.isEmpty())
       {
        return "fileempty";
       }
       else
       {
        try {

            List<Plans> planList = parsingHelper(path, subscriptionXMLFile);
            if(planList!=null)
            {
            res = adminFunctionDao.addOrUpdateSubscriptions(planList);
            }
            else
            {
            res = "Please upload correct XML file";    
            }

        } catch (Exception e) {

            LOGGER.info("Exception in Adding Plans:" + e);
        }
       }

        return res;
    }

    // *************************************************************************************************

    // **********************************************************************************************************************
    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.adminfunction.AdminFunctionService#parsingHelper
     * (java.lang.String, org.springframework.web.multipart.MultipartFile)
     */
    public List<Plans> parsingHelper(String path,
            MultipartFile subscriptionXMLFile) {
        String fileName = "";
        if (!subscriptionXMLFile.isEmpty()) {
            try {
                byte[] bytes = subscriptionXMLFile.getBytes();
                String name = subscriptionXMLFile.getOriginalFilename();

                String ext = name.substring(name.lastIndexOf('.'),
                        name.length());
                fileName = "" + System.currentTimeMillis() + ext;

                File file = new File(path, "resources");
                if (!file.exists()) {
                    file.mkdirs();
                }
                file = new File(file, "subscriptions");
                if (!file.exists()) {
                    file.mkdirs();
                }
                File temp = new File(file, fileName);
                LOGGER.info("Path : " + temp);

                FileOutputStream fos = new FileOutputStream(temp);
                fos.write(bytes);
                List<Plans> planList = addSubscriptionDetailsFromXMLFile(temp);

                fos.close();
                file.delete();

                return planList;
            } catch (Exception ex) {
                LOGGER.error("Exception in parsing files" + ex);
            }
        }

        return null;
    }

    // *************************************************************************************************

    /**
     * Adds the subscription details from xml file.
     * 
     * @param file
     *            the file
     * @return the list
     */
    public List<Plans> addSubscriptionDetailsFromXMLFile(File file) {
        List<Plans> subscriptionList = new ArrayList<Plans>();
        try {
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory
                    .newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("subscription");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);

                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Plans plan = new Plans();
                    Element eElement = (Element) nNode;

                    plan.setMaxBooks(Integer.parseInt(eElement
                            .getElementsByTagName("maxBooks").item(0)
                            .getTextContent()));
                    plan.setPrice(Integer.parseInt(eElement
                            .getElementsByTagName("price").item(0)
                            .getTextContent()));
                    plan.setMaxDays(Integer.parseInt(eElement
                            .getElementsByTagName("maxDays").item(0)
                            .getTextContent()));
                    plan.setPlanName(eElement.getElementsByTagName("planName")
                            .item(0).getTextContent());

                    subscriptionList.add(plan);
                }
            }

            return subscriptionList;
        } catch (Exception e) {
            LOGGER.info("Exception in parsing" + e);
            return null;
        }
    }

    /*
     * (non-Javadoc)
     * 
     * @see
     * in.co.impetus.service.adminfunction.AdminFunctionService#deleteSubscriptions
     * (java.lang.String, org.springframework.web.multipart.MultipartFile)
     */
    @Override
    @Transactional
    public String deleteSubscriptions(String path,
            MultipartFile subscriptionXMLFile) {
        // TODO Auto-generated method stub
        String res = "";
        if(subscriptionXMLFile.isEmpty())
        {
         return "fileempty";
        }
        else{
            
    
        try {

            List<Plans> planList = parsingHelper(path, subscriptionXMLFile);
            res = adminFunctionDao.deleteSubscriptions(planList);

        } catch (Exception e) {

            LOGGER.info("Exception in Deleting Plans:" + e);
        }
        }
        return res;
    }

}
