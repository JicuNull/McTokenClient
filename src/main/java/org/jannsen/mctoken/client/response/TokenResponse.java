package org.jannsen.mctoken.client.response;

import org.jannsen.mcreverse.api.entity.akamai.SensorToken;
import org.jannsen.mctoken.client.response.status.Status;

public class TokenResponse extends Response {

    private SensorToken response;

    public TokenResponse(SensorToken token) {
        this.response = token;
    }

    public TokenResponse(Status status) {
        super(status);
    }

    @Override
    public SensorToken getResponse() {
        return response;
    }
}
