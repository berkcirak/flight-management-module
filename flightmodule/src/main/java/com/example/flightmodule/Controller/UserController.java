package com.example.flightmodule.Controller;

import com.example.flightmodule.entity.User;
import com.example.flightmodule.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/users")
@Controller
public class UserController {

    private UserService userService;
    public  UserController(UserService userService){
        this.userService=userService;
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user){
        User user1=userService.save(user);
        return "redirect:/users/list";
    }
    @GetMapping("/add")
    public String showFormForAdd(Model theModel){
        User theUser=new User();
        theModel.addAttribute("user",theUser);
        return "users/add-user";
    }


    @GetMapping("/list")
    public String listUsers(Model theModel){
        List<User> users=userService.findAll();
        theModel.addAttribute("users",users);
        return "users/list-users";
    }

    @GetMapping("/update")
    public String update(@RequestParam("userId")int theId,Model theModel){
        User user=userService.findById(theId);
        theModel.addAttribute("user",user);
        return "users/add-user";
    }

    @GetMapping("/delete")
    public String deleteUser(@RequestParam("userId") int theId){
        userService.deleteById(theId);
        return "redirect:/users/list";
    }
}
