package web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Post;
import web.model.User;
import web.repository.PostCreateService;
import web.service.PostService;
import web.service.UserServiceEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class PostController {

  private final PostCreateService postCreateService;
  private final PostService postService;
  private final UserServiceEntity userService;

//  @GetMapping(value = "/createCategory")
//  public ResponseEntity<Void> createCategory() {
//    postCreateService.saveThemes();
//    return ResponseEntity.ok().build();
//  }

//  @GetMapping(value = "/createPost")
//  public ResponseEntity<String> createPost() {
//    Post randomPostAndTheme = postCreateService.getRandomPostAndTheme();
//    return ResponseEntity.ok(randomPostAndTheme.toString());
//  }
@GetMapping(value = "/post/list")
public String userPosts(HttpServletRequest request, Model model) {
  HttpSession session = request.getSession();
  model.addAttribute("postList", postService.findAll());
  return "userPosts";
}
//  @GetMapping(value = "/user/{user_id}/post")
//  public String userPosts(@PathVariable("user_id") Long id, Model model) {
//
//    model.addAttribute("userPostList", postService.findAllByUser_id(id));
//    return "userPosts";
//  }
//  @GetMapping(value = "/list")
//  public String userInfo(HttpServletRequest request, Model model, @RequestParam User user) {
//    HttpSession session = request.getSession();
//    model.addAttribute("postList", postService.findByUser(user));
//    return "userPosts";
//  }

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
//  @GetMapping(value = "/findPostByUser")
//  public ResponseEntity<String> findPostByUser(@PathVariable("id") Integer id, Model model) {
//    User user = userService.getById(Long.valueOf(id));
//    return ResponseEntity.ok(postService.findAllByUser(user).toString());

//  @PostMapping(value = "/findPostByUser")
//  public ResponseEntity<String> findPostByUser(@RequestParam User user) {
//    Pageable pageable = PageRequest.of(0,4, Sort.by("pubDate").ascending());
//    return ResponseEntity.ok(postService.findByUserAndPostName(user, pageable.toString()).toString());
//  }
//  @GetMapping(value = "/email/all/{name}")
//  public ResponseEntity<String> getAllUserContainsName(@PathVariable("name") String name) {
//    return ResponseEntity.ok(userService.findAllByNameContaining(name).toString());
//  }

//  @GetMapping(value = "/findPostByDate")
//  public ResponseEntity<String> findPostByDate(@RequestParam LocalDate pubDate) {
//    Pageable pageable = PageRequest.of(0,4, Sort.by("pubDate").ascending());
//    Page<Post> result = postService.findByPubDate(pubDate, pageable);
//    System.out.println(result.getNumber());
//    System.out.println(result.getTotalElements());
//    System.out.println(result.getSize());
//    System.out.println(result.getTotalPages());
//    return ResponseEntity.ok(result.toString());
//  }

  @GetMapping(value = "/post/findAllPosts")
  public ResponseEntity<String> findAllUsers() {
    List<User> all = userService.findAll();
    for (User user : all) {
      for (Post post : user.getPosts()) {
        System.out.println(post);
      }
    }
    return ResponseEntity.ok(all.toString());
  }
}