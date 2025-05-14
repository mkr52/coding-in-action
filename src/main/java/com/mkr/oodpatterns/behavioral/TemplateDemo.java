package com.mkr.oodpatterns.behavioral;

class WelcomeEmail extends Email{

    @Override
    public void sendMessageBody() {
        System.out.println("Thank you for signing up for our service.");
    }

}

class UnsubscribeEmail extends Email {

    @Override
    public void sendMessageBody() {
        System.out.println("We are sorry to see you go." );
    }

}

abstract class Email {

    public void sendGreeting() {
        System.out.println("Hello,");
    }

    public abstract void sendMessageBody();

    public void sendClosing() {
        System.out.println("Best regards, Sam");
    }
}

public class TemplateDemo {

    public static void main(String[] args) {
        var welcomeEmail = new WelcomeEmail();
        welcomeEmail.sendGreeting();
        welcomeEmail.sendMessageBody();
        welcomeEmail.sendClosing();

        var unsubscribeEmail = new UnsubscribeEmail();
        unsubscribeEmail.sendGreeting();
        unsubscribeEmail.sendMessageBody();
        unsubscribeEmail.sendClosing();
    }

}
