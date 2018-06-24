package com.example.mockbus.converters;

import com.example.mockbus.DTO.UserDTO;
import com.example.mockbus.entities.UserDomain;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class UserDtoToUser implements Converter<UserDTO, UserDomain> {
    @Autowired
    PasswordEncoder passwordEncoder;

    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public UserDomain convert(UserDTO source) {
        if (source == null) {
            return null;
        }
        return new UserDomain(source.getName(), source.getEmail(), passwordEncoder.encode(source.getPassword()));
    }
}
