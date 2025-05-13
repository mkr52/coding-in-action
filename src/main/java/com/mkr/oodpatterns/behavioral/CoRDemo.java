package com.mkr.oodpatterns.behavioral;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

class LoggerRequest {

    private final String message;
    private final LoggerType loggerType;

    public LoggerRequest(String message, LoggerType loggerType) {
        this.message = message;
        this.loggerType = loggerType;
    }

    public String getMessage() {
        return this.message;
    }

    public LoggerType getLoggerType() {
        return this.loggerType;
    }

    public enum LoggerType {
        CONSOLE,
        FILE
    }

}

abstract class Logger {
    public abstract void log(LoggerRequest request);
}

class ConsoleLogger extends Logger {

    @Override
    public void log(LoggerRequest request) {
        System.out.println(request.getMessage());
    }
}

class FileLogger extends Logger {

    @Override
    public void log(LoggerRequest request) {
        try {
            var writer = new BufferedWriter(new FileWriter("src/main/resources/log.txt", true));
            writer.write(request.getMessage() + "\n");
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

public class CoRDemo {
    public static void main(String[] args) {
        LoggerRequest request = new LoggerRequest("This is a log message", LoggerRequest.LoggerType.CONSOLE);
        Logger logger = new ConsoleLogger();
        logger.log(request);

        request = new LoggerRequest("This is a log message", LoggerRequest.LoggerType.FILE);
        logger = new FileLogger();
        logger.log(request);
    }
}
