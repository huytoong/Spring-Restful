package vn.hoidanit.jobhunter.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import vn.hoidanit.jobhunter.service.Error.GlobalException;
import vn.hoidanit.jobhunter.service.Error.IdInvalidException;

@RestController
public class HelloController {

    @GetMapping("/")
    public String getHelloWorld() throws IdInvalidException{
        if (true)
            throw new IdInvalidException("TÙNG Test Exception hê lô");
        return "Hello World ";
    }
    //  @ExceptionHandler(value = IdInvalidException.class)
    // public ResponseEntity<String> handlerIdInvalidException(IdInvalidException iie){
    //   return ResponseEntity.badRequest().body(iie.getMessage());
    // }
}
