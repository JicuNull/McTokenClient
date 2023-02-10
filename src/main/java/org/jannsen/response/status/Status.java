package org.jannsen.response.status;

public class Status {

    private final String type, message;

    public Status() {
        this.type = ErrorStatus.OK;
        this.message = "";
    }

    public Status(String type, String message) {
        this.type = type;
        this.message = message;
    }

    public String getType() {
        return type;
    }

    public String getMessage() {
        return message;
    }
}
