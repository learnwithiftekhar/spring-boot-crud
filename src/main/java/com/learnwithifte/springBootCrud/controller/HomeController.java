package com.learnwithifte.springBootCrud.controller;

import com.learnwithifte.springBootCrud.model.Customer;
import com.learnwithifte.springBootCrud.service.CustomerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    private CustomerService customerService;

    public HomeController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String home(@RequestParam(value = "name", defaultValue = "") String name, Model model) {

        List<Customer> customerList = customerService.findAll();

        model.addAttribute("customerList", customerList);
        return "home";
    }

    @GetMapping("create")
    public String create(Model model) {
        Customer customer = new Customer();
        model.addAttribute("customer", customer);
        return "create";
    }

    @PostMapping("save")
    public String save(@ModelAttribute("customer") Customer customer, Model model) {
        customerService.save(customer);
        return "redirect:/";
    }
}
