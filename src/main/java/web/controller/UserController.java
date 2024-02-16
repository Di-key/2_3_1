package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;

import web.models.User;
import web.service.UserService;

import javax.transaction.Transactional;
import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String getAllUsers(Model model){
        List<User> allUsers = userService.readAllUsers();
        model.addAttribute("all", allUsers);
        return "all-users";
    }
    @GetMapping("/addNewUser")
    public String newUser(Model model){
        User user = new User();
        model.addAttribute("userAdd", user);
        return "user-create";
    }
    @PostMapping("/saveUser")
    public String create(@ModelAttribute("newUser") User user){
        userService.create(user);
        return "redirect:/";
    }

    @PostMapping("/updateInfo")
    public String updateUser(@ModelAttribute("newUser") User user){
        userService.update(user);
        return "redirect:/";
    }

    @GetMapping("/findUser")
    public String findUser(@RequestParam("userID") int id, Model model ){
        User user = userService.findUser(id);
        model.addAttribute("newUser", user);
        return "user-info";
    }
    //deleteUser
    @GetMapping ("/deleteUser")
    public String deleteUser(@RequestParam("userID") int id){
        userService.delete(id);
        return "redirect:/";
    }
}