package com.rohit.flightreservation.controller;


import com.rohit.flightreservation.Repository.UserRepository;
import com.rohit.flightreservation.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/registration")
    public String ShowRegistration(Model model) {
        model.addAttribute("user",new User());
        return "login/registration";
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String register(@ModelAttribute("user") User user) {
        userRepository.save(user);
        return "login/login";
    }

    @RequestMapping("/login")
    public String ShowLogin(Model model) {
        return "login/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam("email") String email, @RequestParam("password") String password, ModelMap modelMap) {

        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return "findFlight";
        } else {

            modelMap.addAttribute("msg", "nvalid username or password .please tryagain");

        }
        return "login/login";
    }

}
