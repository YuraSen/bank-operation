package com.senin.bank_operation.controller;

import com.senin.bank_operation.dto.User;
import com.senin.bank_operation.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/")
    public List<User> showAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User showById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping("/")
    public User create(@RequestBody User player) {
        return userService.save(player);
    }

    @PutMapping("/{id}")
    public User edit(@RequestBody User player) {
        return userService.update(player);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.deleteById(id);
    }
}