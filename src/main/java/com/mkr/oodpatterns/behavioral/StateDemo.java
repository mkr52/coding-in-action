package com.mkr.oodpatterns.behavioral;

class Auction {
    private boolean isOpen;

    public Auction() {
        this.isOpen = false;
    }

    public void startAuction() {
        if(isOpen) {
            System.out.println("Auction is already open.");
        } else {
            isOpen = true;
            System.out.println("Auction started.");
        }
    }

    public void closeAuction() {
        if(!isOpen) {
            System.out.println("Auction is already closed.");
        } else {
            isOpen = false;
            System.out.println("Auction closed.");
        }
    }

    public void placeBid() {
        if(!isOpen) {
            System.out.println("Bid can't be placed. Auction is already closed.");
        } else {
            System.out.println("Bid placed.");
        }
    }

    public void closeBid() {
        if(!isOpen) {
            System.out.println("Bid can't be closed. Auction is already closed.");
        } else {
            System.out.println("Bid closed.");
        }
    }


}
public class StateDemo {

    public static void main(String[] args) {
        var auction = new Auction();
        auction.startAuction();
        auction.placeBid();

        auction.startAuction();

        auction.closeAuction();
        auction.closeBid();

        auction.closeAuction();
    }
}
