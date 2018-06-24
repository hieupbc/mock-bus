package com.example.mockbus.services.Impl;

import com.example.mockbus.DTO.UserDTO;
import com.example.mockbus.converters.UserDtoToUser;
import com.example.mockbus.entities.RoleDomain;
import com.example.mockbus.entities.RoleName;
import com.example.mockbus.entities.UserDomain;
import com.example.mockbus.exceptions.UnsuccessfulException;
import com.example.mockbus.exceptions.UserAlreadyExistException;
import com.example.mockbus.repositories.RoleRepository;
import com.example.mockbus.repositories.UserRepository;
import com.example.mockbus.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserServiceImpl extends BaseServiceImpl<UserDomain, Long> implements UserService {


    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        super(userRepository);
    }

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserDtoToUser userDtoToUser;

    public  String convertSearchName(String name){
        return "%".concat(name).concat("%");
    }

    @Override
    public boolean isExist(String email) {
        Optional<UserDomain> userDomainByEmail = userRepository.findUserDomainByEmail(email);
        return userDomainByEmail.isPresent();
    }

    @Override
    public List<UserDomain> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserDomain> findByEmail(String email) {
        return userRepository.findUserDomainByEmail(email);
    }

    @Override
    public Page<UserDomain> findByNameIsLike(String name, int page, int size) {
        return this.findByNameIsLike(name, PageRequest.of(page,size));
    }

    @Override
    public List<UserDomain> findByNameIsLike(String name) {
        return userRepository.findUserDomainByNameIsLike(this.convertSearchName(name));
    }

    public Page<UserDomain> findByNameIsLike(String name, Pageable pageable) {
        return userRepository.findUserDomainByNameIsLike(convertSearchName(name),pageable);
    }

    @Override
    @Transactional
    public UserDomain registerNewUser(UserDTO userDTO) {
        if (userDTO==null){
            throw new UnsuccessfulException("Object can not be null");
        }
        if (isExist(userDTO.getEmail())) {
            throw new UserAlreadyExistException("There is an account with that email adress: " + userDTO.getEmail());
        }
        UserDomain convert = userDtoToUser.convert(userDTO);
        Set<RoleDomain> roles = convert.getRoles();
        roles.add(roleRepository.findRoleDomainByName(RoleName.ROLE_USER).get());
        convert.setRoles(roles);
        UserDomain userDomain = this.create(convert);
        return userDomain;
    }

}
