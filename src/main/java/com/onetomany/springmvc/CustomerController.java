package com.onetomany.springmvc;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    // add initbinder to trim strings

    @InitBinder
    public void initBinder(WebDataBinder webDataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);

        webDataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @GetMapping("/showForm")
    public String showForm(Model model) {

        // add student object to the model
        model.addAttribute("customer", new Customer());

        return "customer-form";
    }

    @PostMapping("/processForm")
    public String processForm(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult) {

        System.out.println("Last name: |" + customer.getLastName() + "|");


        System.out.println("Binding result: " + bindingResult);

        System.out.println("\n\n\n");


        if (bindingResult.hasErrors()) {
            return "customer-form";
        }

        //log input data
        System.out.println("customer: " + customer.getFirstName() + " " + customer.getLastName());


        return "customer-confirmation";
    }
}
