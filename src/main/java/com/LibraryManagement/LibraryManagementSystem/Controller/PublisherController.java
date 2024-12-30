package com.LibraryManagement.LibraryManagementSystem.Controller;

//import com.example.library.model.Publisher;
//import com.example.library.service.PublisherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.LibraryManagement.LibraryManagementSystem.Model.PublisherModel;
import com.LibraryManagement.LibraryManagementSystem.Service.PublisherService;


import java.util.List;

@Controller
@RequestMapping("/publishers")
public class PublisherController {

    private final PublisherService publisherService;

    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }

    @GetMapping
    public String getAllPublishers(Model model) {
        List<PublisherModel> publishers = publisherService.getAllPublishers();
        model.addAttribute("publishers", publishers);
        return "publishers/list";
    }

    @GetMapping("/new")
    public String showCreatePublisherForm(Model model) {
        model.addAttribute("publisher", new PublisherModel());
        return "publishers/form";
    }

    @PostMapping
    public String savePublisher(@ModelAttribute PublisherModel publisher) {
        publisherService.savePublisher(publisher);
        return "redirect:/publishers";
    }

    @GetMapping("/edit/{id}")
    public String showEditPublisherForm(@PathVariable Long id, Model model) {
        PublisherModel publisher = publisherService.getPublisherById(id);
        model.addAttribute("publisher", publisher);
        return "publishers/form";
    }

    @PostMapping("/update/{id}")
    public String updatePublisher(@PathVariable Long id, @ModelAttribute PublisherModel publisher) {
        publisher.setId(id);
        publisherService.savePublisher(publisher);
        return "redirect:/publishers";
    }

    @GetMapping("/delete/{id}")
    public String deletePublisher(@PathVariable Long id) {
        publisherService.deletePublisher(id);
        return "redirect:/publishers";
    }
}
