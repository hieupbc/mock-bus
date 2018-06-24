package com.example.mockbus.securities;

import com.example.mockbus.entities.RoleDomain;
import com.example.mockbus.entities.UserDomain;
import com.example.mockbus.exceptions.AccountDeactivedException;
import com.example.mockbus.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserDomain> userDomainByEmail = userRepository.findUserDomainByEmail(s);
        if (!userDomainByEmail.isPresent()){
            throw  new UsernameNotFoundException(s);
        }
       
        UserDomain userDomain = userDomainByEmail.get();
        Set<RoleDomain> roles = userDomain.getRoles();
        Set<GrantedAuthority> authorities = new HashSet<>();
        roles.forEach(e->authorities.add(new SimpleGrantedAuthority(e.getName().toString())));
        return new User(userDomain.getEmail(),userDomain.getPassword(),userDomain.isEnabled(),true,true,true,authorities);
    }
}
