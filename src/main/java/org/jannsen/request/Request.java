package org.jannsen.request;

import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.HttpContent;
import com.google.gson.Gson;

public abstract class Request {

    private static final Gson gson = new Gson();

    public abstract String getPath();

    public HttpContent getContent() {
        return ByteArrayContent.fromString("application/json", gson.toJson(this));
    }
}
