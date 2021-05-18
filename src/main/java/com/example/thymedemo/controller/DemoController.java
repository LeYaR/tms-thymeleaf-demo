package com.example.thymedemo.controller;

import com.example.thymedemo.model.DemoModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class DemoController {
    private static final Set<DemoModel> DEMO_MODELS = new HashSet<>();

    static {
        DEMO_MODELS.add(new DemoModel("iphone", 123));
        DEMO_MODELS.add(new DemoModel("book", 321));
        DEMO_MODELS.add(new DemoModel("chair", 567));
    }

    @GetMapping("/demo")
    public String demos(Model model) {
        model.addAttribute("demos", DEMO_MODELS);
        return "demo";
    }

    @PostMapping("/demo")
    public String addDemo(@ModelAttribute DemoModel demo) {
        if (demo != null) {
            DEMO_MODELS.add(demo);
        }
        return "redirect:/demo";
    }
}
