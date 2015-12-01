package ch.synaptech.controllers;

import ch.synaptech.domain.Present;
import ch.synaptech.services.PresentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by mwatson on 11/28/15.
 */
@Controller
public class PresentController {

    private PresentService presentService;

    @Autowired
    public void setPresentService(PresentService presentService) {
        this.presentService = presentService;
    }

    @RequestMapping(value = "/presents", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("presents", presentService.listAllPresents());
        return "presents";
    }

    @RequestMapping("/present/{id}")
    public String showPresent(@PathVariable Integer id, Model model) {
        model.addAttribute("present", presentService.getPresentById(id));
        return "presentshow";
    }

    @RequestMapping("/present/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("present", presentService.getPresentById(id));
        return "presentform";
    }

    @RequestMapping("/present/new")
    public String newPresent(Model model){
        model.addAttribute("present", new Present());
        return "presentform";
    }

    @RequestMapping(value = "/present", method = RequestMethod.POST)
    public String savePresent(Present present){
        presentService.savePresent(present);
        return "redirect:/present/" + present.getId();
    }

    @RequestMapping("present/delete/{id}")
    public String delete(@PathVariable Integer id){
        presentService.deletePresent(id);
        return "redirect:/presents";
    }

    @RequestMapping("present/purchase/{id}/{purchaserId}")
    public String purchase(@PathVariable Integer id, @PathVariable Integer purchaserId) {
        presentService.purchasePresent(id, purchaserId);
        return "presents";
    }
}
