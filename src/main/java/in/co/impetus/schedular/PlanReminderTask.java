/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.schedular;

import in.co.impetus.db.model.Subscription;
import in.co.impetus.mailsender.MailSender;
import in.co.impetus.service.planreminder.PlanReminderService;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

// TODO: Auto-generated Javadoc
/**
 * The Class BooksTask.
 */
public class PlanReminderTask {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(PlanReminderTask.class);

    /** The books scheduler manager. */
    @Autowired
    private PlanReminderService planReminderService;

    /** The send mail. */
    private MailSender sendMail = new MailSender();

    /**
     * Sets the books scheduler manager.
     *
     * @param planReminderService the new plan reminder service
     * @return the plan reminder service
     */

    /**
     * Sets the plan reminder service.
     * 
     * @param planReminderService
     *            the new plan reminder service
     */
    public void setPlanReminderService(PlanReminderService planReminderService) {
        this.planReminderService = planReminderService;
    }



    /**
     * Sets the send mail.
     * 
     * @param sendMail
     *            the new send mail
     */
    public void setSendMail(MailSender sendMail) {
        this.sendMail = sendMail;
    }



    /**
     * Prints the message.
     */
    public void printMessage() {
        LOGGER.info("Plan Reminder schedular ~");
    }

    /**
     * Gets the users by month.
     * 
     * @return the users by month
     */
    public void getUsersByMonth() {

        List<Subscription> usersList = planReminderService.getUsersByMonth();
        LOGGER.info("userLIst Recievecd:" + usersList);
        shootReminderMails(usersList);

    }

    /**
     * Gets the users by week.
     * 
     * @return the users by week
     */
    public void getUsersByWeek() {
        List<Subscription> usersList = planReminderService.getUsersByWeek();
        LOGGER.info("userLIst Recievec:" + usersList);
        shootReminderMails(usersList);
    }

    /**
     * Gets the users by days.
     * 
     * @return the users by days
     */
    public void getUsersByDays() {
        List<Subscription> usersList = planReminderService.getUsersByDays();
        LOGGER.info("userLIst Recievec:" + usersList);
        shootReminderMails(usersList);
    }

    /**
     * Gets the user subscriptions.
     * 
     * @return the user subscriptions
     */
    public void getUserSubscriptions() {
        List<Subscription> usersList = planReminderService
                .getUserSubscriptions();
        LOGGER.info("userLIst Recievec:" + usersList);
        for (Subscription subscription : usersList) {
            subscription.setIsActive(false);
            planReminderService.updateSubscription(subscription);

        }
    }

    /**
     * Shoot reminder mails.
     * 
     * @param usersList
     *            the users list
     */
    public void shootReminderMails(List<Subscription> usersList) {
        LOGGER.info("List to mail" + usersList);
        for (Subscription subs : usersList) {
            LOGGER.info("subs" + subs);
            try {
                sendMail.shootReminderMail(subs);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                LOGGER.error("Exception in shooting mails" + e);
            }
        }

    }
}
