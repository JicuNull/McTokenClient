package org.jannsen.response;

import org.jannsen.response.status.ErrorStatus;
import org.jannsen.response.status.Status;

public class Response {

    private final Status status;

    public Response() {
        this.status = new Status();
    }

    public Response(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public Object getResponse() {
        return null;
    }

    public boolean success() {
        return status.getType().equals(ErrorStatus.OK);
    }
}
