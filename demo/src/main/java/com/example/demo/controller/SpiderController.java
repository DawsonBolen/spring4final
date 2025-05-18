package com.example.demo.controller;

import com.example.demo.model.Spider;
import com.example.demo.repository.SpiderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequestMapping("/spiders")
public class SpiderController {

    @Autowired
    private SpiderRepository spiderRepository;

    @GetMapping
    public String viewSpiders(Model model) {
        List<Spider> spiders = spiderRepository.findAll();
        model.addAttribute("spiders", spiders);
        return "spiders";
    }

    @GetMapping("/postspider")
    public String showPostSpiderForm(Model model) {
        model.addAttribute("spider", new Spider());
        return "postspider";
    }

    @PostMapping("/create")
    public String addSpider(@ModelAttribute Spider spider) {
        spiderRepository.save(spider);
        return "redirect:/spiders";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteSpider(@PathVariable Long id) {
        spiderRepository.deleteById(id);
        return "redirect:/spiders";
    }

}
