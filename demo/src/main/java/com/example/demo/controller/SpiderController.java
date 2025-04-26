package com.example.demo.controller;

import com.example.demo.model.Spider;
import com.example.demo.repository.SpiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;


@Controller
public class SpiderController {

    @Autowired
    private SpiderRepository spiderRepository;

    @GetMapping("/spiders")
    public String getAllSpiders(Model model) {
        List<Spider> spiders = spiderRepository.findAll();
        model.addAttribute("spiders", spiders);
        return "spiders";
    }
    
}
