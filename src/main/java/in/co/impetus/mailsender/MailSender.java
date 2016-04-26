/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.mailsender;

import in.co.impetus.db.model.RequestBook;
import in.co.impetus.db.model.Subscription;
import in.co.impetus.db.model.Users;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

// TODO: Auto-generated Javadoc
/**
 * The Class SendMail.
 */

@Component
public class MailSender {

    /** The property. */
    private Properties property = new Properties();

    /** The property file name. */
    private String propertyFileName = "credentials.properties";

    /** The input stream. */
    private InputStream inputStream = getClass().getClassLoader()
            .getResourceAsStream(propertyFileName);

    /** The username. */
    private String username;

    /** The password. */
    private String password;

    /** The message. */
    private Message message;

    /** The subject. */
    private String subject;

    /** The message body. */
    private String messageBody;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(MailSender.class);

    /**
     * Shoot mail.
     * 
     * @param messageCode
     *            the message code
     * @param user
     *            the user
     * @param subscription
     *            the subscription
     * @param requestBook
     *            the request book
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    
   @Async
    public void shootMail(String messageCode, Users user,
            Subscription subscription, RequestBook requestBook)
            throws IOException {
        property.load(inputStream);
        String userId = user.getUserName();
        username = property.getProperty("username");
        password = property.getProperty("password");

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session mailSession = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(userId));

            if (messageCode.equalsIgnoreCase("REGISTRATION")) {
                messageBody = "Hello "
                        + user.getFirstName()
                        + ",\n\nYou are Successfully Registered on Readers Paradise. \n You have choosen "
                        + subscription.getPlanName()
                        + " Subscription and as per the subscription policy you are allowed to request for "
                        + subscription.getMaxBooks()
                        + " books.\n Your Plan will expire on: "
                        + subscription.getEndDate()
                        + "\n\nThank you for choosing Readers Paradise.\n\n\n\n This email is computer generated, Kindly do not reply on this mail.";
                subject = "Successfully registered on Readers Paradise";
                setSubjectAndMessageBody(messageBody, subject);
            }

            if (messageCode.equalsIgnoreCase("USER_DELIEVERY_REQUEST")) {
                messageBody = "Hello "
                        + user.getFirstName()
                        + ",\nYou request for Book \""
                        + requestBook.getBookSearch().getBookTitle()
                        + "\" has been recorded.Our team will get you back ASAP.";
                messageBody += "\n\nThank you for choosing Readers Paradise.\n\n\n\n This email is computer generated, Kindly do not reply on this mail.";
                subject = "DelieveryRequest for Book \""
                        + requestBook.getBookSearch().getBookTitle() + "\"";
                setSubjectAndMessageBody(messageBody, subject);
            }

            if (messageCode.equalsIgnoreCase("ACCEPT DELIVERY REQUEST")) {
                messageBody = "Hello "
                        + user.getFirstName()
                        + ",\nYour request for Book \""
                        + requestBook.getBookSearch().getBookTitle()
                        + "\" has been recorded and book will be delievered to \n \""
                        + requestBook.getDeliveryAddress().trim() + "\" within 1 day.";
                messageBody += "\n\nThank you for choosing Readers Paradise.\n\n\n\n This email is computer generated, Kindly do not reply on this mail.";
                subject = "Accepted Delievery Request for Book \""
                        + requestBook.getBookSearch().getBookTitle() + "\"";
                setSubjectAndMessageBody(messageBody, subject);
            }

            if (messageCode.equalsIgnoreCase("USER_DELIEVERY_CANCEL_REQUEST")) {
                messageBody = "Hello "
                        + user.getFirstName()
                        + ",\nYour request for cancelling the Delivery Request of Book \""
                        + requestBook.getBookSearch().getBookTitle()
                        + "\" has been recorded."
                        + "The book has been cancelled";
                messageBody += "\n\nThank you for choosing Readers Paradise.\n\n\n\n This email is computer generated, Kindly do not reply on this mail.";
                subject = "Cancel Request for Book \""
                        + requestBook.getBookSearch().getBookTitle() + "\"";
                setSubjectAndMessageBody(messageBody, subject);
            }

            if (messageCode.equalsIgnoreCase("USER_RETURN_CANCEL_REQUEST")) {
                messageBody = "Hello "
                        + user.getFirstName()
                        + ",\nYou've Cancelled thr request for returning the book , \""
                        + requestBook.getBookSearch().getBookTitle() + "\".\n";
                messageBody += "\n\nThank you for choosing Readers Paradise.\n\n\n\n This email is computer generated, Kindly do not reply on this mail.";
                subject = "Cancel Return Request for Book \""
                        + requestBook.getBookSearch().getBookTitle() + "\"";
                setSubjectAndMessageBody(messageBody, subject);
            }

            if (messageCode.equalsIgnoreCase("USER_RETURN_REQUEST")) {
                messageBody = "Hello " + user.getFirstName()
                        + ",\nYou've registered a return request for book , \""
                        + requestBook.getBookSearch().getBookTitle()
                        + "\".We will get back to you ASAP.\n ";
                messageBody += "\n\nThank you for choosing Readers Paradise.\n\n\n\n This email is computer generated, Kindly do not reply on this mail.";
                subject = "Return Request for Book \""
                        + requestBook.getBookSearch().getBookTitle() + "\"";
                setSubjectAndMessageBody(messageBody, subject);
            }

            if (messageCode.equalsIgnoreCase("USER_PASSWORD_RECOVERY")) {
                messageBody = "Hello "
                        + user.getFirstName()
                        + ",\nYou've requested a Password. \n\n Your registred Username: "
                        + user.getUserName() + "\n Password: "
                        + user.getUserPassword() + " ";
                messageBody += "\n\nThank you for choosing Readers Paradise.\n\n\n\n This email is computer generated, Kindly do not reply on this mail.";
                subject = "Password Recovery ";
                setSubjectAndMessageBody(messageBody, subject);
            }

            if (messageCode.equalsIgnoreCase("DENY DELIVERY REQUEST")) {

                messageBody = "Hello "
                        + user.getFirstName()
                        + ",\nYour request for Book \""
                        + requestBook.getBookSearch().getBookTitle()
                        + "\" has been Denied. Please Contact Readers Paradise for further enquiry.";
                messageBody += "\n\nThank you for choosing Readers Paradise.\n\n\n\n This email is computer generated, Kindly do not reply on this mail.";
                subject = "Denied Delievery Request for Book \""
                        + requestBook.getBookSearch().getBookTitle() + "\"";
                setSubjectAndMessageBody(messageBody, subject);

            }

            Transport.send(message);
            LOGGER.info("MAil Sent succefsully");
        } catch (MessagingException e) {
            LOGGER.info("Exception in sending mail " + e);
        }
    }

    /**
     * Shoot reminder mail.
     * 
     * @param subscription
     *            the subscription
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public void shootReminderMail(Subscription subscription) throws IOException {

        property.load(inputStream);
        String userId = subscription.getUserName();
        username = property.getProperty("username");
        password = property.getProperty("password");

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session mailSession = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            message = new MimeMessage(mailSession);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(userId));

            messageBody = "Dear Customer ,\n You have subscribed to a Plan with PlanName "
                    + subscription.getPlanName()
                    + " And Your Plan is going to expire on "
                    + subscription.getEndDate();
            messageBody += "\n\nThank you for choosing Readers Paradise.\n\n\n\n This email is computer generated, Kindly do not reply on this mail.";
            subject = "Plan Expiry Reminder ";
            setSubjectAndMessageBody(messageBody, subject);

            Transport.send(message);
            LOGGER.info("Message Sent Successfully");
        } catch (MessagingException e) {
            LOGGER.info("Exception in sending mail " + e);
        }
    }

    /**
     * Sets the subject and message body.
     * 
     * @param messageBody
     *            the message body
     * @param subject
     *            the subject
     */
    public void setSubjectAndMessageBody(String messageBody, String subject) {
        try {
            message.setSubject(subject);
            message.setText(messageBody);
        } catch (MessagingException e) {
            LOGGER.info("Exception in sending mail " + e);
        }
    }

}
