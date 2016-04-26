/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.controllers;

import static in.co.impetus.constants.Constants.CANCELLED_SUCCESS;
import static in.co.impetus.constants.Constants.REQUESTED_SUCCESSFULLY;
import in.co.impetus.db.model.BookSearch;
import in.co.impetus.db.model.RequestBook;
import in.co.impetus.db.model.Subscription;
import in.co.impetus.db.model.Users;
import in.co.impetus.mailsender.MailSender;
import in.co.impetus.service.registration.RegisterService;
import in.co.impetus.service.request.RequestService;
import in.co.impetus.service.search.BookSearchService;
import in.co.impetus.service.shelf.ShelfService;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// TODO: Auto-generated Javadoc
/**
 * The Class RequestHandlerController.
 */
/**
 * @author manish.sharma
 * 
 */
@Controller
public class RequestHandlerController {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(RequestHandlerController.class);

    /** The request service. */
    @Autowired
    private RequestService requestService;

    /** The shelf service. */
    @Autowired
    private ShelfService shelfService;

    /** The register service. */
    @Autowired
    private RegisterService registerService;

    /** The book search service. */
    @Autowired
    private BookSearchService bookSearchService;

    /** The send mail. */
    @Autowired
    private MailSender sendMail = new MailSender();

    /**
     * * @param model.
     *
     * @param request            the request
     * @param response            the response
     * @param model the model
     * @return This method deals with calling the removefromShelf method from
     *         the bookSearchService to remove some entries from user's personal
     *         shelf
     */

    @RequestMapping(value = "/user_deleteFromShelf", method = RequestMethod.POST)
    public void deleteFromShelf(HttpServletRequest request,
            HttpServletResponse response, Map<String, Object> model) {

        HttpSession session = request.getSession(false);

        String userId = (String) session.getAttribute("uname");
        String bookId = (String) request.getParameter("bid");
        String deliveryAddress = (String) request.getParameter("address");

        String buttonClicked = request.getParameter("button");

        LOGGER.info("button clicked is " + buttonClicked);

        if (buttonClicked.equalsIgnoreCase("remove")) {
            try {
                String removeResult = shelfService.removeFromShelf(userId,
                        bookId);
                LOGGER.info("delete from shelf controller result "
                        + removeResult);

                response.sendRedirect("user_showBookShelf");
            } catch (Exception eq) {
                LOGGER.error("Exception in redirecting" + eq);

            }

        } else if (buttonClicked.equalsIgnoreCase("request")) {

            String dt = (String) session.getAttribute("dt");

            String requestDeliveryResult = requestService.requestBook(userId,
                    bookId, dt, deliveryAddress);
            session.setAttribute("requestDeliveryResult", requestDeliveryResult);

            Users user = registerService.getUserById(userId);
            Subscription subscription = requestService
                    .checkSubscription(userId);
            BookSearch book = bookSearchService.getBookById(bookId);
            RequestBook requestBook = requestService.getRequestedBookByBookId(
                    userId, book);

            try {
                if (requestDeliveryResult.equals(REQUESTED_SUCCESSFULLY)) {

                    sendMail.shootMail("USER_DELIEVERY_REQUEST", user,
                            subscription, requestBook);
                }

            } catch (Exception e) {
                LOGGER.info("Exception in Send MAil at register" + e);
            }

            try {
                response.sendRedirect("user_showBookShelf");

            } catch (Exception eq) {
                LOGGER.error("Exception in redirecting" + eq);

            }

        }

    }

    /**
     * Cancel delivery request.
     * 
     * @param model
     *            the model
     * @param request
     *            the request
     * @param response
     *            This method calls cancelDeliveryRequest method of the service
     *            and sets requestId as a parameter.
     */
    @RequestMapping(value = "/user_cancelDeliveryRequest", method = RequestMethod.GET)
    public void cancelDeliveryRequest(Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);

        int requestId = Integer.parseInt(request.getParameter("requestId"));

        LOGGER.info("cancel called succesfully : now redirecting");
        
        String cancelDeliveryResult = requestService
                .cancelDeliveryRequest(requestId);
        
        session.setAttribute("cancelDeliveryResult", cancelDeliveryResult);

        String userId = session.getAttribute("uname").toString();
        Users user = registerService.getUserById(userId);
        Subscription subscription = requestService.checkSubscription(userId);
        RequestBook requestBook = requestService
                .getRequestedBookByReqId(requestId);

        try {
            if (cancelDeliveryResult.equals(CANCELLED_SUCCESS)) {

/*                 sendMail.shootMail("USER_DELIEVERY_CANCEL_REQUEST", user,
                 subscription, requestBook);
*/            }

        } catch (Exception e) {
            LOGGER.info("Exception in Send MAil at register" + e);
        }

        try {
            response.sendRedirect("user_showRequestedBooks");
        } catch (Exception e) {
            LOGGER.info("Exception in Redirecting to showRequestedBooks" + e);
        }
    }

    /**
     * Return book request.
     * 
     * @param model
     *            the model
     * @param request
     *            the request
     * @param response
     *            This method calls returnBookRequest method of the service and
     *            sets requestId as a parameter when the Button clicked was
     *            Return Book. Else if the BUtton clicked was Cancel Return
     *            Request the cancelReturnRequest method of the service was
     *            called with parameter as Request Id.
     */
    @RequestMapping(value = "/user_returnBookRequest", method = RequestMethod.GET)
    public void returnBookRequest(Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);

        int requestId = Integer.parseInt(request.getParameter("requestId"));

        String returnAddress = (String) request.getParameter("address");

        String userId = session.getAttribute("uname").toString();
        Users user = registerService.getUserById(userId);
        Subscription subscription = requestService.checkSubscription(userId);
        RequestBook requestBook = requestService
                .getRequestedBookByReqId(requestId);

        LOGGER.info("returnBookRequest called succesfully in "
                + "BookController : now redirecting");

        String buttonClicked = request.getParameter("button");

        LOGGER.info("button clicked is " + buttonClicked);

        if (buttonClicked.equalsIgnoreCase("Return Book")) {
            try {
                String returnBookRequest = requestService.returnBookRequest(
                        requestId, returnAddress);
                session.setAttribute("returnBookRequest", returnBookRequest);

                try {
                    if (returnBookRequest.equals(REQUESTED_SUCCESSFULLY)) {

                        // sendMail.shootMail("USER_RETURN_REQUEST", user,
                        // subscription, requestBook);
                    }
                } catch (Exception e) {
                    LOGGER.info("Exception in Send MAil at register" + e);
                }

            } catch (Exception e) {
                LOGGER.info("Exception Caught in calling returnBookRequest" + e);
            }
        } else {
            try {
                String cancelReturnRequest = requestService
                        .cancelReturnRequest(requestId);
                session.setAttribute("cancelReturnRequest", cancelReturnRequest);

                try {
                    if (cancelReturnRequest.equals(CANCELLED_SUCCESS)) {
                        // sendMail.shootMail("USER_RETURN_CANCEL_REQUEST",
                        // user, subscription, requestBook);
                    }
                } catch (Exception e) {
                    LOGGER.info("Exception in Send MAil at register" + e);
                }

            } catch (Exception e) {
                LOGGER.info("Exception caught in calling cancelBookRequest" + e);
            }
        }

        try {
            response.sendRedirect("user_showHoldingBooks");
        } catch (Exception e) {
            LOGGER.info("Exception in Redirecting to showRequestedBooks" + e);
        }

    }

}
