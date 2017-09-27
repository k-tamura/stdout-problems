package org.t246osslab.stdoutproblems.controller;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.t246osslab.stdoutproblems.batch.BatchInterface;

@Controller
public class IndexController {

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MessageSource msg;
    
    @Value("${remote.registry.host}")
    String remoteRegistryHost = "localhost";

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView init(ModelAndView mav, Locale locale) {
        mav.setViewName("index");
        return mav;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView process(ModelAndView mav, Locale locale) {
        mav.setViewName("index");
        try {
            Registry registry = LocateRegistry.getRegistry(remoteRegistryHost);
            BatchInterface batch = (BatchInterface) registry.lookup("execBatch");
            int returnVal = batch.executeBatch();
            if (returnVal != -1) {
                mav.addObject("msg", msg.getMessage("message.batch.executed", null, locale));
            }
            log.info("The return value from the server is: " + returnVal);
        } catch (Exception e) {
            log.error("Exception while trying to echo:", e);
        }
        return mav;
    }

}