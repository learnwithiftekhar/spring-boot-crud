package com.learnwithifte.springBootCrud.controller;

import com.learnwithifte.springBootCrud.model.Customer;
import com.learnwithifte.springBootCrud.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

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
    public String save(@Valid @ModelAttribute("customer") Customer customer, BindingResult bindingResult, Model model) {

        if(bindingResult.hasErrors()) {
            return "/create";
        }

        customerService.save(customer);
        return "redirect:/";
    }

    @GetMapping("customer/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        Customer customer = customerService.findById(id).orElse(null);
        model.addAttribute("customer", customer);
        return "create";
    }

    @GetMapping("customer/{id}/delete")
    public String delete(@PathVariable long id, Model model) {
        Customer customer = customerService.findById(id).orElse(null);
        customerService.delete(customer);
        return "redirect:/";
    }

}
