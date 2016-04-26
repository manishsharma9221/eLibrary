/**
 * 
 * Copyright Impetus @2000-2014
 * 
 */

package in.co.impetus.controllers;

import in.co.impetus.db.model.BookSearch;
import in.co.impetus.db.model.Users;
import in.co.impetus.mailsender.MailSender;
import in.co.impetus.service.registration.RegisterService;
import in.co.impetus.service.search.BookSearchService;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// TODO: Auto-generated Javadoc

/**
 * The Class LoginController.
 * 
 * @author manish.sharma
 */

@Controller
// @RequestMapping(value = "loginform.html")
public class LoginController {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory
            .getLogger(LoginController.class);

    /** The register service. */
    @Autowired
    private RegisterService registerService;

    /** The book search service. */
    @Autowired
    private BookSearchService bookSearchService;

    /** The send mail. */
    @Autowired
    private MailSender sendMail = new MailSender();

    /** The recent books list. */
    private static List<BookSearch> recentBooksList = null;

    /**
     * Show form.
     * 
     * @param model
     *            the model
     * @return This method is used for showing the Login Form
     */

    @RequestMapping(value = "/")
    public String showHome(Map<Object, Object> model) {
        return "index";
    }

    /**
     * Show form.
     * 
     * @param model
     *            the model
     * @param session
     *            the session
     * @return the string
     */
    @RequestMapping(value = "loginform.html", method = RequestMethod.GET)
    public String showForm(Map<Object, Object> model, HttpSession session) {
        session.invalidate();
        model.put("LoginForm", true);

        LOGGER.info("In Login Page, User is requested to login");

        recentBooksList = bookSearchService.getRecentBooksList();

        model.put("recentBooksList", recentBooksList);

        return "loginform";
    }

    /**
     * Login verify.
     * 
     * @param request
     *            the request
     * @param model
     *            the model
     * @param authfailed
     *            the authfailed
     * @param logout
     *            the logout
     * @param denied
     *            the denied
     * @return This is a loginVerify Method. Used to Verify the login
     *         credentials
     */
    @RequestMapping("login")
    public ModelAndView getLoginForm(HttpServletRequest request, Model model,
            @RequestParam(required = false) String authfailed, String logout,
            String denied) {
        String message = "";
        if (authfailed != null) {
            message = "Invalid username or password, try again !";
        } else if (logout != null) {
            HttpSession session = request.getSession();
            session.invalidate();
            message = "Logged out successfully, login again to continue !";
        } else if (denied != null) {
            message = "Access denied for this user !";
        }
        model.addAttribute("LoginForm", true);
        recentBooksList = bookSearchService.getRecentBooksList();

        model.addAttribute("recentBooksList", recentBooksList);
        return new ModelAndView("loginform", "message", message);
    }

    /**
     * Ge user page.
     * 
     * @param request
     *            the request
     * @param model
     *            the model
     * @return the string
     */
    @RequestMapping("user")
    public String geUserPage(HttpServletRequest request, Model model) {
        String userName = request.getUserPrincipal().getName();
        LOGGER.info("UserName" + userName);
        HttpSession session = request.getSession(true);

        Users user = registerService.getUserById(userName);
        String firstName = user.getFirstName();
        session.setAttribute("firstname", firstName);

        String completeAddress = user.getAddress().trim().concat(" , ")
                .concat(user.getCity()).concat(" , ").concat(user.getState());

        session.setAttribute("uname", userName);
        session.setAttribute("address", completeAddress.trim());

        LOGGER.info("Login Successful. Redirecting to User's home page");

        model.addAttribute("recentBooksList", recentBooksList);

        return "userHome";
    }

    /**
     * Ge admin page.
     * 
     * @param model
     *            the model
     * @param request
     *            the request
     * @return the string
     */
    @RequestMapping("admin")
    public String geAdminPage(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession(true);
        String userName = request.getUserPrincipal().getName();

        Users user = registerService.getUserById(userName);
        String firstName = user.getFirstName();
        session.setAttribute("firstname", firstName);
        session.setAttribute("uname", userName);

        return "adminHomeNew";
    }

    /**
     * Ge403denied.
     * 
     * @return the string
     */
    @RequestMapping("403page")
    public String ge403denied() {
        return "redirect:login?denied";
    }

    /* *************** Show Recover Page *************************** */
    /**
     * Recover.
     * 
     * @param model
     *            the model
     * @param session
     *            the session
     * @return the string
     */
    @RequestMapping(value = "Recover.html", method = RequestMethod.GET)
    public String recover(Map<Object, Object> model, HttpSession session) {
        session.invalidate();
        model.put("Recover", true);
        List<BookSearch> recentBooksList = bookSearchService
                .getRecentBooksList();
        model.put("recentBooksList", recentBooksList);
        return "loginform";
    }

    /* *************** Show Recover Continue Page *************************** */
    /**
     * Recover continue.
     * 
     * @param model
     *            the model
     * @param session
     *            the session
     * @param request
     *            the request
     * @return the model and view
     */
    @RequestMapping(value = "RecoverMail.html", method = RequestMethod.POST)
    public ModelAndView recoverContinue(Map<Object, Object> model,
            HttpSession session, HttpServletRequest request) {
        session.invalidate();
        String userId = (String) request.getParameter("recoverEmail");
        Users user = registerService.getUserById(userId);
        ModelAndView modelAndView = new ModelAndView("loginform");

        try {
            if (user != null) {

                sendMail.shootMail("USER_PASSWORD_RECOVERY", user, null, null);
                modelAndView.addObject("Msg", "The Password has been sent to"
                        + "your registered email id.");
            } else {
                modelAndView.addObject("Msg", "The Username doesnot found."
                        + "Please Register to continue");
            }

        } catch (Exception e) {
            LOGGER.info("Exception in Send MAil at register" + e);
        }

        model.put("recentBooksList", recentBooksList);
        model.put("RecoverContinue", true);

        return modelAndView;
    }

    /**
     * Error404.
     * 
     * @param request
     *            the request
     * @return the string
     */
    @RequestMapping(value = "404")
    public String error404(HttpServletRequest request) {
        LOGGER.error("Error, Request URL :: " + request.getRequestURL());
        return "redirect:/pageNotFound";
    }

    /**
     * Page not found.
     * 
     * @return the string
     */
    @RequestMapping(value = "pageNotFound")
    public String pageNotFound() {
        return "pageNotFound";
    }

    /**
     * Error400.
     * 
     * @param request
     *            the request
     * @return the string
     */
    @RequestMapping(value = "400")
    public String error400(HttpServletRequest request) {
        LOGGER.error("Error, Request URL :: " + request.getRequestURL());
        return "redirect:/errorPage";
    }

    /**
     * Error400.
     * 
     * @return the string
     */
    @RequestMapping(value = "errorPage")
    public String error400() {
        return "errorPage";
    }

    /**
     * Error405.
     * 
     * @param request
     *            the request
     * @return the string
     */
    @RequestMapping(value = "405")
    public String error405(HttpServletRequest request) {
        LOGGER.error("Error, Request URL :: " + request.getRequestURL());
        return "redirect:/errorPage";
    }
    
 
}