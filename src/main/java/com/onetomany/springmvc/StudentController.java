package com.onetomany.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {

    @GetMapping("/showForm")
    public String showForm(Model model) {

        // create student object
        Student student = new Student();

        // add student object to the model
        model.addAttribute("student", student);

        return "student-form";
    }

    @PostMapping("/processForm")
    public String processForm(@ModelAttribute("student") Student student) {

        //log input data
        System.out.println("student: " + student.getFirstName() + " " + student.getLastName());

        return "student-confirmation";
    }
}
