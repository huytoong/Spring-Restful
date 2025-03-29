package vn.hoidanit.jobhunter.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;

@RestController
public class UserController {
  private final UserService userService;
  
  public UserController(UserService userService){
      this.userService = userService;
  }
  
  @PostMapping("/user")
    public User createNewUser(
      @RequestBody User postManUser 
    ){

      this.userService.handlerCreateUser(postManUser);
      return postManUser;
    }
  
    @DeleteMapping("/user/{id}")
      public String deleteUserById(
        @PathVariable("id") long id
      ){
        this.userService.handlerDeleteUserById(id);
        return "User with ID " + id + "has been deleted successfully !";
      }
}
