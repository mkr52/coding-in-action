package com.mkr.oodpatterns.behavioral;

public class ChainOfResponsibility {

    public static void main(String[] args) {
        AbstractHandler lowFuelHandler = new LowFuelHandler(null);
        FireHandler fireHandler = new FireHandler(lowFuelHandler);

        LowFuelRequest lowFuelRequest = new LowFuelRequest();

        fireHandler.handleRequest(lowFuelRequest);
    }

    static abstract class AbstractRequest {
        // FireRequest: 1
        // LowFuelRequest: 3
        private int requestCode;

        public AbstractRequest(int requestCode) {
            this.requestCode = requestCode;
        }

        public int getRequestCode() {
            return requestCode;
        }
    }

    static abstract class AbstractHandler {
        private AbstractHandler next;

        public AbstractHandler(AbstractHandler next) {
            this.next = next;
        }

        public void setNext(AbstractHandler next) {
            this.next = next;
        }

        public void handleRequest(AbstractRequest request) {
            if (next != null) {
                next.handleRequest(request);
            } else {
                System.out.println("No handler found for request code: " + request.getRequestCode());
            }
        }
    }

    static class FireRequest extends AbstractRequest {

        public FireRequest() {
            super(1);
        }
    }

    static class LowFuelRequest extends AbstractRequest {

        public LowFuelRequest() {
            super(3);
        }
    }

    static class FireHandler extends AbstractHandler {

        private static int code = 1;
        public FireHandler(AbstractHandler next) {
            super(next);
        }

        @Override
        public void handleRequest(AbstractRequest request) {
            if(code == request.getRequestCode()) {
                System.out.println("Fire request handled request successfully");
            } else {
                super.handleRequest(request);
            }
        }
    }

    static class LowFuelHandler extends AbstractHandler {
        private static int code = 3;
        public LowFuelHandler(AbstractHandler next) {
            super(next);
        }

        @Override
        public void handleRequest(AbstractRequest request) {
            if(code == request.getRequestCode()) {
                System.out.println("Low fuel request handled request successfully");
            } else {
                super.handleRequest(request);
            }
        }
    }

}
