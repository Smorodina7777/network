package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Post;
import web.service.PostService;
import web.service.UserServiceEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class PostController {

  private final PostService postService;
  private final UserServiceEntity userService;

@GetMapping(value = "/post/list")
public String userPosts(HttpServletRequest request, Model model) {
  HttpSession session = request.getSession();
  model.addAttribute("postList", postService.findAll());
  return "userPosts";
}

  @PostMapping(value = "/post/add")
  public String addPost(HttpServletRequest request, Post post) {
    postService.save(post);
    return "redirect:/post/list";
  }

  @GetMapping(value = "/post/newPost")
  public String newPost(HttpServletRequest request, Model model) {
    HttpSession session = request.getSession();
    return "newPost";
  }
}