package example.application.controllers;
import example.data.StaticUserDAO;
import example.data.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


/**
 * Class for the page that lists restaurants/stores nearby
 */
@Controller
public class PrivacyPolicyController {

    /**
     * The singleton instance of the database connection. This is used to access the
     * database of users.
     */
    private final StaticUserDAO userDAO = new StaticUserDAO();

    @GetMapping("/privacyPolicy")
    public String privacyPolicy(Model model){
        User user = (User) model.getAttribute("user");
        model.addAttribute("user", user);
        model.addAttribute("users", userDAO.listUsers());
        return "privacy-view";
    }

    @PostMapping("/privacyPolicynav")
    public String privacyPolicynav() {return "redirect:/privacyPolicy";}


}