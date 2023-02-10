package org.jannsen.builder;

import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.javanet.NetHttpTransport;
import org.jannsen.request.Request;

import javax.annotation.Nonnull;
import java.io.IOException;

import static com.google.api.client.http.HttpMethods.*;

public class HttpBuilder {

    private Request tokenRequest;
    private String httpMethod = GET;
    private String apiHost;

    public HttpBuilder setTokenRequest(@Nonnull Request request) {
        this.tokenRequest = request;
        return this;
    }

    public HttpBuilder setHttpMethod(@Nonnull String httpMethod) {
        this.httpMethod = httpMethod;
        return this;
    }

    public HttpBuilder setApiHost(@Nonnull String apiHost) {
        this.apiHost = apiHost;
        return this;
    }

    public HttpRequest build() {
        HttpRequest request = createRequest(tokenRequest, httpMethod);
        request.setThrowExceptionOnExecuteError(false);
        request.setSuppressUserAgentSuffix(true);
        request.setNumberOfRetries(3);
        return request;
    }

    private HttpRequest createRequest(Request request, String method) {
        try {
            HttpRequestFactory factory = new NetHttpTransport().createRequestFactory();
            GenericUrl url = new GenericUrl(apiHost + request.getPath());
            return switch (method) {
                case POST, PUT -> factory.buildRequest(method, url, request.getContent());
                default -> factory.buildRequest(method, url, null);
            };
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
