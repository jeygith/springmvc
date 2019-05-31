package com.onetoone.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {
    // show form

    @GetMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // process form
    @GetMapping("/processForm")
    public String processForm(@RequestParam(name = "studentName", required = false) String name, Model model) {
        model.addAttribute("studentName", name.toUpperCase());
        return "helloworld";
    }


    @GetMapping("/processFormVersionTwo")
    public String letsShoutDude(@RequestParam(name = "studentName", required = false) String name, Model model) {
        model.addAttribute("message", "Yo!" + name.toUpperCase());


        return "helloworld";
    }
}
