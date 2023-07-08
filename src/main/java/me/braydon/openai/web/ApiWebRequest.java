package me.braydon.openai.web;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.Builder;
import lombok.NonNull;
import lombok.ToString;
import me.braydon.openai.web.exception.ApiException;
import me.braydon.openai.web.response.ResponseObject;
import okhttp3.*;

import java.io.IOException;
import java.util.Map;

/**
 * Represents an API request to the OpenAI API.
 *
 * @author Braydon
 */
@Builder @ToString
public final class ApiWebRequest {
    private static final String API_ENDPOINT = "https://api.openai.com/v1"; // The OpenAI API endpoint
    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient();
    private static final Gson GSON = new GsonBuilder()
                                         .serializeNulls()
                                         .create();
    
    /**
     * The method to use in this request.
     */
    @NonNull private final String method;
    
    /**
     * The path to send this request to.
     */
    @NonNull private final String path;
    
    /**
     * The {@link ApiCredentials} to use for authentication.
     */
    @NonNull private final ApiCredentials credentials;
    
    /**
     * The model to use in this request.
     */
    private final String model;
    
    /**
     * The json body to use in this request.
     */
    private final String body;
    
    /**
     * Should we debug this request?
     */
    private final boolean debugging;
    
    /**
     * Execute this request and get
     * the response as the given type.
     *
     * @param responseType the type of the response
     * @param <T>          the type of the response
     * @return the response as the given type
     */
    @NonNull
    public <T extends ResponseObject> T execute(@NonNull Class<T> responseType) {
        // Build the request
        Request.Builder requestBuilder = new Request.Builder()
                                             .url(API_ENDPOINT + path)
                                             .method(method, body == null ? null : RequestBody.create(body, MediaType.parse("application/json")))
                                             .header("Content-Type", "application/json")
                                             .header("Authorization", "Bearer " + credentials.getApiKey());
        // Append organization if present in the credentials
        if (credentials.hasOrganization()) {
            requestBuilder.header("OpenAI-Organization", credentials.getOrganization());
        }
        // Attempt to send the request to the API
        if (debugging) { // Debugging
            System.out.println(String.format("Sending %s request to %s", requestBuilder.getMethod$okhttp(), requestBuilder.getUrl$okhttp()));
            System.out.println("Creds: " + credentials);
            System.out.println("Request Body: " + (body == null ? "n/a" : GSON.toJson(body)));
        }
        try (Response response = HTTP_CLIENT.newCall(requestBuilder.build()).execute()) {
            int httpCode = response.code(); // The HTTP response code
            if (debugging) { // Debugging
                System.out.println("Received HTTP code " + httpCode);
            }
            ResponseBody responseBody = response.body();
            assert responseBody != null; // We need a response body
            String bodyString = responseBody.string();
            JsonObject jsonObject = GSON.fromJson(bodyString, JsonObject.class);
            
            if (debugging) { // Debugging
                System.out.println("Response Body: " + bodyString);
            }
            
            // Handle errors returned from the API
            JsonElement errorJsonElement = jsonObject.get("error");
            if (errorJsonElement != null && (!errorJsonElement.isJsonNull())) {
                JsonObject errorJsonObject = errorJsonElement.getAsJsonObject();
                JsonElement codeJsonElement = errorJsonObject.get("code"); // The json element containing the error code
                
                String code = codeJsonElement.isJsonNull() ? null : codeJsonElement.getAsString(); // The error code
                String type = errorJsonObject.get("type").getAsString(); // The error type
                String message = errorJsonObject.get("message").getAsString(); // The error message
                throw new ApiException(httpCode, code, type, message); // Throw the exception
            }
            // Handle the response
            T typedResponse = GSON.fromJson(bodyString, responseType);
            if (debugging) { // Debugging
                System.out.println("Response: " + typedResponse);
            }
            return typedResponse;
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
    
    /**
     * Build a POST request builder.
     *
     * @param body the json request body
     * @return the request builder
     */
    @NonNull
    public static ApiWebRequestBuilder post(@NonNull String body) {
        return ApiWebRequest.builder().method("POST").body(body);
    }
    
    /**
     * Build a POST request builder.
     *
     * @param mappedBody the mapped request body
     * @return the request builder
     */
    @NonNull
    public static ApiWebRequestBuilder post(@NonNull Map<String, Object> mappedBody) {
        return ApiWebRequest.builder().method("POST").body(GSON.toJson(mappedBody));
    }
    
    /**
     * Build a GET request builder.
     *
     * @return the request builder
     */
    @NonNull
    public static ApiWebRequestBuilder get() {
        return ApiWebRequest.builder().method("GET");
    }
}