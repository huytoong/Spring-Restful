package vn.hoidanit.jobhunter.service;

import org.springframework.stereotype.Service;

import vn.hoidanit.jobhunter.repository.UserRepository;
import vn.hoidanit.jobhunter.domain.User;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
      this.userRepository = userRepository;
    }

    public void handlerCreateUser(User user){
      this.userRepository.save(user);
    }

    public void handlerDeleteUserById(long id){
      this.userRepository.deleteById(id);
    }

    public User handlerGetUserById(long id){
      Optional<User> optionalUser = this.userRepository.findById(id);
      if (optionalUser.isPresent()){
        return optionalUser.get();
      }
      return null;
    }

    public List<User> handlerGetAllUser(){
      return this.userRepository.findAll();
    }
}   
