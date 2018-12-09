package com.imooc.security.imoocsecuritydemo.web.controller;

import com.fasterxml.jackson.annotation.JsonView;
import com.imooc.security.imoocsecuritydemo.dto.User;
import com.imooc.security.imoocsecuritydemo.dto.UserQueryCondition;
import org.springframework.core.style.ToStringStyler;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping
    public User create(@Valid @RequestBody User user, BindingResult errors){

        if(errors.hasErrors()){
            errors.getAllErrors().stream().forEach(error -> System.out.println(error+":"+error.getDefaultMessage()));
        }

        System.out.println(user.toString());
        System.out.println(user.getBirthday());
        user.setId("1");
        return user;
    }

    //@RequestMapping(value = "/user",method = RequestMethod.GET)
    @GetMapping
    @JsonView(User.UserSimpleView.class)
    public List<User> query(UserQueryCondition condition,@PageableDefault(page = 2,size = 17,sort = "username,asc") Pageable pageable){

        System.out.println(condition.toString());
        System.out.println(pageable.getPageSize());
        System.out.println(pageable.getPageNumber());
        System.out.println(pageable.getSort());

        List<User> users = new ArrayList<>();
        users.add(new User());
        users.add(new User());
        users.add(new User());
        return users;
    }

    //@RequestMapping(value = "/user/{id:\\d+}",method = RequestMethod.GET)
    @GetMapping("/{id:\\d+}")
    @JsonView(User.UserDetailView.class)
    public User getInfo(@PathVariable String id){
        User user = new User();
        user.setUsername("tom");
        return user;
    }

}
