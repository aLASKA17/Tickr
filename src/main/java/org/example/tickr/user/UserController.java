package org.example.tickr.user;

import lombok.AllArgsConstructor;
import org.example.tickr.user.dto.UserResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/registration")
    public void registration(@RequestBody UserResponse userResponse) {
        userService.createUser(userResponse);
    }

    @PostMapping("/authorization")
    public void authorization(@RequestBody UserResponse userResponse) {
        userService.updateUser(userResponse);
    }
}
