package com.example.mockbus.converters;

import com.example.mockbus.DTO.UserDtoJson;
import com.example.mockbus.entities.UserDomain;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class UserDomainToUserDtoJson implements Converter<UserDomain,UserDtoJson> {
    /**
     * Convert the source object of type {@code S} to target type {@code T}.
     *
     * @param source the source object to convert, which must be an instance of {@code S} (never {@code null})
     * @return the converted object, which must be an instance of {@code T} (potentially {@code null})
     * @throws IllegalArgumentException if the source cannot be converted to the desired target type
     */
    @Override
    public UserDtoJson convert(UserDomain source) {
        UserDtoJson userDtoJson = new UserDtoJson();
        userDtoJson.setId(source.getId());
        userDtoJson.setName(source.getName());
        userDtoJson.setCreated_at(source.getCreatedAt().toString());
        userDtoJson.setUpdated_at(source.getUpdatedAt().toString());
        userDtoJson.setEmail(source.getEmail());
        userDtoJson.setEnabled(source.isEnabled());
        return userDtoJson;
    }
}
