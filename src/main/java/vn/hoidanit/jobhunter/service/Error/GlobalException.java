package vn.hoidanit.jobhunter.service.Error;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException  {
    @ExceptionHandler(value = IdInvalidException.class)
    public ResponseEntity<String> handlerIdInvalidException(IdInvalidException iie){
      return ResponseEntity.badRequest().body(iie.getMessage());
    }
    
}
