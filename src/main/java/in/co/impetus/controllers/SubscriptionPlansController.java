/*
 *  Copyright Impetus @2000-2014
 */
package in.co.impetus.controllers;

import java.util.List;

import in.co.impetus.db.model.Plans;
import in.co.impetus.service.subscriptionplan.SubscriptionPlanService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

// TODO: Auto-generated Javadoc
/**
 * The Class SubscriptionPlansController.
 */
/**
 * @author manish.sharma
 * 
 */
@Controller
public class SubscriptionPlansController {

    /**
     * Gets the subscription plan service.
     * 
     * @return the subscription plan service
     */
    public SubscriptionPlanService getSubscriptionPlanService() {
        return subscriptionPlanService;
    }

    /**
     * Sets the subscription plan service.
     * 
     * @param subscriptionPlanService
     *            the new subscription plan service
     */
    public void setSubscriptionPlanService(
            SubscriptionPlanService subscriptionPlanService) {
        this.subscriptionPlanService = subscriptionPlanService;
    }

    /** The Subscription plan service. */
    @Autowired
    private SubscriptionPlanService subscriptionPlanService;

    /**
     * Gets the form.
     * 
     * @return the form
     */
    @RequestMapping(value = "addSubscriptionPlans.htm", method = RequestMethod.GET)
    public ModelAndView getForm() {
        return new ModelAndView("addSubscriptionPlans");
    }

    /**
     * Listplans.
     * 
     * @return the model and view
     */
    @RequestMapping("subscriptionPlansList.htm")
    public ModelAndView listplans() {

        List<Plans> plansList = subscriptionPlanService.getPlansList();
        ModelAndView modelAndView = new ModelAndView("subscriptionPlansList");
        modelAndView.addObject("plansList", plansList);
        return modelAndView;

    }

    /**
     * Insert user.
     * 
     * @param plans
     *            the plans
     * @return the model and view
     */
    @RequestMapping("subsriptionPlansInsert.htm")
    public ModelAndView insertUser(@ModelAttribute Plans plans) {
        subscriptionPlanService.insertPlans(plans);
        return new ModelAndView("redirect:/forms/subscriptionPlansList.htm");

    }

    /**
     * Edits the plans.
     * 
     * @param planId
     *            the plan id
     * @return the model and view
     */
    @RequestMapping("subsriptionPlansEdit.htm")
    public ModelAndView editPlans(@RequestParam int planId) {
        Plans plans = subscriptionPlanService.getPlanById(planId);
        return new ModelAndView("addSubscriptionPlans", "plans", plans);
    }

    /**
     * Delete user.
     * 
     * @param planId
     *            the plan id
     * @return the model and view
     */
    @RequestMapping(value = "subsriptionPlansDelete.htm", method = RequestMethod.GET)
    public ModelAndView deleteUser(@RequestParam int planId) {
        subscriptionPlanService.deletePlan(planId);
        return new ModelAndView("redirect:/forms/subscriptionPlansList.htm");
    }

}
