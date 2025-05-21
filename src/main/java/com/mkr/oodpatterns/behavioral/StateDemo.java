package com.mkr.oodpatterns.behavioral;

class Auction {
    private AuctionState state;

    public Auction() {
        this.state = new AuctionClosed();
    }

    public void startAuction() {
        state.startAuction(this);
    }

    public void closeAuction() {
        state.closeAuction(this);
    }

    public void placeBid() {
        state.placeBid();
    }

    public void closeBid() {
        state.closeBid();
    }

    public void setState(AuctionState state) {
        this.state = state;
    }
}

interface AuctionState {
    // define methods that depend on the state
    void startAuction(Auction auction);
    void closeAuction(Auction auction);
    void placeBid();
    void closeBid();
}

class AuctionStarted implements AuctionState {

    @Override
    public void startAuction(Auction auction) {
        System.out.println("Auction is already started.");
    }

    @Override
    public void closeAuction(Auction auction) {
        auction.setState(new AuctionClosed());
        System.out.println("Auction closed.");
    }

    @Override
    public void placeBid() {
        System.out.println("Bid placed.");
    }

    @Override
    public void closeBid() {
        System.out.println("Bid closed.");
    }
}

class AuctionClosed implements AuctionState {

    @Override
    public void startAuction(Auction auction) {
        auction.setState(new AuctionStarted());
        System.out.println("Auction started");
    }

    @Override
    public void closeAuction(Auction auction) {
        System.out.println("Auction is already closed.");
    }

    @Override
    public void placeBid() {
        System.out.println("Bid can't be placed. Auction is already closed.");
    }

    @Override
    public void closeBid() {
        System.out.println("Bid can't be closed. Auction is already closed.");
    }
}

public class StateDemo {

    public static void main(String[] args) {
        var auction = new Auction();
        auction.startAuction();
        auction.placeBid();

        auction.startAuction();

        auction.placeBid();
        auction.closeBid();
        auction.closeAuction();
        auction.closeBid();

        auction.closeAuction();
    }
}
