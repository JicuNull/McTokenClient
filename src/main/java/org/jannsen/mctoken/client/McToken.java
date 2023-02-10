package org.jannsen.mctoken.client;

import com.google.api.client.http.HttpMethods;
import org.jannsen.mcreverse.api.entity.akamai.SensorToken;
import org.jannsen.mctoken.client.request.TokenRequest;
import org.jannsen.mctoken.client.response.Response;
import org.jannsen.mctoken.client.response.TokenResponse;

import javax.annotation.Nonnull;

public class McToken extends McTokenBase {


    public McToken(@Nonnull String apiHost) {
        super(apiHost);
    }

    public TokenResponse getToken() {
        return query(new TokenRequest(), TokenResponse.class, HttpMethods.GET);
    }

    public Response saveToken(SensorToken token) {
        return query(new TokenRequest().setToken(token), Response.class, HttpMethods.POST);
    }
}
