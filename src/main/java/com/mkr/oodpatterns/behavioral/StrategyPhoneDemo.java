package com.mkr.oodpatterns.behavioral;

public class StrategyPhoneDemo {
    public static void main(String[] args) {
        PhoneCameraApp basicCamera = new BasicCameraApp();
        basicCamera.setShareStrategy(new Txt());
        basicCamera.take();
        basicCamera.save();

        System.out.println();

        PhoneCameraApp cameraPlus = new CameraPlusApp();
        cameraPlus.setShareStrategy(new EmailX());
        cameraPlus.take();
        cameraPlus.save();
    }
}

abstract class PhoneCameraApp {
    private ShareStrategy strategy;

    abstract void edit();

    public void setShareStrategy(ShareStrategy strategy) {
        this.strategy = strategy;
    }

    public void share() {
        if (strategy != null) {
            strategy.share();
        } else {
            System.out.println("No sharing strategy set.");
        }
    }

    public void take() {
        System.out.println("Taking a photo");
        edit();
        share();
    }

    public void save() {
        System.out.println("Saving the photo");
    }
}

class BasicCameraApp extends PhoneCameraApp {

    @Override
    void edit() {
        System.out.println("Editing the photo in BasicCameraApp");
    }
}

class CameraPlusApp extends PhoneCameraApp {

    @Override
    void edit() {
        System.out.println("Editing the photo in CameraPlusApp");
    }
}

abstract class ShareStrategy {
    public abstract void share();
}

class Txt extends ShareStrategy {
    @Override
    public void share() {
        System.out.println("Sharing via TXT");
    }
}

class EmailX extends ShareStrategy {
    @Override
    public void share() {
        System.out.println("Sharing via EmailX");
    }
}

class SocialX extends ShareStrategy {
    @Override
    public void share() {
        System.out.println("Sharing via SocialX");
    }
}

