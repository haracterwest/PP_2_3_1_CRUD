package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @GetMapping()
    public String getAllUsers(Model model) {
        List<User> users = userService.listUsers();
        model.addAttribute("listUsers", users);
        return "users";
    }

    @GetMapping("/{id}")
    public String getById(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "showUser";
    }

    @GetMapping("/new")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "newUser";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/user";
    }

    @PostMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.update(id, user);
        return "redirect:/user";
    }

    @GetMapping(value = "/{id}/edit")
    public String editUser(Model model, @PathVariable("id") int id) {
        model.addAttribute("user", userService.getById(id));
        return "editUser";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        userService.delete(id);
        return "redirect:/user";
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

//    @GetMapping(value = "/users")
//    public String getUsers(Model model) {
//        List<String> messages = new ArrayList<>();
//        messages.add("Hello!");
//        messages.add("I'm Spring MVC application");
//        messages.add("5.2.0 version by sep'19 ");
//        model.addAttribute("messages", messages);
//        return "users";


}

