package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import javax.validation.Valid;

@Controller
public class UserControllerImpl implements UserControllerInt {
    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/"})
    public String allUsers(Model model) {
        model.addAttribute("users", this.userService.getAllUsers());
        return "users";
    }

    @GetMapping({"/{id}"})
    public String getUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", this.userService.getUserById(id));
        return "user";
    }

    @GetMapping({"/new"})
    public String addUser(User user) {
        return "newUser";
    }

    @PostMapping({"/new"})
    public String add(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "newUser";
        } else {
            this.userService.addUser(user);
            return "redirect:/";
        }
    }

    @GetMapping({"{id}/update"})
    public String updateUser(@PathVariable("id") int id, Model model) {
        model.addAttribute(this.userService.getUserById(id));
        return "updateUser";
    }

    @PatchMapping({"/update"})
    public String update(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "updateUser";
        } else {
            this.userService.updateUser(user);
            return "redirect:/";
        }
    }

    @DeleteMapping({"/delete/{id}"})
    public String delete(@PathVariable("id") int id) {
        this.userService.removeUser(id);
        return "redirect:/";
    }
}
