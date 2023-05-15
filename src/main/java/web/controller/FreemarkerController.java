package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import web.model.User;
import web.service.UserServiceEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class FreemarkerController {

    private final UserServiceEntity userService;

    @GetMapping(value = "/")
    public String getHomePage(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Object user = session.getAttribute("user");
        if (user == null) {
            return "login";
        }
        model.addAttribute("user", user);
        return "authorization";
    }

    @PostMapping(value = "/user")
    public String signIn(HttpServletRequest request , User user, Model model) {
        System.out.println(user);
        boolean result = userService.existUser(user.getName(), user.getPassword());
        if (result) {
            User userEntity = userService.getByName(user.getName());
            request.getSession().setAttribute("user", userEntity);
            model.addAttribute("user", userEntity);
            return "authorization";
        }
        System.out.println("Не удалось авторизоваться");
        return "login";
    }

    @GetMapping(value = "/user/list")
    public String userInfo(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        if (session.getAttribute("user") == null) {
            return "login";
        }
        model.addAttribute("userList", userService.listAll());
        return "index";
    }

    @PostMapping(value = "/user/add")
    public String addUser(HttpServletRequest request, User user) {
        userService.addUser(user);
        return "redirect:/user/list";
    }

    @GetMapping(value = "/user/{id}")
    public String deleteUser(@PathVariable("id") Long id, Model model) {
        User user = userService.getById(id);
        userService.deleteUser(user);
        return "redirect:/user/list";
    }

    @GetMapping(value = "/user/new")
    public String newUser(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        return "newUser";
    }
@GetMapping(value = "/user/edit/{id}")
public ModelAndView edit(@PathVariable("id") Long id) {
    User user = userService.getById(id);
    ModelAndView modelAndView = new ModelAndView();
    modelAndView.setViewName("edit");
    modelAndView.addObject("editUser", user);
    return modelAndView;
}
    @PostMapping(value = "/user/edit")
    public String editUser(HttpServletRequest request, User user) {
        userService.addUser(user);
        return "redirect:/user/list";
    }

}