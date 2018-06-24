package com.example.mockbus.constraints;

import com.example.mockbus.annotations.UniqueEmail;
import com.example.mockbus.repositories.UserRepository;
import com.example.mockbus.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailUniqueValidator implements ConstraintValidator<UniqueEmail, String> {
   @Autowired
   UserService userService;
   public void initialize(UniqueEmail constraint) {
   }

   public boolean isValid(String obj, ConstraintValidatorContext context) {
      return !userService.isExist(obj);
   }
}
