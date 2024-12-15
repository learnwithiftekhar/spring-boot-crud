package com.learnwithifte.springBootCrud.controller;

import com.learnwithifte.springBootCrud.model.Customer;
import com.learnwithifte.springBootCrud.service.CustomerService;
import com.learnwithifte.springBootCrud.service.FileUploadService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    private CustomerService customerService;

    public HomeController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String home(@RequestParam(value = "name", defaultValue = "") String name, Model model) {

        List<Customer> customerList = customerService.getAllCustomers();

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
    public String save(
            @Valid @ModelAttribute("customer") Customer customer,
            BindingResult bindingResult, Model model,
            RedirectAttributes redirectAttributes,
            @RequestParam("image") MultipartFile multipartFile) throws IOException {

        if(bindingResult.hasErrors()) {
            return "/create";
        }

        if(!multipartFile.isEmpty()) {
            String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());

            customer.setPhoto(fileName);

            Customer savedCustomer = customerService.save(customer);

            String uploadDir = "customer-photos/"+savedCustomer.getId();
            FileUploadService.saveFile(uploadDir, fileName, multipartFile);

        }




//

        redirectAttributes.addFlashAttribute("message", "Customer saved successfully");
        return "redirect:/";
    }

    @GetMapping("/customer/{id}")
    public String customer(@PathVariable Long id, Model model) {
        Optional<Customer> customer = customerService.findById(id);

        customer.ifPresent(value -> model.addAttribute("customer", value));

        return "show";
    }

    @GetMapping("customer/{id}/edit")
    public String edit(@PathVariable long id, Model model) {
        Customer customer = customerService.findById(id).orElse(null);
        model.addAttribute("customer", customer);
        return "create";
    }

    @GetMapping("customer/{id}/delete")
    public String delete(@PathVariable long id, Model model, RedirectAttributes redirectAttributes) {
        customerService.deleteById(id);
        redirectAttributes.addFlashAttribute("message", "Customer deleted successfully");
        return "redirect:/";
    }

}
