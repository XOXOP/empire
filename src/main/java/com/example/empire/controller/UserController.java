package com.example.empire.controller;
import com.example.empire.entity.Users;
import com.example.empire.servic.ServiceInterfac;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class UserController {
    @Autowired
    private ServiceInterfac serviceInterfac;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("allemplist", serviceInterfac.getAllUsers());
        return "index";
    }

    @GetMapping("/addnew")
    public String addNewEmployee(Model model) {
        Users users = new Users();
        model.addAttribute("employee", users);
        return "newemployee";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("employee") Users users) {
        serviceInterfac.save(users);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") long id, Model model) {
        Users users = serviceInterfac.getById(id);
        model.addAttribute("employee", users);
        return "update";
    }
    @GetMapping("/deleteEmployee/{id}")
    public String deleteThroughId(@PathVariable(value = "id") long id) {
       serviceInterfac.deleteViaId(id);
       return "redirect:/";
    }
}

