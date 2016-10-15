package mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mvc.model.Customer;
import mvc.model.Order;
import mvc.service.CustomerService;
import mvc.util.HibernateUtil;

/**
 * @author OmidPourhadi [AT] gmail [DOT] com
 * http://localhost:8080/mvc/welcome
 */
@Controller
@RequestMapping("/welcome")
public class HelloController
{

    
    @Autowired
    CustomerService customerService;
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView helloWorld()
    {
        Order load = customerService.load();
        //cm is a hibernate proxy and this is why combination of Spring and Hibernate sucks
        Customer cm = load.getCustomer();
        //to use in UI with JSF you should unproxy the object
        //this is why combination of JSF and Spring sucks
        Customer unproxyCustomer = HibernateUtil.unproxy(cm);
        //System.out.println(load.getCustomer().getName());
        String message = "Welcome to mvc";
        return new ModelAndView("welcome", "message", message);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView helloPost(Customer customer)
    {
        String message = "post successfull";
        System.out.println(customer.getName());
        ModelAndView mv = new ModelAndView("welcome", "message", message);
        System.out.println(customer.getOrder());
        return mv;
    }

}
