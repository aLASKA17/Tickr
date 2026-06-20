package org.example.tickr.user;

import lombok.RequiredArgsConstructor;
import org.example.tickr.user.dto.UserResponse;
import org.springframework.stereotype.Service;

import static java.lang.System.out;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void createUser(UserResponse userResponse) {
        if (userRepository.findByUserName(userResponse.getUserName()).isPresent() ||
        userRepository.findByUserEmail(userResponse.getUserEmail()).isPresent()) {
            out.println(userResponse);
            throw new RuntimeException("Пользователь уже создан!");
        }

        User user = new User();
        user.setUserName(userResponse.getUserName());
        user.setUserEmail(userResponse.getUserEmail());
        user.setUserPassword(userResponse.getUserPassword());
        user.setUserRole(UserRole.USER);
        userRepository.save(user);
    }

    public void updateUser(UserResponse userResponse) {
        User user = userRepository.findByUserName(userResponse.getUserName())
                .or(() -> userRepository.findByUserEmail(userResponse.getUserEmail()))
                .orElseThrow(() -> new RuntimeException("Пользователь не найден!"));

        if (userResponse.getUserName() != null && !userResponse.getUserName().isEmpty()) {
            user.setUserName(userResponse.getUserName());
        }

        if (userResponse.getUserEmail() != null && !userResponse.getUserEmail().isEmpty()) {
            user.setUserEmail(userResponse.getUserEmail());
        }

        if (userResponse.getUserPassword() != null && !userResponse.getUserPassword().isEmpty()) {
            user.setUserPassword(userResponse.getUserPassword());
        }

        if (userResponse.getUserRole()!= null && userResponse.getUserRole().describeConstable().isPresent()) {
            user.setUserRole(userResponse.getUserRole());
        }

        userRepository.save(user);
    }
}
