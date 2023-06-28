package BankOfArt.controller;

import BankOfArt.dto.UserDto;
import BankOfArt.model.entity.User;
import BankOfArt.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserService userService;

    @GetMapping("/users")
    public UserDto createUser(){
        return new UserDto();
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody UserDto userDto) {
        User user = userService.createUserByAdmin(userDto);
        if (userService.saveUser(user)) {
            return ResponseEntity.ok("User created successfully");
        } else {
            return ResponseEntity.badRequest().body("Error creating user. Please try again");
        }
    }
}
