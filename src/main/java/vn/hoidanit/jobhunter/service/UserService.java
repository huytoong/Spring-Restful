package vn.hoidanit.jobhunter.service;

import org.springframework.stereotype.Service;

import vn.hoidanit.jobhunter.repository.UserRepository;
import vn.hoidanit.jobhunter.domain.User;

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
} 
