package web.controller;

import org.springframework.ui.Model;
import web.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.service.UserService;

@Controller
public class UserController {

    UserService userService;

    @Autowired
    public void setUsersService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public String getUsers(ModelMap model){
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user, Model model){
        if (user.getId() == 0){
            userService.addUser(user);
            model.addAttribute("users", userService.getUsers());

        } else {
            userService.updateUser(user);
        }
        return "redirect:/users";
    }

    @RequestMapping("/users/delete")
    public String removeUser(@RequestParam("id") long id){
        userService.remove(id);
        return "redirect:/users";
    }

    @RequestMapping("/edit-user")
    public String edit(@RequestParam("id") long id, Model model){
        model.addAttribute("user", userService.getUser(id));
        model.addAttribute("users", userService.getUsers());
        return "edit-user";
    }
}
