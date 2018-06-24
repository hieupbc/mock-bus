package com.example.mockbus.restcontrollers;

import com.example.mockbus.DTO.UserDtoJson;
import com.example.mockbus.converters.UserDomainToUserDtoJson;
import com.example.mockbus.entities.UserDomain;
import com.example.mockbus.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rest")
public class UserRestController {

    @Autowired
    UserService userService;
    @Autowired
    UserDomainToUserDtoJson userDomainToUserDtoJson;


    /* ---------------- GET ALL USER ------------------------ */
//    @RequestMapping(value = "/users", method = RequestMethod.GET)
//    public ResponseEntity<List<UserDtoJson>> getAllUser() {
//        List<UserDomain> listUser = userService.findAll();
//        List<UserDtoJson> userDtoJsons = new ArrayList<>();
//        listUser.forEach(e->userDtoJsons.add(userDomainToUserDtoJson.convert(e)));
//        return new ResponseEntity<List<UserDtoJson>>(userDtoJsons, HttpStatus.OK);
//    }
    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public ResponseEntity<List<UserDtoJson>> getAllUserPaging(@RequestParam(required = false) Integer page,@RequestParam(required = false) Integer size) {
        if (page==null){
            page=0;
        }
        if (size==null){
            size=2;
        }
        Page<UserDomain> listUser = userService.findAll(page, size);
        List<UserDtoJson> userDtoJsons = new ArrayList<>();
        listUser.getContent().forEach(e->userDtoJsons.add(userDomainToUserDtoJson.convert(e)));
        return new ResponseEntity<List<UserDtoJson>>(userDtoJsons, HttpStatus.OK);
    }

    /* ---------------- GET USER BY ID ------------------------ */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<Object> getUserById(@PathVariable long id) {
        Optional<UserDomain> user = userService.find(id);
        if (user.isPresent()) {
            return new ResponseEntity<Object>(userDomainToUserDtoJson.convert(user.get()), HttpStatus.OK);
        }
        return new ResponseEntity<Object>("Not Found User", HttpStatus.NO_CONTENT);
    }

    /* ---------------- CREATE NEW USER ------------------------ */
    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    public ResponseEntity<String> createUser(@RequestBody UserDomain user) {
        if (userService.isExist(user.getEmail())) {
            return new ResponseEntity<String>("User Already Exist!", HttpStatus.CONFLICT);
        }
        userService.create(user);
        return new ResponseEntity<String>("Created!", HttpStatus.CREATED);
    }

    /* ---------------- DELETE USER ------------------------ */
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> deleteUserById(@PathVariable long id) {
        Optional<UserDomain> user = userService.find(id);
        if (!user.isPresent()) {
            return new ResponseEntity<String>("Not Found User", HttpStatus.OK);
        }

        userService.delete(user.get());
        return new ResponseEntity<String>("Deleted!", HttpStatus.OK);
    }

    /* ---------------- UPDATE USER ------------------------ */
    @RequestMapping(value = "/users", method = RequestMethod.PUT)
    public ResponseEntity<String> updateUser(@RequestBody UserDomain user) {
        Optional<UserDomain> oldUser = userService.findByEmail(user.getEmail());
        if (!oldUser.isPresent()) {
            return new ResponseEntity<String>("Not Found User", HttpStatus.NO_CONTENT);
        }

        // replace old user by new user.
        userService.update(user);
        return new ResponseEntity<String>("Updated!", HttpStatus.OK);
    }

    @RequestMapping(value = "/user/search/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<UserDtoJson>> getUserByEmail(@PathVariable String name,@RequestParam(required = false) Integer page,@RequestParam(required = false) Integer size) {
        if (page==null){
            page=0;
        }
        if (size==null){
            size=2;
        }
        Page<UserDomain> listUser  = userService.findByNameIsLike(name,page,size);
        List<UserDtoJson> userDtoJsons = new ArrayList<>();
        listUser.getContent().forEach(e->userDtoJsons.add(userDomainToUserDtoJson.convert(e)));
        return new ResponseEntity<List<UserDtoJson>>(userDtoJsons, HttpStatus.OK);
    }
}