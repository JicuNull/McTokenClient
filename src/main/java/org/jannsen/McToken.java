package org.jannsen;

import com.google.api.client.http.HttpMethods;
import org.jannsen.mcreverse.api.entity.akamai.SensorToken;
import org.jannsen.request.TokenRequest;
import org.jannsen.response.Response;
import org.jannsen.response.TokenResponse;

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
