/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.controllers;

import static in.co.impetus.constants.Constants.PLAN_UPGRADED;
import in.co.impetus.db.model.BookSearch;
import in.co.impetus.db.model.Plans;
import in.co.impetus.db.model.RequestBook;
import in.co.impetus.db.model.Subscription;
import in.co.impetus.db.model.Users;
import in.co.impetus.service.registration.RegisterService;
import in.co.impetus.service.search.BookSearchService;
import in.co.impetus.service.shelf.ShelfService;
import in.co.impetus.service.subscriptionplan.SubscriptionPlanService;
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
import org.springframework.web.servlet.ModelAndView;

// TODO: Auto-generated Javadoc

/**
 * The Class UserController.
 * 
 * @author manish.sharma
 */

@Controller
public class UserController {

    /** The user function service. */
    @Autowired
    private UserFunctionService userFunctionService;

    /** The shelf service. */
    @Autowired
    private ShelfService shelfService;

    /** The book search service. */
    @Autowired
    private BookSearchService bookSearchService;

    /** The Subscription plan service. */
    @Autowired
    private SubscriptionPlanService subscriptionPlanService;

    /** The register service. */
    @Autowired
    private RegisterService registerService;

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(UserController.class);

    /**
     * View profile.
     * 
     * @param request
     *            the request
     * @param response
     *            the response
     * @param m
     *            the m
     * @return the string
     */
    @RequestMapping(value = "user_ViewProfile", method = RequestMethod.GET)
    public String viewProfile(HttpServletRequest request,
            HttpServletResponse response, Map<String, Object> m) {
        HttpSession session = request.getSession(false);
        String userName = (String) session.getAttribute("uname");
        Users user = userFunctionService.showProfile(userName);

        m.put("myProfile", user);
        m.put("showProfile", true);
        return "viewProfile";
    }

    /**
     * View history.
     * 
     * @param request
     *            the request
     * @param response
     *            the response
     * @param map
     *            the map
     * @return the string
     */
    @RequestMapping(value = "user_ViewHistory", method = RequestMethod.GET)
    public String viewHistory(HttpServletRequest request,
            HttpServletResponse response, Map<String, Object> map) {
        HttpSession session = request.getSession(false);
        String userName = (String) session.getAttribute("uname");
        List<RequestBook> requestedBooks = shelfService
                .showRequestedBooks(userName);
        map.put("requestedBooks", requestedBooks);
        map.put("showHistory", true);
        return "returnedHistory";
    }

    /**
     * Subscription history.
     * 
     * @param request
     *            the request
     * @param response
     *            the response
     * @param map
     *            the map
     * @return the string
     */
    @RequestMapping(value = "user_SubscriptionHistory", method = RequestMethod.GET)
    public String subscriptionHistory(HttpServletRequest request,
            HttpServletResponse response, Map<String, Object> map) {
        HttpSession session = request.getSession(false);
        String userName = (String) session.getAttribute("uname");
        List<Subscription> subscriptions = shelfService
                .getSubscription(userName);
        map.put("subscriptionhistory", subscriptions);
        map.put("showSubscriptionHistory", true);
        return "subscriptionHistory";
    }

    /**
     * Gets the form.
     * 
     * @param model
     *            the model
     * @return the form
     */
    @RequestMapping(value = "user_showuserhome", method = RequestMethod.GET)
    public ModelAndView getForm(Map<Object, Object> model) {
        List<BookSearch> recentBooksList = bookSearchService
                .getRecentBooksList();

        model.put("recentBooksList", recentBooksList);
        return new ModelAndView("userHome");
    }

    /**
     * Listplans.
     * 
     * @return the model and view
     */
    @RequestMapping("user_upgradeplan.htm")
    public ModelAndView listplans() {
        List<Plans> plansList = subscriptionPlanService.getPlansList();
        ModelAndView modelAndView = new ModelAndView("upgradePlan");
        modelAndView.addObject("plansList", plansList);
        return modelAndView;

    }

    /**
     * Enrol new plan.
     * 
     * @param request
     *            the request
     * @param response
     *            the response
     * @param map
     *            the map
     * @return the string
     */
    @RequestMapping(value = "user_enrolNewPlan", method = RequestMethod.POST)
    public String enrolNewPlan(HttpServletRequest request,
            HttpServletResponse response, Map<String, Object> map) {
        HttpSession session = request.getSession(false);
        String userName = (String) session.getAttribute("uname");
        int planId = (Integer.parseInt(request.getParameter("planId")));
        String upgradeResult = registerService.upgradeSubscription(userName,
                planId);
        if (upgradeResult.equals(PLAN_UPGRADED)) {
            map.put("upgradeSuccess", upgradeResult);
        } else {
            map.put("upgradeFailure", upgradeResult);
        }
        map.put("upgradeResult", upgradeResult);
        List<Plans> plansList = subscriptionPlanService.getPlansList();
        map.put("plansList", plansList);
        return "upgradePlan";
    }

    /**
     * Show recommendations.
     *
     * @param request            the request
     * @param response            the response
     * @param map            the map
     * @return the model and view
     */
    @RequestMapping("user_Recommendations.html")
    public ModelAndView showRecommendations(HttpServletRequest request,
            HttpServletResponse response, Map<String, Object> map) {
        HttpSession session = request.getSession(false);
        String userName = (String) session.getAttribute("uname");
        List<BookSearch> books = userFunctionService
                .showRecommendedBooks(userName);
        LOGGER.info("Recommended  books" + books);

        ModelAndView modelAndView = new ModelAndView("recommendedBooks");

        modelAndView.addObject("recommendedBooks", books);
        return modelAndView;

    }

}
