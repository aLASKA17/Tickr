package org.example.tickr.user.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.example.tickr.user.UserRole;

@Data
@Getter
@Setter
public class UserResponse {
    private String userName;
    private String userEmail;
    private String userPassword;
    private UserRole userRole;
}
