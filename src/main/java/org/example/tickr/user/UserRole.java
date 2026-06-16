package org.example.tickr.user;

enum UserRole {
    USER("Пользователь"),
    ADMIN("Администратор"),
    PREMIUM_USER ("Премиум пользователь");

    private String titleUser;

    UserRole(String titleUser) {
        this.titleUser = titleUser;
    }
}
