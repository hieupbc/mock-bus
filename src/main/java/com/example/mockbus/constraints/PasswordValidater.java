package com.example.mockbus.constraints;

import com.example.mockbus.DTO.UserDTO;
import com.example.mockbus.annotations.PasswordMatches;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidater implements ConstraintValidator<PasswordMatches, UserDTO> {
    public void initialize(PasswordMatches constraint) {
    }

    @Override
    public boolean isValid(UserDTO userDTO, ConstraintValidatorContext constraintValidatorContext) {
        return userDTO.getPassword().equals(userDTO.getRetypedPassword());
    }
}
