package apap.tutorial.haidokter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import apap.tutorial.haidokter.model.UserModel;
import apap.tutorial.haidokter.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    private String addUserSubmit(@ModelAttribute UserModel user){
        userService.addUser(user);
        return "redirect:/";
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.GET)
    public String formChangePassword(Model model){
        model.addAttribute("error", "");
        return "form-update-password";
    }

    @RequestMapping(value = "/change-password", method = RequestMethod.POST)
    public String changePasswordSubmit(@RequestParam String oldPassword, @RequestParam String newPassword,
                                 @RequestParam String passwordConf, Model model){

        UserModel user = userService.getUserByUsername(SecurityContextHolder.getContext().getAuthentication().getName());

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        String error = "";

        if(!encoder.matches(oldPassword, user.getPassword()))
            error += "\nPassword lama salah!";

        if (!newPassword.equals(passwordConf))
            error += "\nPassword baru tidak cocok dengan konfirmasi!";

        if(newPassword.equals(oldPassword))
            error += "\nPassword baru tidak boleh sama dengan password lama!";

        if(error.isEmpty()){
            System.out.println(newPassword);
            if(userService.passwordValidation(newPassword)) {
                user.setPassword(newPassword);
                userService.addUser(user);
                return "update-password";
            }
            error = "\nPassword harus mengandung huruf, angka, dan minimal terdiri dari 8 karakter!";
        }

        model.addAttribute("error",error);
        return "form-update-password";
    }
}
