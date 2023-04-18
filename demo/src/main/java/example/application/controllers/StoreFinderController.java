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
public class StoreFinderController {

    /**
     * The singleton instance of the database connection. This is used to access the
     * database of users.
     */
    private final StaticUserDAO userDAO = new StaticUserDAO();

    @GetMapping("/storefinder")
    public String storefinder(Model model){
        User user = (User) model.getAttribute("user");
        model.addAttribute("user", user);
        model.addAttribute("users", userDAO.listUsers());
        return "store-view";
    }

    @PostMapping("/storenav")
    public String storenav() {return "redirect:/storefinder";}


}
