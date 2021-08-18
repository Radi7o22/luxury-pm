package softuni.project.onlinestore.controller;

import org.springframework.web.bind.annotation.*;
import softuni.project.onlinestore.db.model.user.SignUpResponse;
import softuni.project.onlinestore.dto.UserDto;
import softuni.project.onlinestore.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/sign-up")
    public SignUpResponse signUp(
            @RequestBody UserDto userDto) {
        return userService.registerCheckUser(userDto);
    }

    @PostMapping("/update")
    public UserDto update(@RequestBody UserDto userDto) {
        return userService.updateUserProfile(userDto);
    }

    @GetMapping("/{username}")
    public UserDto getUser(@PathVariable(name = "username") String username) {
        return userService.getUserProfile(username);
    }
    
}
