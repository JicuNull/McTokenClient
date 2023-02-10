package org.jannsen.mctoken.client.request;

import org.jannsen.mcreverse.api.entity.akamai.SensorToken;

public class TokenRequest extends Request {

    private long createdTime;
    private String token;


    public TokenRequest setToken(SensorToken token) {
        this.createdTime = token.getCreatedTime();
        this.token = token.getToken();
        return this;
    }

    @Override
    public String getPath() {
        return "/token";
    }
}
