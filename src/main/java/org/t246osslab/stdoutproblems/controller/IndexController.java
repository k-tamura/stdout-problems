package org.t246osslab.stdoutproblems.controller;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.t246osslab.batch.BatchInterface;

@Controller
public class IndexController {

    @Autowired
    MessageSource msg;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView init(ModelAndView mav, Locale locale) {
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView process(ModelAndView mav, Locale locale) {
        mav.setViewName("index");
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            BatchInterface comp = (BatchInterface) registry.lookup("execBatch");
            int returnVal = comp.executeBatch();
            if (returnVal != -1) {
                mav.addObject("msg", msg.getMessage("message.batch.executed", null, locale));
            }
            System.out.println("The return value from the server is: " + returnVal);
        } catch (Exception e) {
            System.err.println("Exception while trying to echo:");
            e.printStackTrace();
        }

        return mav;
    }

}