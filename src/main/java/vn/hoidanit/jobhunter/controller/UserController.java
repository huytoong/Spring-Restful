package vn.hoidanit.jobhunter.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.boot.actuate.autoconfigure.observation.ObservationProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import vn.hoidanit.jobhunter.domain.User;
import vn.hoidanit.jobhunter.service.UserService;
import vn.hoidanit.jobhunter.service.Error.GlobalException;
import vn.hoidanit.jobhunter.service.Error.IdInvalidException;

import java.util.List;

@RestController
public class UserController {
  private final UserService userService;
  
  public UserController(UserService userService){
      this.userService = userService;
  }
  
  @PostMapping("/users")
    public ResponseEntity<User> createNewUser(
      @RequestBody User postManUser 
    ){

      this.userService.handlerCreateUser(postManUser);
      return ResponseEntity.status(HttpStatus.CREATED).body(postManUser);
    }
  
  @DeleteMapping("/users/{id}")
    public ResponseEntity<String> deleteUserById(
      @PathVariable("id") long id
    ){
      this.userService.handlerDeleteUserById(id);
      String msg = "User with ID " + id + "has been deleted successfully !";
      return ResponseEntity.status(HttpStatus.OK).body(msg);
    }

    @GetMapping("/users/{id}")
      public User getUserById(
        @PathVariable("id") long id
      ) throws IdInvalidException{
        if (id > 10){
          throw new IdInvalidException("id vượt quá giới hạn trong database");
        }
        return this.userService.handlerGetUserById(id) ;
      }
    
    // @ExceptionHandler(value = IdInvalidException.class)
    // public ResponseEntity<String> handlerIdInvalidException(IdInvalidException iie){
    //   return ResponseEntity.badRequest().body(iie.getMessage());
    // }

    @GetMapping("/users")
      public ResponseEntity<List<User>> getAllUser(){
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.handlerGetAllUser());
      }
    
    @PutMapping("/users")
      public ResponseEntity<User> updateUser(
        @RequestBody User userPM
      ){
        return ResponseEntity.status(HttpStatus.OK).body(this.userService.handlerUpdateUser(userPM));
      }
}
