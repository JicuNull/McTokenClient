package org.jannsen;

import com.google.api.client.http.HttpRequest;
import com.google.api.client.http.HttpResponse;
import com.google.gson.Gson;
import org.jannsen.builder.HttpBuilder;
import org.jannsen.request.Request;
import org.jannsen.response.Response;
import org.jannsen.response.status.ErrorStatus;
import org.jannsen.response.status.Status;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class McTokenBase {

    private static final Gson gson = new Gson();
    private final String apiUri;

    public McTokenBase(String apiUri) {
        this.apiUri = apiUri;
    }

    <T extends Response> T query(Request request, Class<T> clazz, String httpMethod) {
        HttpRequest httpRequest = configureBuilder(request, httpMethod).build();
        return execute(httpRequest, clazz);
    }

    private <T extends Response> T execute(HttpRequest request, Class<T> clazz) {
        try {
            HttpResponse httpResponse = request.execute();
            String content = httpResponse.parseAsString();
            if(!content.isEmpty()) {
                return gson.fromJson(content, clazz);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return createFallbackResponse(clazz);
    }

    private HttpBuilder configureBuilder(Request request, String httpMethod) {
        return new HttpBuilder().setTokenRequest(request).setHttpMethod(httpMethod).setApiHost(apiUri);
    }

    public <T extends Response> T createFallbackResponse(Class<T> clazz) {
        try {
            Status status = new Status("Undefined Error", ErrorStatus.UNDEFINED_ERROR);
            return clazz.getConstructor(Status.class).newInstance(status);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
