package com.githinit.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {
    // show form

    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // process form
    @GetMapping("/processForm")
    public String processForm(@RequestParam(name = "studentName", required = false) String name, Model model) {
        model.addAttribute("studentName",  name.toUpperCase());
        return "helloworld";
    }

}
