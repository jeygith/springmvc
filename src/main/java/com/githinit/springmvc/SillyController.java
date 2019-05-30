package com.githinit.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SillyController {

    @GetMapping("/showForm")
    public String displayForm() {
        return "silly";
    }
}
