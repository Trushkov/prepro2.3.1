package controller;

import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import service.UserService;

@Controller
public class UserController {

    UserService userService;

    @Autowired
    public void setUsersService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/users")
    public String getUsers(ModelMap model){

        model.addAttribute("user", new User());
        model.addAttribute("users", userService.getUsers());
        return "/users";
    }

   /* @RequestMapping(value = "/users/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user){
        if (user.getId() == 0){
            userService.addUser(user);
        } else {
            userService.updateUser(user);
        }
        return "redirect:/users";
    }

    @RequestMapping("/users/{id}")
    public String removeUser(@PathVariable("id") long id){
        userService.removeUserById(id);
        return "redirect:/users";
    }

    @RequestMapping("edit/{id}")
    public String editUsers(@PathVariable("id") long id, Model model){
        model.addAttribute("user", userService.getUser(id));
        model.addAttribute("users", userService.getUsers());
        return "/users";
    }*/
}
