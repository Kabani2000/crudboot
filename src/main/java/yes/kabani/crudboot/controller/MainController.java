package yes.kabani.crudboot.controller;

import yes.kabani.crudboot.service.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import yes.kabani.crudboot.model.User;

import java.util.*;

@Controller
@RequestMapping("/admin")
public class MainController {


    private final UserService userService;

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String showUsersTable(ModelMap model, Authentication authentication) {
        model.addAttribute("user", authentication.getPrincipal());
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("roles", userService.getAllRoles());
        return "index";
    }

    @PostMapping("/adduser")
    public String addUser(@RequestParam(value = "role_id", required = false) Set<Long> roleId,
                          @Validated User user) {
        user.setRoles(userService.findByRole(roleId));
        userService.addUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/update/{id}")
    public String updateUser(@RequestParam(value = "role_id") Set<Long> roleId,
                             @Validated User user) {

        user.setRoles(userService.findByRole(roleId));
        userService.updateUser(user);
        return "redirect:/admin";
    }

    @PostMapping("/delete")
    public String deleteUser(@RequestParam("id") long id) {
        User user = userService.findById(id);
        userService.deleteUser(user);
        return "redirect:/admin";
    }
}
