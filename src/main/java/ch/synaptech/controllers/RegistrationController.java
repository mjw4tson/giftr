package ch.synaptech.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mwatson on 11/28/15.
 */
@Controller
public class RegistrationController {

    @RequestMapping("/register")
    String registration() {
        return "register";
    }
}
