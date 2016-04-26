/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.service.xmlparser;

import in.co.impetus.db.model.Plans;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;


// TODO: Auto-generated Javadoc
/**
 * The Interface XmlParserService.
 */
public interface XmlParserService {
    /**
     * Adds the or update subscription.
     * 
     * @param path
     *            the path
     * @param subscriptionXMLFile
     *            the subscription xml file
     * @return the string
     */
    String addOrUpdateSubscription(String path,
            MultipartFile subscriptionXMLFile);

    /**
     * Parsing helper.
     * 
     * @param path
     *            the path
     * @param subscriptionXMLFile
     *            the subscription xml file
     * @return the list
     */
    List<Plans> parsingHelper(String path, MultipartFile subscriptionXMLFile);

    /**
     * Delete subscriptions.
     * 
     * @param path
     *            the path
     * @param subscriptionXMLFile
     *            the subscription xml file
     * @return the string
     */
    String deleteSubscriptions(String path, MultipartFile subscriptionXMLFile);

}
