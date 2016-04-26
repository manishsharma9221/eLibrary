/**
 * 
 * Copyright Impetus @2000-2014
 * 
 */
package in.co.impetus.controllers;

import in.co.impetus.db.model.BookSearch;
import in.co.impetus.db.model.RequestBook;
import in.co.impetus.service.request.RequestService;
import in.co.impetus.service.search.BookSearchService;
import in.co.impetus.service.shelf.ShelfService;
import in.co.impetus.service.userfunction.UserFunctionService;

import java.util.List;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// TODO: Auto-generated Javadoc

/**
 * The Class BookSearchController.
 * 
 * @author manish.sharma
 */

@Controller
public class BookSearchController {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(BookSearchController.class);

    /** The book search service. */
    @Autowired
    private BookSearchService bookSearchService;

    /** The shelf service. */
    @Autowired
    private ShelfService shelfService;

    /** The request service. */
    @Autowired
    private RequestService requestService;

    /** The user function service. */
    @Autowired
    private UserFunctionService userFunctionService;

    /**
     * * @param model.
     *
     * @param searchCriteria            the search criteria
     * @param response            the response
     * @param request            the request
     * @return This method deals with calling the searchBooks method from the
     *         bookSearchService
     */
    @RequestMapping(value = "BookSearchHelper", method = RequestMethod.GET)
    public void bookSearchHelper(
            @RequestParam("searchCriteria") String searchCriteria,
            HttpServletResponse response, HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        session.setAttribute("searchCriteria", searchCriteria);

        try {
            response.sendRedirect("BookSearch");
        } catch (Exception e) {
            LOGGER.info("Cannot Redirect to BookSearch" + e);
        }
    }

    /**
     * Book search.
     * 
     * @param model
     *            the model
     * @param request
     *            the request
     * @param response
     *            the response
     * @param session
     *            the session
     * @return the string
     */
    @RequestMapping(value = "BookSearch", method = RequestMethod.GET)
    public String bookSearch(Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response,
            HttpSession session) {

        String searchCriteria = (String) session.getAttribute("searchCriteria");
        String userName = (String) session.getAttribute("uname");

        LOGGER.info("in controller***********" + searchCriteria);
        List<BookSearch> bResult = bookSearchService
                .searchbooks(searchCriteria);
        if (!bResult.isEmpty()) {
            userFunctionService.saveSearchCriteria(userName, searchCriteria);
        }
        model.put("bookresults", bResult);
        model.put("showSearchedBooks", true);
        return "searchedBooks";
    }

    /**
     * This method deals with calling the addToShelf method from the
     * bookSearchService to addBooks into the users personal shelf.
     * 
     * @param request
     *            the request
     * @param response
     *            the response
     * @param m
     *            the m
     */

    @RequestMapping(value = "/user_addBook", method = RequestMethod.POST)
    public void addBooks(HttpServletRequest request,
            HttpServletResponse response, Map<String, Object> m) {

        HttpSession session = request.getSession(false);

        String bookId = request.getParameter("bid");
        String userId = (String) session.getAttribute("uname");
        String addResult = shelfService.addToShelf(bookId, userId);

        session.setAttribute("addresult", addResult);

        try {
            response.sendRedirect("BookSearch");

        } catch (Exception eq) {
            LOGGER.error("Exception in redirecting" + eq);

        }

    }

    /**
     * * @param model.
     * 
     * @param model
     *            the model
     * @param request
     *            the request
     * @param response
     *            the response
     * @return This method deals with calling the showShelf method from the
     *         bookSearchService to Show users personal shelf
     */

    @RequestMapping(value = "/user_showBookShelf", method = RequestMethod.GET)
    public String getShelf(Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);

        String userId = (String) session.getAttribute("uname");

        LOGGER.info(userId);
        List<BookSearch> shelf = shelfService.showShelf(userId);

        model.put("shelfresults", shelf);
        model.put("showShelf", true);

        model.put("showMessage", true);

        return "showShelf";

    }

    /**
     * Anonymous search.
     * 
     * @param model
     *            the model
     * @param searchCriteria
     *            the search criteria
     * @param request
     *            the request
     * @param response
     *            the response
     * @param session
     *            the session
     * @return the string
     */
    @RequestMapping(value = "AnonymousSearch", method = RequestMethod.GET)
    public String anonymousSearch(Map<String, Object> model,
            @RequestParam("searchCriteria") String searchCriteria,
            HttpServletRequest request, HttpServletResponse response,
            HttpSession session) {

        List<BookSearch> bResult = bookSearchService
                .searchbooks(searchCriteria);

        model.put("bookresults", bResult);
        model.put("showSearchedBooks", true);
        return "anonymousSearch";
    }

    /**
     * Show requested books.
     * 
     * @param model
     *            the model
     * @param request
     *            the request
     * @param response
     *            the response
     * @return This method calls showRequestedBooks method of service and pass
     *         userId as the parameter.
     */
    @RequestMapping(value = "/user_showRequestedBooks", method = RequestMethod.GET)
    public String showRequestedBooks(Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);

        String userId = (String) session.getAttribute("uname");

        LOGGER.info(userId);
        List<RequestBook> requestedBooks = shelfService
                .showRequestedBooks(userId);
        model.put("requestedBooks", requestedBooks);
        model.put("showRequestedBooks", true);

        return "requestedBooks";

    }

    /**
     * Show holding books.
     * 
     * @param model
     *            the model
     * @param request
     *            the request
     * @param response
     *            the response
     * @return This method calls showHoldingBooks method of the service and sets
     *         userId as a parameter.
     */
    @RequestMapping(value = "/user_showHoldingBooks", method = RequestMethod.GET)
    public String showHoldingBooks(Map<String, Object> model,
            HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);

        String userId = (String) session.getAttribute("uname");

        LOGGER.info(userId);
        List<RequestBook> requestedBooks = shelfService
                .showBooksHolding(userId);
        model.put("requestedBooks", requestedBooks);
        model.put("showHoldingBooks", true);

        return "holdingBooks";

    }
    
    @RequestMapping(value = "/user_addToShelf", method = RequestMethod.POST)
    public  @ResponseBody String ajaxAddToShelf(HttpServletRequest request,
            HttpServletResponse response, Map<String, Object> m) {

        HttpSession session = request.getSession(false);

        String bookId = request.getParameter("bookId");
        LOGGER.info(bookId);
        String userId = (String) session.getAttribute("uname");
        String addResult = shelfService.addToShelf(bookId, userId);

        return addResult;
    }

}
