package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.model.User;
import web.service.UserServiceEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
@RequiredArgsConstructor
public class UserController {

    private final UserServiceEntity userService;

    @GetMapping(value = "/")
    public ResponseEntity<String> getHomePage() {
        List<User> users = userService.listAll();
        return ResponseEntity.ok(users.toString());
    }

    @GetMapping(value = "/email/{email}")
    public ResponseEntity<String> getUserByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(userService.findByEmail(email).toString());
    }

    @GetMapping(value = "/email")
    public ResponseEntity<String> getUserByNameAndEmail(@RequestParam("name") String name,
                                                        @RequestParam("email") String email) {
        return ResponseEntity.ok(userService.findUserByNameAndEmail(name, email).toString());
    }

    @GetMapping(value = "/email/all/{name}")
    public ResponseEntity<String> getAllUserContainsName(@PathVariable("name") String name) {
        return ResponseEntity.ok(userService.findAllByNameContaining(name).toString());
    }

}