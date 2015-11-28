package ch.synaptech.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mwatson on 11/27/2015.
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    String index() {
        return "index";
    }
}
