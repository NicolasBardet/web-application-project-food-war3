package example.application.controllers;

import example.data.StaticUserDAO;
import example.data.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
public class MainPageController {
    private final StaticUserDAO userDAO = new StaticUserDAO();

    @GetMapping("mainPage")
    public String mainPage(Model model) {
        User user = (User) model.getAttribute("user");
        model.addAttribute("user", user);
        model.addAttribute("users", userDAO.listUsers());
        return "main-page-view";
    }
    /**
     * Navigates to account information page.
     *
     * @return The name of the view to display.
     */
    @PostMapping("/account")
    public String account() {
        return "redirect:/main";
    }

    @PostMapping("/mainpage")
    public String mainpage(){return "redirect:/mainPage";}
}
