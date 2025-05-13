package com.mkr.oodpatterns.structural;

interface User {
    void printPrivileges();

}

class BasicUser implements User {
    @Override
    public void printPrivileges() {
        System.out.println("Basic User feature: Can login");
    }
}

abstract class UserDecorator implements User {
    private final User user;

    public UserDecorator(User user) {
        this.user = user;
    }

    @Override
    public void printPrivileges() {
        user.printPrivileges();
    }
}

class AdminUser extends UserDecorator {

    public AdminUser(User user) {
        super(user);
    }

    @Override
    public void printPrivileges() {
        super.printPrivileges();
        System.out.println("Admin User feature: Can manage users");
    }
}

public class DecoratorDemo {
    public static void main(String[] args) {
        User user = new BasicUser();
        user.printPrivileges();

        User adminUser = new AdminUser(user);
        System.out.println("Adding admin privileges:");
        adminUser.printPrivileges();
    }
}
