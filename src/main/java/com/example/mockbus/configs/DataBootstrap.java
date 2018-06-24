package com.example.mockbus.configs;

import com.example.mockbus.entities.RoleDomain;
import com.example.mockbus.entities.RoleName;
import com.example.mockbus.entities.UserDomain;
import com.example.mockbus.repositories.RoleRepository;
import com.example.mockbus.repositories.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Component
public class DataBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private static Logger logger = LogManager.getLogger();

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    PasswordEncoder passwordEncoder;
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    @Transactional
    public void onApplicationEvent(ContextRefreshedEvent event) {

        RoleDomain adminRole = new RoleDomain();
        adminRole.setName(RoleName.ROLE_ADMIN);
        roleRepository.save(adminRole);
        RoleDomain userRole = new RoleDomain();
        userRole.setName(RoleName.ROLE_USER);
        roleRepository.save(userRole);
        RoleDomain employeeRole = new RoleDomain();
        employeeRole.setName(RoleName.ROLE_EMPLOYEE);
        roleRepository.save(employeeRole);

        UserDomain userDomain = new UserDomain();
        userDomain.setEmail("hieupbc@gmail.com");
        userDomain.setName("Hieu Hoang");
        userDomain.setPassword(passwordEncoder.encode("123"));
        Set<RoleDomain> roles = userDomain.getRoles();
        roles.add(adminRole);
        roles.add(employeeRole);
        userDomain.setRoles(roles);
        userRepository.save(userDomain);
        
        userDomain = new UserDomain();
        userDomain.setEmail("member@gmail.com");
        userDomain.setName("Member");
        userDomain.setPassword(passwordEncoder.encode("123"));
        roles = userDomain.getRoles();
        roles.add(employeeRole);
        userDomain.setRoles(roles);
        userRepository.save(userDomain);
        
        userDomain = new UserDomain();
        userDomain.setEmail("admin@gmail.com");
        userDomain.setName("Admin");
        userDomain.setPassword(passwordEncoder.encode("123"));
        roles = userDomain.getRoles();
        roles.add(employeeRole);
        userDomain.setRoles(roles);
        userRepository.save(userDomain);

        userDomain = new UserDomain();
        userDomain.setEmail("customer@gmail.com");
        userDomain.setName("Customer");
        userDomain.setPassword(passwordEncoder.encode("123"));
        roles = userDomain.getRoles();
        roles.add(userRole);
        userDomain.setRoles(roles);
        userRepository.save(userDomain);
        
        userDomain = new UserDomain();
        userDomain.setEmail("deactived@gmail.com");
        userDomain.setName("Deactived");
        userDomain.setPassword(passwordEncoder.encode("123"));
        userDomain.setEnabled(false);
        roles = userDomain.getRoles();
        roles.add(userRole);
        userDomain.setRoles(roles);
        userRepository.save(userDomain);
    }
}
