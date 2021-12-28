package com.uralkeser.controller;

import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.uralkeser.converter.UserConverter;
import com.uralkeser.dto.UserDto;
import com.uralkeser.entity.User;
import com.uralkeser.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public MappingJacksonValue findAll() {
        List<User> userList;
        userList = userService.findAll();
        List<UserDto> userDtoList = UserConverter.INSTANCE.convertUserListToUserDtoList(userList);

        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("name","lastName");
        SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("UserDtoFilter",filter);
        MappingJacksonValue mapping = new MappingJacksonValue(userDtoList);
        mapping.setFilters(filters);

        return mapping;
    }

    @GetMapping("/{id}")
    public MappingJacksonValue findById(@PathVariable String id) {

        User user = userService.findById(id);
        UserDto userDto = UserConverter.INSTANCE.convertUserToUserDto(user);

        SimpleBeanPropertyFilter filter= SimpleBeanPropertyFilter.filterOutAllExcept("name","lastName");
        SimpleFilterProvider filters = new SimpleFilterProvider().addFilter("UserDtoFilter",filter);
        MappingJacksonValue mapping = new MappingJacksonValue(userDto);
        mapping.setFilters(filters);

        return mapping;
    }

    @PostMapping("")
    public ResponseEntity<Object> save(@RequestBody UserDto userDto) {

        User user = UserConverter.INSTANCE.convertUserDtoToUser(userDto);

        user = userService.save(user);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        userService.deleteById(id);
    }
}
