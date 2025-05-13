package com.mkr.oodpatterns.structural;

interface User {
    void printPrivileges();

}

class BasicUser implements User {
    @Override
    public void printPrivileges() {
        System.out.println("Basic User: Can login");
    }
}

public class DecoratorDemo {
    public static void main(String[] args) {
        User user = new BasicUser();
        user.printPrivileges();
    }
}
