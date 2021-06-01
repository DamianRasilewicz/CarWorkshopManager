package pl.rasilewicz.car_workshop_manager.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.support.SessionStatus;
import pl.rasilewicz.car_workshop_manager.entities.User;
import pl.rasilewicz.car_workshop_manager.services.VLVUserDetails;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/login")
    public String loginForm(Model model){
        model.addAttribute("user", new User());
        return "loginPage/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("user") User user, BindingResult result, HttpSession session) {
        UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
        validatePrinciple(authentication.getPrincipal());
        User loggedInUser = ((VLVUserDetails) authentication.getPrincipal()).getUserDetails();
        logger.error(user.getUserName() + ' ' + user.getPassword());

        if (result.hasErrors()) {
            return "redirect:/login?error";
        }

        session.setAttribute("userName", loggedInUser.getUserName());
        session.setAttribute("userId", loggedInUser.getId());
        if (loggedInUser.getRole().getName().equals("USER")){
            return "redirect:/dashboard/user/home";
        }else{
            return "redirect:/dashboard/admin/home";
        }
    }

    private void validatePrinciple(Object principal) {
        if (!(principal instanceof VLVUserDetails)) {
            throw new  IllegalArgumentException("Principal can not be null!");
        }
    }

    @GetMapping("/logout")
    public String logout(SessionStatus session, HttpSession httpSession) {
        SecurityContextHolder.getContext().setAuthentication(null);
        session.setComplete();
        httpSession.removeAttribute("userName");
        httpSession.removeAttribute("userId");
        return "redirect:/";
    }
}
