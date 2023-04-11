package com.pdev.rest.webservices.restfulwebservices.user;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserResource {

    private UserDaoService service;

    public UserResource(UserDaoService service){
        this.service = service;
    }

    @GetMapping(path="/users")
    public List<User> findUsers(){
        return service.findAll();
    }

    @GetMapping(path="/user/{id}")
    public User findUser(@PathVariable Integer id){
        User user = service.findOne(id);

        if(user==null)
            throw new UserNotFoundException("id:"+id);

        return user;
    }

    @DeleteMapping(path="/user/{id}")
    public void deleteUser(@PathVariable Integer id){
        service.deleteById(id);
    }

    @PostMapping(path="/users")
    public ResponseEntity<User> createUser(@RequestBody User user){

        User savedUser = service.saveUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();

    }
}
