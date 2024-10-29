package com.nibm.ClothingStore.ClothingStore.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login"; // The name of your HTML login template
    }

    @PostMapping("/login")
    public RedirectView authenticate(@RequestParam String email, @RequestParam String password) {
        // Authentication is handled by Spring Security, so no need to manually check credentials here
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null && auth.isAuthenticated()) {
            return new RedirectView("/home"); // Redirect to a home page or dashboard after successful login
        }
        return new RedirectView("/login?error=true"); // Redirect back to login with an error if authentication fails
    }
}
