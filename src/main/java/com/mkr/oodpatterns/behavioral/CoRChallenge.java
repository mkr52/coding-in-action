package com.mkr.oodpatterns.behavioral;

class WithdrawalRequest {

    private final Double amount;
    private final Currency currency;

    public WithdrawalRequest(double amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Double getAmount() {
        return this.amount;
    }

    public Currency getCurrency() {
        return this.currency;
    }

    public enum Currency {
        USD,
        EUR
    }

}

abstract class ATM {
    protected final ATM nextATM;

    public ATM(ATM nextATM) {
        this.nextATM = nextATM;
    }

    public abstract void dispense(WithdrawalRequest request);
}

class EuroATM extends ATM {

    public EuroATM(ATM nextATM) {
        super(nextATM);
    }

    @Override
    public void dispense(WithdrawalRequest request) {
        if(request.getCurrency() == WithdrawalRequest.Currency.EUR) {
            System.out.println("Dispensing €" + request.getAmount());
        } else if(nextATM != null) {
            nextATM.dispense(request);
        }

    }
}

class USDATM extends ATM {
    public USDATM(ATM nextATM) {
        super(nextATM);
    }

    @Override
    public void dispense(WithdrawalRequest request) {
        if(request.getCurrency() == WithdrawalRequest.Currency.USD) {
            System.out.println("Dispensing ﹩" + request.getAmount());
        } else if(nextATM != null) {
            nextATM.dispense(request);
        }
    }
}

public class CoRChallenge {
    public static void main(String[] args) {
        var request = new WithdrawalRequest(200, WithdrawalRequest.Currency.EUR);
        var atm = buildChain();
        atm.dispense(request);
        request = new WithdrawalRequest(300, WithdrawalRequest.Currency.USD);
        atm.dispense(request);
    }

    public static ATM buildChain() {
        var usdATM = new USDATM(null);
        var euroATM = new EuroATM(usdATM);
        return euroATM;
    }
}
